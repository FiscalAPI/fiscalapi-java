package com.fiscalapi.webhooks;

import com.fiscalapi.models.webhooks.WebhookEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Webhook.verify: la firma Standard Webhooks (HMAC-SHA256 sobre webhook-id.webhook-timestamp.cuerpo) y la tolerancia
 * del timestamp. Los mismos escenarios viven en los SDK de .NET, Node.js, Python y PHP. El momento de la verificación
 * se fija con la sobrecarga de paquete, así el vector oficial (de 2021) verifica sin depender del reloj.
 */
class WebhookVerifyTest {

    // El vector publicado por Standard Webhooks (https://github.com/standard-webhooks/standard-webhooks): no es un secreto.
    private static final String OFFICIAL_SECRET = "whsec_MfKQ9r8GKYqrTwjUPD8ILPZIo2LaLaSw";
    private static final String OFFICIAL_ID = "msg_p5jXN8AQM9LWM0D4loKWxJek";
    private static final long OFFICIAL_TIMESTAMP = 1614265330L;
    private static final String OFFICIAL_BODY = "{\"test\": 2432232314}";
    private static final String OFFICIAL_SIGNATURE = "v1,g0hM9SsE+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE=";

    private static final Instant OFFICIAL_MOMENT = Instant.ofEpochSecond(OFFICIAL_TIMESTAMP);

