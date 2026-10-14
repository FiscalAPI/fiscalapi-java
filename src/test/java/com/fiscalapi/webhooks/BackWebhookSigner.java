package com.fiscalapi.webhooks;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * La firma de WebhookSigner de fapi-back, copiada sin depender del back: HMAC-SHA256 sobre {id}.{timestamp}.{body} en
 * UTF-8 con los bytes base64 del secreto (sin whsec_), una firma "v1,&lt;base64&gt;" por secreto unidas por un espacio,
 * la del secreto vigente primero.
 */
final class BackWebhookSigner {

    private static final String SECRET_PREFIX = "whsec_";
    private static final SecureRandom RANDOM = new SecureRandom();

    private BackWebhookSigner() {
    }

    /** Un secreto como WebhookSecret.Generate del back: whsec_ + 32 bytes aleatorios en base64. */
    static String generateSecret() {
        byte[] key = new byte[32];
        RANDOM.nextBytes(key);
        return SECRET_PREFIX + Base64.getEncoder().encodeToString(key);
    }

    // getBytes(UTF_8) del firmador es tolerante a propósito: un sustituto suelto se firma como '?', igual que un emisor
    // descuidado, y el receptor debe rechazarlo en vez de verificar otros bytes.
    static String sign(String id, long timestamp, String body, String... secrets) {
        byte[] content = (id + "." + timestamp + "." + body).getBytes(StandardCharsets.UTF_8);
        List<String> signatures = new ArrayList<>();
        for (String secret : secrets) {
            signatures.add("v1," + Base64.getEncoder().encodeToString(hmac(keyBytes(secret), content)));
        }
        return String.join(" ", signatures);
    }

    static Map<String, String> headers(String id, long timestamp, String body, String... secrets) {
        Map<String, String> headers = new HashMap<>();
        headers.put("webhook-id", id);
        headers.put("webhook-timestamp", Long.toString(timestamp));
        headers.put("webhook-signature", sign(id, timestamp, body, secrets));
        return headers;
    }

    private static byte[] keyBytes(String secret) {
        return Base64.getDecoder().decode(secret.substring(SECRET_PREFIX.length()));
    }

    private static byte[] hmac(byte[] key, byte[] content) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(content);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
