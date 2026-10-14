package com.fiscalapi.webhooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiscalapi.models.webhooks.WebhookEvent;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Verificación de las entregas de webhooks de FiscalAPI, que se firman con Standard Webhooks
 * (https://www.standardwebhooks.com): HMAC-SHA256 sobre {@code webhook-id.webhook-timestamp.cuerpo} con el secreto
 * {@code whsec_…} del webhook, en el header {@code webhook-signature} como {@code v1,<base64>}. La firma es la única
 * prueba de que una entrega viene de FiscalAPI.
 *
 * <p>Errores: una entrega que no se puede tratar como auténtica lanza {@link WebhookVerificationException} (rechace la
 * entrega sin procesarla, por ejemplo con un 400); un argumento null, un secreto que no es base64, una lista de secretos
 * vacía o una tolerancia negativa lanzan {@link IllegalArgumentException}: es un error de configuración del receptor, no
 * de la entrega, y el mensaje nunca incluye el valor del secreto.</p>
 *
 * <p>Responda 2xx rápido y procese el evento después, fuera de la petición: FiscalAPI corta cada intento a los 15 s y
 * lo reintenta.</p>
 */
public final class Webhook {

    /**
     * Diferencia máxima entre {@code webhook-timestamp} y el reloj del receptor, hacia atrás o hacia adelante: una
     * entrega capturada no se puede repetir después.
     */
    public static final Duration DEFAULT_TOLERANCE = Duration.ofMinutes(5);

    private static final String ID_HEADER = "webhook-id";
    private static final String TIMESTAMP_HEADER = "webhook-timestamp";
    private static final String SIGNATURE_HEADER = "webhook-signature";
    private static final String SIGNATURE_VERSION = "v1";
    private static final String SIGNATURE_SEPARATOR = " ";
    private static final char VERSION_SEPARATOR = ',';
    private static final String SECRET_PREFIX = "whsec_";
    private static final String HMAC_SHA256 = "HmacSHA256";
    // Long.MAX_VALUE tiene 19 dígitos: uno más largo no son segundos Unix y no se intenta convertir.
    private static final int MAX_TIMESTAMP_DIGITS = 19;
    private static final String SINGLE_SECRET = "El secreto de firma";

    // Un lector propio, nunca el ObjectMapper del cliente HTTP ni uno del integrador: campos nuevos del sobre no rompen
    // a un SDK anterior y un contenido después del evento se rechaza. createdAt queda en UTC con los valores por omisión
    // de Jackson (zona de contexto UTC, no la de la JVM, y ADJUST_DATES_TO_CONTEXT_TIME_ZONE activo). ObjectReader es
    // inmutable y seguro entre hilos.
    private static final ObjectReader ENVELOPE_READER = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
            .build()
            .readerFor(WebhookEvent.class);

    private Webhook() {
    }

    /**
     * Verifica una entrega con el secreto del webhook y la tolerancia por omisión ({@link #DEFAULT_TOLERANCE}) y
     * devuelve su evento.
     *
     * @param headers Los headers de la petición recibida, como {@code Map<String, String>} o
     *                {@code Map<String, List<String>>} (servlet, {@code HttpHeaders} de Spring); los nombres se comparan
     *                sin distinguir mayúsculas
     * @param body    El cuerpo <b>crudo</b> tal como llegó, leído como texto UTF-8 antes de deserializarlo. Un cuerpo
     *                deserializado y vuelto a serializar cambia sus bytes (espacios, orden, escapes) y su firma deja de
     *                coincidir
     * @param secret  El secreto del webhook ({@code whsec_…}); se acepta también sin el prefijo
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException Falta un header, el timestamp está fuera de la tolerancia, ninguna firma
     *                                      {@code v1} coincide, el cuerpo no es UTF-8 válido o no es un evento
     * @throws IllegalArgumentException     Un argumento es null o el secreto no es base64
     */
    public static WebhookEvent verify(Map<String, ?> headers, String body, String secret) {
        return verify(headers, body, secret, DEFAULT_TOLERANCE);
    }

    /**
     * Verifica una entrega con el secreto del webhook y devuelve su evento.
     *
     * @param headers   Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body      El cuerpo <b>crudo</b> tal como llegó, sin reserializar
     * @param secret    El secreto del webhook ({@code whsec_…}); se acepta también sin el prefijo
     * @param tolerance Diferencia máxima entre {@code webhook-timestamp} y el reloj del receptor
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica o no es un evento: recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, el secreto no es base64 o la tolerancia es negativa
     */
    public static WebhookEvent verify(Map<String, ?> headers, String body, String secret, Duration tolerance) {
        return verifyWithKeys(headers, text(body), singleKey(secret), tolerance, Instant.now());
    }

    /**
     * Verifica una entrega con varios secretos y la tolerancia por omisión, y devuelve su evento: basta que una firma
     * {@code v1} del header coincida con uno de ellos. Sirve durante una rotación, mientras el receptor despliega el
     * secreto nuevo y conserva el anterior (FiscalAPI firma con ambos durante 24 h).
     *
     * @param headers Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body    El cuerpo <b>crudo</b> tal como llegó, sin reserializar
     * @param secrets Los secretos aceptados ({@code whsec_…}, o sin el prefijo); al menos uno
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica o no es un evento: recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, no hay secretos o uno no es base64 (el mensaje indica
     *                                      su posición, nunca su valor)
     */
    public static WebhookEvent verify(Map<String, ?> headers, String body, List<String> secrets) {
        return verify(headers, body, secrets, DEFAULT_TOLERANCE);
    }

    /**
     * Verifica una entrega con varios secretos y devuelve su evento (ver {@link #verify(Map, String, List)}).
     *
     * @param headers   Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body      El cuerpo <b>crudo</b> tal como llegó, sin reserializar
     * @param secrets   Los secretos aceptados ({@code whsec_…}, o sin el prefijo); al menos uno
     * @param tolerance Diferencia máxima entre {@code webhook-timestamp} y el reloj del receptor
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica o no es un evento: recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, no hay secretos, uno no es base64 o la tolerancia es
     *                                      negativa
     */
    public static WebhookEvent verify(Map<String, ?> headers, String body, List<String> secrets, Duration tolerance) {
        return verify(headers, body, secrets, tolerance, Instant.now());
    }

    /**
     * Verifica una entrega a partir de los bytes crudos del cuerpo, con el secreto del webhook y la tolerancia por
     * omisión ({@link #DEFAULT_TOLERANCE}), y devuelve su evento.
     *
     * @param headers Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body    Los bytes del cuerpo tal como llegaron (por ejemplo, {@code @RequestBody byte[]} en Spring); se
     *                leen como UTF-8 estricto
     * @param secret  El secreto del webhook ({@code whsec_…}); se acepta también sin el prefijo
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica, el cuerpo no es UTF-8 válido o no es un evento:
     *                                      recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null o el secreto no es base64
     */
    public static WebhookEvent verify(Map<String, ?> headers, byte[] body, String secret) {
        return verify(headers, body, secret, DEFAULT_TOLERANCE);
    }

    /**
     * Verifica una entrega a partir de los bytes crudos del cuerpo, con el secreto del webhook, y devuelve su evento.
     *
     * @param headers   Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body      Los bytes del cuerpo tal como llegaron; se leen como UTF-8 estricto
     * @param secret    El secreto del webhook ({@code whsec_…}); se acepta también sin el prefijo
     * @param tolerance Diferencia máxima entre {@code webhook-timestamp} y el reloj del receptor
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica, el cuerpo no es UTF-8 válido o no es un evento:
     *                                      recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, el secreto no es base64 o la tolerancia es negativa
     */
    public static WebhookEvent verify(Map<String, ?> headers, byte[] body, String secret, Duration tolerance) {
        return verifyWithKeys(headers, utf8Text(body), singleKey(secret), tolerance, Instant.now());
    }

    /**
     * Verifica una entrega a partir de los bytes crudos del cuerpo, con varios secretos y la tolerancia por omisión
     * (ver {@link #verify(Map, String, List)}), y devuelve su evento.
     *
     * @param headers Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body    Los bytes del cuerpo tal como llegaron; se leen como UTF-8 estricto
     * @param secrets Los secretos aceptados ({@code whsec_…}, o sin el prefijo); al menos uno
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica, el cuerpo no es UTF-8 válido o no es un evento:
     *                                      recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, no hay secretos o uno no es base64 (el mensaje indica
     *                                      su posición, nunca su valor)
     */
    public static WebhookEvent verify(Map<String, ?> headers, byte[] body, List<String> secrets) {
        return verify(headers, body, secrets, DEFAULT_TOLERANCE);
    }

    /**
     * Verifica una entrega a partir de los bytes crudos del cuerpo, con varios secretos (ver
     * {@link #verify(Map, String, List)}), y devuelve su evento.
     *
     * @param headers   Los headers de la petición recibida (ver {@link #verify(Map, String, String)})
     * @param body      Los bytes del cuerpo tal como llegaron; se leen como UTF-8 estricto
     * @param secrets   Los secretos aceptados ({@code whsec_…}, o sin el prefijo); al menos uno
     * @param tolerance Diferencia máxima entre {@code webhook-timestamp} y el reloj del receptor
     * @return El evento del cuerpo verificado
     * @throws WebhookVerificationException La entrega no es auténtica, el cuerpo no es UTF-8 válido o no es un evento:
     *                                      recházela sin procesarla
     * @throws IllegalArgumentException     Un argumento es null, no hay secretos, uno no es base64 o la tolerancia es
     *                                      negativa
     */
    public static WebhookEvent verify(Map<String, ?> headers, byte[] body, List<String> secrets, Duration tolerance) {
        return verify(headers, body, secrets, tolerance, Instant.now());
    }

    /** La verificación contra el momento {@code now} del receptor. */
    static WebhookEvent verify(Map<String, ?> headers, String body, List<String> secrets, Duration tolerance,
                               Instant now) {
        return verifyWithKeys(headers, text(body), decodeSecrets(secrets), tolerance, now);
    }

    /** La verificación de los bytes del cuerpo contra el momento {@code now} del receptor. */
    static WebhookEvent verify(Map<String, ?> headers, byte[] body, List<String> secrets, Duration tolerance,
                               Instant now) {
        return verifyWithKeys(headers, utf8Text(body), decodeSecrets(secrets), tolerance, now);
    }

    // El cuerpo llega como texto o como bytes; los bytes se decodifican después de validar los headers y el timestamp,
    // así un header faltante se informa antes que un cuerpo ilegible, igual que con el texto.
    private static WebhookEvent verifyWithKeys(Map<String, ?> headers, Supplier<String> body, List<byte[]> keys,
                                               Duration tolerance, Instant now) {
        requireArgument(headers != null, "Los headers no pueden ser null.");
        requireArgument(tolerance != null, "La tolerancia no puede ser null.");
        requireArgument(!tolerance.isNegative(), "La tolerancia no puede ser negativa.");

        String id = requiredHeader(headers, ID_HEADER);
        String timestamp = requiredHeader(headers, TIMESTAMP_HEADER);
        String signatures = requiredHeader(headers, SIGNATURE_HEADER);

        ensureWithinTolerance(timestamp, tolerance, now);
        String text = body.get();
        ensureSigned(keys, signedContent(id, timestamp, text), signatures);
        return readEvent(text);
    }

    private static Supplier<String> text(String body) {
        requireArgument(body != null, "El cuerpo no puede ser null.");
        return () -> body;
    }

    // UTF-8 estricto: new String(bytes, UTF_8) cambiaría los bytes inválidos por U+FFFD en silencio.
    private static Supplier<String> utf8Text(byte[] body) {
        requireArgument(body != null, "El cuerpo no puede ser null.");
        return () -> {
            try {
                return StandardCharsets.UTF_8.newDecoder()
                        .onMalformedInput(CodingErrorAction.REPORT)
                        .onUnmappableCharacter(CodingErrorAction.REPORT)
                        .decode(ByteBuffer.wrap(body))
                        .toString();
            } catch (CharacterCodingException invalid) {
                throw notUtf8(invalid);
            }
        };
    }

    private static List<byte[]> singleKey(String secret) {
        return Collections.singletonList(decodeSecret(secret, SINGLE_SECRET));
    }

    private static List<byte[]> decodeSecrets(List<String> secrets) {
        requireArgument(secrets != null, "La lista de secretos de firma no puede ser null.");
        requireArgument(!secrets.isEmpty(), "Se necesita al menos un secreto de firma (whsec_…).");

        List<byte[]> keys = new ArrayList<>(secrets.size());
        for (int position = 0; position < secrets.size(); position++) {
            keys.add(decodeSecret(secrets.get(position), SINGLE_SECRET + " en la posición " + position));
        }
        return keys;
    }

    // Los mensajes nombran el secreto por su posición y nunca incluyen su valor: terminarían en los logs del receptor.
    private static byte[] decodeSecret(String secret, String description) {
        requireArgument(secret != null, description + " es null.");

        String encoded = secret.startsWith(SECRET_PREFIX) ? secret.substring(SECRET_PREFIX.length()) : secret;
        String notBase64 = description + " no es whsec_ seguido de base64: cópielo completo del webhook.";
        byte[] key;
        try {
            key = Base64.getDecoder().decode(encoded);
        } catch (IllegalArgumentException invalid) {
            throw new IllegalArgumentException(notBase64);
        }
        requireArgument(key.length > 0, description + " está vacío.");
        // Solo la forma canónica: getDecoder() acepta un base64 sin relleno, y un secreto truncado al copiarlo sería otra
        // llave con la que toda entrega fallaría como "Ninguna firma", ocultando el error de configuración.
        requireArgument(Base64.getEncoder().encodeToString(key).equals(encoded), notBase64);
        return key;
    }

    private static String requiredHeader(Map<String, ?> headers, String name) {
        for (Map.Entry<String, ?> header : headers.entrySet()) {
            if (name.equalsIgnoreCase(header.getKey())) {
                String value = headerText(name, header.getValue());
                if (value == null || value.isEmpty()) {
                    break;
                }
                return value;
            }
        }
        throw new WebhookVerificationException("Falta el header " + name + ".");
    }

    // Un header con varios valores (varias líneas en la petición) se une con un espacio, el separador de firmas de
    // Standard Webhooks: se consideran todas las firmas, y un id o timestamp repetido no verifica.
    private static String headerText(String name, Object value) {
        if (value == null || value instanceof String) {
            return (String) value;
        }
        if (value instanceof Iterable) {
            List<String> values = new ArrayList<>();
            for (Object item : (Iterable<?>) value) {
                requireArgument(item == null || item instanceof String,
                        "El header " + name + " debe ser texto o una lista de textos.");
                if (item != null && !((String) item).isEmpty()) {
                    values.add((String) item);
                }
            }
            return String.join(SIGNATURE_SEPARATOR, values);
        }
        throw new IllegalArgumentException("El header " + name + " debe ser texto o una lista de textos.");
    }

    private static void ensureWithinTolerance(String timestamp, Duration tolerance, Instant now) {
        long seconds = unixSeconds(timestamp);
        // Sin overflow: seconds está en [0, Long.MAX_VALUE] y now es positivo, así que la resta cabe en un long.
        if (Math.abs(now.getEpochSecond() - seconds) > tolerance.getSeconds()) {
            throw new WebhookVerificationException("El header " + TIMESTAMP_HEADER + " difiere más de "
                    + tolerance.getSeconds() + " s del reloj del receptor: puede ser una entrega repetida o un reloj "
                    + "desajustado.");
        }
    }

    // Solo dígitos ASCII: Long.parseLong aceptaría un signo + o -, y dígitos de otros alfabetos.
    private static long unixSeconds(String timestamp) {
        boolean digitsOnly = timestamp.length() <= MAX_TIMESTAMP_DIGITS;
        for (int i = 0; digitsOnly && i < timestamp.length(); i++) {
            char c = timestamp.charAt(i);
            digitsOnly = c >= '0' && c <= '9';
        }
        if (digitsOnly) {
            try {
                return Long.parseLong(timestamp);
            } catch (NumberFormatException beyondLong) {
                // 19 dígitos por encima de Long.MAX_VALUE: tampoco son segundos Unix.
            }
        }
        throw new WebhookVerificationException(
                "El header " + TIMESTAMP_HEADER + " no es un número de segundos Unix.");
    }

    // UTF-8 estricto: getBytes(UTF_8) cambiaría un sustituto suelto por '?' en silencio y se firmarían otros bytes.
    private static byte[] signedContent(String id, String timestamp, String body) {
        try {
            ByteBuffer encoded = StandardCharsets.UTF_8.newEncoder()
                    .onMalformedInput(CodingErrorAction.REPORT)
                    .onUnmappableCharacter(CodingErrorAction.REPORT)
                    .encode(CharBuffer.wrap(id + "." + timestamp + "." + body));
            byte[] content = new byte[encoded.remaining()];
            encoded.get(content);
            return content;
        } catch (CharacterCodingException invalid) {
            throw notUtf8(invalid);
        }
    }

    private static void ensureSigned(List<byte[]> keys, byte[] signedContent, String signatureHeader) {
        List<byte[]> expected = new ArrayList<>(keys.size());
        for (byte[] key : keys) {
            expected.add(sign(key, signedContent));
        }
        for (String entry : signatureHeader.split(SIGNATURE_SEPARATOR)) {
            byte[] signature = v1Signature(entry);
            if (signature == null) {
                continue;
            }
            for (byte[] candidate : expected) {
                // Tiempo constante (desde Java 7u6): el tiempo de respuesta no revela cuántos bytes coinciden. El largo
                // de una firma v1 es público (44), así que salir antes por largo no filtra nada.
                if (MessageDigest.isEqual(candidate, signature)) {
                    return;
                }
            }
        }
        throw new WebhookVerificationException("Ninguna firma " + SIGNATURE_VERSION + " del header " + SIGNATURE_HEADER
                + " coincide con el cuerpo y el secreto.");
    }

    // El base64 de una entrada "v1,<base64>"; null si es de otra versión o no tiene versión. Se compara como texto contra
    // el base64 canónico del HMAC: un base64 inválido o no canónico (sin '=', otros bits de relleno) nunca coincide.
    private static byte[] v1Signature(String entry) {
        int separator = entry.indexOf(VERSION_SEPARATOR);
        if (separator < 0 || !SIGNATURE_VERSION.equals(entry.substring(0, separator))) {
            return null;
        }
        return entry.substring(separator + 1).getBytes(StandardCharsets.UTF_8);
    }

    // La firma v1 en su base64 canónico, como texto ASCII.
    private static byte[] sign(byte[] key, byte[] content) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            mac.init(new SecretKeySpec(key, HMAC_SHA256));
            return Base64.getEncoder().encode(mac.doFinal(content));
        } catch (GeneralSecurityException unavailable) {
            // HmacSHA256 es obligatorio en toda JVM (Java SE); llegar aquí es un JRE roto, no una entrega inválida.
            throw new IllegalStateException("La JVM no ofrece " + HMAC_SHA256 + ".", unavailable);
        }
    }

    private static WebhookEvent readEvent(String body) {
        String notAnEvent = "El cuerpo firmado no es un evento de webhook en JSON.";
        WebhookEvent event;
        try {
            event = ENVELOPE_READER.readValue(body);
        } catch (JsonProcessingException invalid) {
            throw new WebhookVerificationException(notAnEvent, invalid);
        }
        // El JSON literal null se lee sin error, pero no es un evento.
        if (event == null) {
            throw new WebhookVerificationException(notAnEvent);
        }
        return event;
    }

    private static WebhookVerificationException notUtf8(CharacterCodingException cause) {
        return new WebhookVerificationException("El cuerpo o un header no es texto UTF-8 válido.", cause);
    }

    private static void requireArgument(boolean valid, String message) {
        if (!valid) {
            throw new IllegalArgumentException(message);
        }
    }
}