    @Test
    void theOfficialVectorVerifies() {
        assertNotNull(verifyAt(OFFICIAL_MOMENT, officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void aTamperedSignatureIsRejected() {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature", "v1,g0hM9SsF+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE=");

        assertNoSignatureMatches(() -> verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void aTamperedBodyIsRejected() {
        assertNoSignatureMatches(() ->
                verifyAt(OFFICIAL_MOMENT, officialHeaders(), "{\"test\": 2432232315}", OFFICIAL_SECRET));
    }

    @Test
    void aBodyReformattedAfterSigningIsRejected() {
        // Mismo JSON sin el espacio: verificar exige el cuerpo crudo, no uno reserializado.
        assertNoSignatureMatches(() ->
                verifyAt(OFFICIAL_MOMENT, officialHeaders(), "{\"test\":2432232314}", OFFICIAL_SECRET));
    }

    @Test
    void aTamperedIdIsRejected() {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-id", "msg_otro");

        assertNoSignatureMatches(() -> verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void aTimestampOlderThanTheToleranceIsRejectedAndTheBoundaryIsAccepted() {
        Duration tolerance = Webhook.DEFAULT_TOLERANCE;

        verifyAt(OFFICIAL_MOMENT.plus(tolerance), officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET);
        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT.plus(tolerance).plusSeconds(1), officialHeaders(), OFFICIAL_BODY,
                        OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("webhook-timestamp"), exception.getMessage());
        assertTrue(exception.getMessage().contains("difiere"), exception.getMessage());
    }

    @Test
    void aTimestampFurtherInTheFutureThanTheToleranceIsRejectedAndTheBoundaryIsAccepted() {
        Duration tolerance = Webhook.DEFAULT_TOLERANCE;

        verifyAt(OFFICIAL_MOMENT.minus(tolerance), officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET);
        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT.minus(tolerance).minusSeconds(1), officialHeaders(), OFFICIAL_BODY,
                        OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("difiere"), exception.getMessage());
    }

    @Test
    void theDefaultToleranceIsFiveMinutes() {
        assertEquals(Duration.ofMinutes(5), Webhook.DEFAULT_TOLERANCE);
    }

    @Test
    void aCustomToleranceReplacesTheDefault() {
        Duration tolerance = Duration.ofSeconds(30);
        List<String> secrets = Collections.singletonList(OFFICIAL_SECRET);

        Webhook.verify(officialHeaders(), OFFICIAL_BODY, secrets, tolerance, OFFICIAL_MOMENT.plus(tolerance));
        assertThrows(WebhookVerificationException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, secrets, tolerance, OFFICIAL_MOMENT.plusSeconds(31)));
    }

    @Test
    void aNegativeOrMissingToleranceIsRefused() {
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET, Duration.ofSeconds(-1)));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, Collections.singletonList(OFFICIAL_SECRET),
                        Duration.ofSeconds(-1)));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET, null));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1614265330.5", "-1614265330", " 1614265330", "1614265330000000000000", "abc",
            // Long.parseLong aceptaría estos tres: un signo +, dígitos que no son ASCII y un valor que no cabe en long.
            "+1614265330", "１６１４２６５３３０", "9999999999999999999"})
    void aTimestampThatIsNotUnixSecondsIsRejected(String timestamp) {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-timestamp", timestamp);

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("segundos Unix"), exception.getMessage());
    }

    @Test
    void theLargestUnixTimestampIsRejectedByTheToleranceWithoutOverflowing() {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-timestamp", "9223372036854775807");

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("difiere"), exception.getMessage());
    }

    @Test
    void aTimestampAlteredWithinTheToleranceIsRejectedBecauseItIsSigned() {
        long alteredTimestamp = OFFICIAL_TIMESTAMP + 1;
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-timestamp", Long.toString(alteredTimestamp));

        assertNoSignatureMatches(() ->
                verifyAt(Instant.ofEpochSecond(alteredTimestamp), headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "v1a,g0hM9SsE+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE=",
            "v2,g0hM9SsE+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE=",
            "g0hM9SsE+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE=",
            "v1,",
            "v1,!!!",
            // La firma correcta sin su '=' final: solo cuenta la forma canónica, como en los demás SDK.
            "v1,g0hM9SsE+OTPJTGt/tmIKtSyZlE3uFJELVlNIOLJ1OE"})
    void aSignatureHeaderWithoutAValidV1SignatureIsRejected(String signature) {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature", signature);

        assertNoSignatureMatches(() -> verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void aBodyWithALoneSurrogateIsRejectedEvenWhenSignedOverItsReplacementCharacter() {
        // Un sustituto suelto no tiene UTF-8: getBytes(UTF_8) lo cambia por '?' en silencio y verificaría otros bytes.
        String body = "{\"test\": \"" + '\uD800' + "\"}";
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature", BackWebhookSigner.sign(OFFICIAL_ID, OFFICIAL_TIMESTAMP, body, OFFICIAL_SECRET));

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, body, OFFICIAL_SECRET));
        assertInstanceOf(CharacterCodingException.class, exception.getCause());
    }

    @Test
    void contentAfterTheSignedEventIsRejected() {
        String body = "{\"id\":\"evt_1\"} {\"id\":\"evt_2\"}";
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature", BackWebhookSigner.sign(OFFICIAL_ID, OFFICIAL_TIMESTAMP, body, OFFICIAL_SECRET));

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, body, OFFICIAL_SECRET));
        assertNotNull(exception.getCause());
    }

    @ParameterizedTest
    @ValueSource(strings = {"webhook-id", "webhook-timestamp", "webhook-signature"})
    void aMissingOrEmptyHeaderIsRejectedNamingIt(String header) {
        Map<String, String> missing = officialHeaders();
        missing.remove(header);
        Map<String, String> empty = officialHeaders();
        empty.put(header, "");

        for (Map<String, String> headers : Arrays.asList(missing, empty)) {
            WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                    verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
            assertEquals("Falta el header " + header + ".", exception.getMessage());
        }
    }

    @Test
    void headerNamesAreCaseInsensitive() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Webhook-Id", OFFICIAL_ID);
        headers.put("WEBHOOK-TIMESTAMP", Long.toString(OFFICIAL_TIMESTAMP));
        headers.put("Webhook-Signature", OFFICIAL_SIGNATURE);

        assertNotNull(verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void multiValuedHeadersAsServletsAndSpringGiveThemAreAccepted() {
        // Map<String, List<String>>, como HttpHeaders de Spring o un mapa armado con HttpServletRequest#getHeaders.
        Map<String, List<String>> headers = new TreeMap<>();
        headers.put("Webhook-Id", Collections.singletonList(OFFICIAL_ID));
        headers.put("Webhook-Timestamp", Collections.singletonList(Long.toString(OFFICIAL_TIMESTAMP)));
        // Dos líneas del header de firma: se consideran todas, como si llegaran separadas por un espacio.
        headers.put("Webhook-Signature",
                Arrays.asList("v1,AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=", OFFICIAL_SIGNATURE));

        assertNotNull(verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));

        headers.put("Webhook-Id", Collections.<String>emptyList());
        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
        assertEquals("Falta el header webhook-id.", exception.getMessage());
    }

    @Test
    void aHeaderValueThatIsNotTextIsAConfigurationError() {
        Map<String, Object> headers = new HashMap<>(officialHeaders());
        headers.put("webhook-id", 42);

        assertThrows(IllegalArgumentException.class, () -> verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY,
                OFFICIAL_SECRET));
    }

    @Test
    void aSecretWithoutTheWhsecPrefixVerifies() {
        assertNotNull(verifyAt(OFFICIAL_MOMENT, officialHeaders(), OFFICIAL_BODY,
                OFFICIAL_SECRET.substring("whsec_".length())));
    }

    @Test
    void anyValidV1SignatureAmongSeveralVerifies() {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature",
                "v1,AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA= v1a,ignorada malformada " + OFFICIAL_SIGNATURE);

        assertNotNull(verifyAt(OFFICIAL_MOMENT, headers, OFFICIAL_BODY, OFFICIAL_SECRET));
    }

    @Test
    void anyOfSeveralSecretsVerifiesDuringARotation() {
        String otherSecret = BackWebhookSigner.generateSecret();

        assertNotNull(Webhook.verify(officialHeaders(), OFFICIAL_BODY, Arrays.asList(otherSecret, OFFICIAL_SECRET),
                Webhook.DEFAULT_TOLERANCE, OFFICIAL_MOMENT));
        assertNoSignatureMatches(() -> Webhook.verify(officialHeaders(), OFFICIAL_BODY,
                Collections.singletonList(otherSecret), Webhook.DEFAULT_TOLERANCE, OFFICIAL_MOMENT));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "whsec_", "whsec_%%no-es-base64%%"})
    void aMalformedSecretIsRefusedAsAConfigurationErrorWithoutItsValue(String secret) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, secret));
        assertFalse(exception.getMessage().contains("no-es-base64"), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // Truncado: sin relleno, Base64.getDecoder() lo aceptaría como otra llave y todo fallaría con "Ninguna firma".
            "whsec_MfKQ9r8GKYqrTwjUPD8ILPZIo2LaLaS",
            "whsec_MfKQ9r8GKYqrTwjUPD8ILPZIo2LaLaSw\n",
            "whsec_MfKQ9r8GKYqrTwjUPD8 ILPZIo2LaLaSw"})
    void aSecretThatIsNotCanonicalBase64IsRefusedNamingItsPositionWithoutItsValue(String secret) {
        IllegalArgumentException single = assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, secret));
        assertFalse(single.getMessage().contains("MfKQ9r8G"), single.getMessage());

        IllegalArgumentException inList = assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, Arrays.asList(OFFICIAL_SECRET, secret)));
        assertTrue(inList.getMessage().contains("posición 1"), inList.getMessage());
        assertFalse(inList.getMessage().contains("MfKQ9r8G"), inList.getMessage());
    }

    @Test
    void theOfficialVectorVerifiesFromTheRawBodyBytes() {
        byte[] body = OFFICIAL_BODY.getBytes(StandardCharsets.UTF_8);

        assertNotNull(Webhook.verify(officialHeaders(), body, Collections.singletonList(OFFICIAL_SECRET),
                Webhook.DEFAULT_TOLERANCE, OFFICIAL_MOMENT));
    }

    @Test
    void rawBodyBytesThatAreNotUtf8AreRejected() {
        byte[] body = {'{', '"', 't', '"', ':', '"', (byte) 0xC3, '(', '"', '}'};

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                Webhook.verify(officialHeaders(), body, Collections.singletonList(OFFICIAL_SECRET),
                        Webhook.DEFAULT_TOLERANCE, OFFICIAL_MOMENT));
        assertEquals("El cuerpo o un header no es texto UTF-8 válido.", exception.getMessage());
        assertInstanceOf(CharacterCodingException.class, exception.getCause());
    }

    @Test
    void aMissingHeaderIsReportedBeforeTheBodyBytesAreDecoded() {
        Map<String, String> headers = officialHeaders();
        headers.remove("webhook-id");
        byte[] body = {(byte) 0xC3, '('};

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                Webhook.verify(headers, body, Collections.singletonList(OFFICIAL_SECRET), Webhook.DEFAULT_TOLERANCE,
                        OFFICIAL_MOMENT));
        assertEquals("Falta el header webhook-id.", exception.getMessage());
    }

    @Test
    void theRawBodyBytesOverloadsVerifyAgainstTheCurrentTime() {
        long now = Instant.now().getEpochSecond();
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-timestamp", Long.toString(now));
        headers.put("webhook-signature", BackWebhookSigner.sign(OFFICIAL_ID, now, OFFICIAL_BODY, OFFICIAL_SECRET));
        byte[] body = OFFICIAL_BODY.getBytes(StandardCharsets.UTF_8);
        List<String> secrets = Collections.singletonList(OFFICIAL_SECRET);

        assertNotNull(Webhook.verify(headers, body, OFFICIAL_SECRET));
        assertNotNull(Webhook.verify(headers, body, secrets));
        assertNotNull(Webhook.verify(headers, body, OFFICIAL_SECRET, Duration.ofMinutes(1)));
        assertNotNull(Webhook.verify(headers, body, secrets, Duration.ofMinutes(1)));
        assertThrows(IllegalArgumentException.class, () -> Webhook.verify(headers, (byte[]) null, OFFICIAL_SECRET));
        assertThrows(IllegalArgumentException.class, () -> Webhook.verify(headers, (byte[]) null, secrets));
    }

    @Test
    void aMalformedSecretInAListNamesItsPositionWithoutItsValue() {
        IllegalArgumentException malformed = assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY,
                        Arrays.asList(OFFICIAL_SECRET, "whsec_%%no-es-base64%%")));
        assertTrue(malformed.getMessage().contains("posición 1"), malformed.getMessage());
        assertFalse(malformed.getMessage().contains("no-es-base64"), malformed.getMessage());

        IllegalArgumentException nullInList = assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, Arrays.asList(OFFICIAL_SECRET, null)));
        assertTrue(nullInList.getMessage().contains("posición 1"), nullInList.getMessage());
    }

    @Test
    void missingArgumentsAndAnEmptySecretListAreRefused() {
        assertThrows(IllegalArgumentException.class, () -> Webhook.verify(null, OFFICIAL_BODY, OFFICIAL_SECRET));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), (String) null, OFFICIAL_SECRET));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, (String) null));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, (List<String>) null));
        assertThrows(IllegalArgumentException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, Collections.<String>emptyList()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"no es json", "null", "[]"})
    void aCorrectlySignedBodyThatIsNotAnEventIsRejected(String body) {
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-signature", BackWebhookSigner.sign(OFFICIAL_ID, OFFICIAL_TIMESTAMP, body, OFFICIAL_SECRET));

        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                verifyAt(OFFICIAL_MOMENT, headers, body, OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("no es un evento"), exception.getMessage());
        if (!"null".equals(body)) {
            assertNotNull(exception.getCause());
        }
    }

    @Test
    void thePublicOverloadsVerifyAgainstTheCurrentTime() {
        long now = Instant.now().getEpochSecond();
        Map<String, String> headers = officialHeaders();
        headers.put("webhook-timestamp", Long.toString(now));
        headers.put("webhook-signature", BackWebhookSigner.sign(OFFICIAL_ID, now, OFFICIAL_BODY, OFFICIAL_SECRET));

        assertNotNull(Webhook.verify(headers, OFFICIAL_BODY, OFFICIAL_SECRET));
        assertNotNull(Webhook.verify(headers, OFFICIAL_BODY, Collections.singletonList(OFFICIAL_SECRET)));
        assertNotNull(Webhook.verify(headers, OFFICIAL_BODY, OFFICIAL_SECRET, Duration.ofMinutes(1)));
        assertNotNull(Webhook.verify(headers, OFFICIAL_BODY, Collections.singletonList(OFFICIAL_SECRET),
                Duration.ofMinutes(1)));
        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, () ->
                Webhook.verify(officialHeaders(), OFFICIAL_BODY, OFFICIAL_SECRET));
        assertTrue(exception.getMessage().contains("difiere"), exception.getMessage());
    }

    private static Map<String, String> officialHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("webhook-id", OFFICIAL_ID);
        headers.put("webhook-timestamp", Long.toString(OFFICIAL_TIMESTAMP));
        headers.put("webhook-signature", OFFICIAL_SIGNATURE);
        return headers;
    }

    private static WebhookEvent verifyAt(Instant now, Map<String, ?> headers, String body, String secret) {
        return Webhook.verify(headers, body, Collections.singletonList(secret), Webhook.DEFAULT_TOLERANCE, now);
    }

    private static void assertNoSignatureMatches(org.junit.jupiter.api.function.Executable verification) {
        WebhookVerificationException exception = assertThrows(WebhookVerificationException.class, verification);
        assertTrue(exception.getMessage().contains("Ninguna firma"), exception.getMessage());
    }
}
