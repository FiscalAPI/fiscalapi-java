package com.fiscalapi.webhooks;

import com.fiscalapi.models.webhooks.WebhookEvent;
import com.fiscalapi.models.webhooks.WebhookEventTypes;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Interoperabilidad con el back: una entrega firmada como la firma WebhookSigner de fapi-back (dos secretos durante una
 * rotación, el vigente primero) y con el sobre tal como lo serializa el back (camelCase, sin espacios, createdAt al
 * segundo con Z y las nulas presentes) verifica con Webhook.verify y se lee completa en WebhookEvent.
 */
class WebhookBackInteropTest {

    private static final String EVENT_ID = "0f6b2c1e-7d3a-4e8b-9c51-2a4d6e8f0b13";
    private static final String PERSON_ID = "4b1c2d3e-0000-4000-8000-000000000002";
    private static final String INVOICE_ID = "9f8e7d6c-0000-4000-8000-0000000000a1";
    private static final String DOWNLOAD_REQUEST_ID = "3c2b1a09-0000-4000-8000-0000000000b7";
    private static final String ENDPOINT_ID = "6a5b4c3d-0000-4000-8000-0000000000c9";
    private static final long TIMESTAMP = 1791830873L; // 2026-10-12T18:47:53Z, el createdAt de los sobres
    private static final Instant DELIVERED_AT = Instant.ofEpochSecond(TIMESTAMP);
    private static final OffsetDateTime CREATED_AT = OffsetDateTime.of(2026, 10, 12, 18, 47, 53, 0, ZoneOffset.UTC);

    // Los sobres de WebhookEnvelopeTests de fapi-back, con ids fijos.
    private static final String CANCELED_INVOICE_BODY = "{\"id\":\"" + EVENT_ID + "\",\"type\":\"invoice.canceled\","
            + "\"createdAt\":\"2026-10-12T18:47:53Z\",\"personId\":\"" + PERSON_ID + "\",\"data\":{\"relatedObject\":"
            + "{\"id\":\"" + INVOICE_ID + "\",\"type\":\"invoice\",\"url\":\"/api/v4/invoices/" + INVOICE_ID + "\"},"
            + "\"status\":\"X\",\"previousStatus\":\"C\"}}";

    private static final String COMPLETED_DOWNLOAD_REQUEST_BODY = "{\"id\":\"" + EVENT_ID + "\","
            + "\"type\":\"download_request.completed\",\"createdAt\":\"2026-10-12T18:47:53Z\",\"personId\":null,"
            + "\"data\":{\"relatedObject\":{\"id\":\"" + DOWNLOAD_REQUEST_ID + "\",\"type\":\"download_request\","
            + "\"url\":\"/api/v4/download-requests/" + DOWNLOAD_REQUEST_ID + "\"},\"status\":null,\"previousStatus\":null}}";

    // El sobre de "Enviar prueba" del back (POST webhook-endpoints/{id}/test): el recurso es el endpoint.
    private static final String ENDPOINT_TEST_BODY = "{\"id\":\"" + EVENT_ID + "\",\"type\":\"webhook_endpoint.test\","
            + "\"createdAt\":\"2026-10-12T18:47:53Z\",\"personId\":null,\"data\":{\"relatedObject\":{\"id\":\""
            + ENDPOINT_ID + "\",\"type\":\"webhook_endpoint\",\"url\":\"/api/v4/webhook-endpoints/" + ENDPOINT_ID
            + "\"},\"status\":null,\"previousStatus\":null}}";

    @Test
    void aBackDeliverySignedDuringARotationVerifiesWithEitherSecretAndReadsEveryField() {
        String current = BackWebhookSigner.generateSecret();
        String previous = BackWebhookSigner.generateSecret();
        Map<String, String> headers = BackWebhookSigner.headers(EVENT_ID, TIMESTAMP, CANCELED_INVOICE_BODY, current,
                previous);

        for (String receiverSecret : Arrays.asList(current, previous)) {
            WebhookEvent event = verify(headers, CANCELED_INVOICE_BODY, receiverSecret);

            assertEquals(EVENT_ID, event.getId());
            assertEquals(WebhookEventTypes.INVOICE_CANCELED, event.getType());
            assertEquals(CREATED_AT, event.getCreatedAt());
            assertEquals(ZoneOffset.UTC, event.getCreatedAt().getOffset());
            assertEquals(PERSON_ID, event.getPersonId());
            assertEquals(INVOICE_ID, event.getData().getRelatedObject().getId());
            assertEquals("invoice", event.getData().getRelatedObject().getType());
            assertEquals("/api/v4/invoices/" + INVOICE_ID, event.getData().getRelatedObject().getUrl());
            assertEquals("X", event.getData().getStatus());
            assertEquals("C", event.getData().getPreviousStatus());
        }
    }

    @Test
    void aBackDeliveryWithoutPersonOrStatusesReadsThemAsNull() {
        String secret = BackWebhookSigner.generateSecret();
        Map<String, String> headers = BackWebhookSigner.headers(EVENT_ID, TIMESTAMP, COMPLETED_DOWNLOAD_REQUEST_BODY,
                secret);

        WebhookEvent event = verify(headers, COMPLETED_DOWNLOAD_REQUEST_BODY, secret);

        assertEquals(WebhookEventTypes.DOWNLOAD_REQUEST_COMPLETED, event.getType());
        assertNull(event.getPersonId());
        assertEquals(DOWNLOAD_REQUEST_ID, event.getData().getRelatedObject().getId());
        assertEquals("download_request", event.getData().getRelatedObject().getType());
        assertEquals("/api/v4/download-requests/" + DOWNLOAD_REQUEST_ID, event.getData().getRelatedObject().getUrl());
        assertNull(event.getData().getStatus());
        assertNull(event.getData().getPreviousStatus());
    }

    @Test
    void aBackEndpointTestDeliveryPointsToTheEndpointWithoutPersonOrStatuses() {
        String secret = BackWebhookSigner.generateSecret();
        Map<String, String> headers = BackWebhookSigner.headers(EVENT_ID, TIMESTAMP, ENDPOINT_TEST_BODY, secret);

        WebhookEvent event = verify(headers, ENDPOINT_TEST_BODY, secret);

        assertEquals(WebhookEventTypes.WEBHOOK_ENDPOINT_TEST, event.getType());
        assertNull(event.getPersonId());
        assertEquals(ENDPOINT_ID, event.getData().getRelatedObject().getId());
        assertEquals("webhook_endpoint", event.getData().getRelatedObject().getType());
        assertEquals("/api/v4/webhook-endpoints/" + ENDPOINT_ID, event.getData().getRelatedObject().getUrl());
        assertNull(event.getData().getStatus());
        assertNull(event.getData().getPreviousStatus());
    }

    @Test
    void anUnknownTypeAndUnknownFieldsAreReadWithoutError() {
        String body = "{\"id\":\"evt_1\",\"type\":\"invoice.future_state\",\"createdAt\":\"2026-10-12T18:47:53Z\","
                + "\"personId\":null,\"extra\":1,\"data\":{\"relatedObject\":{\"id\":\"r1\",\"type\":\"future_resource\","
                + "\"url\":\"/api/v4/future/r1\",\"extra\":true},\"status\":\"Z\",\"previousStatus\":null,"
                + "\"more\":{\"nested\":[1,2]}}}";
        String secret = BackWebhookSigner.generateSecret();

        WebhookEvent event = verify(BackWebhookSigner.headers("evt_1", TIMESTAMP, body, secret), body, secret);

        assertEquals("invoice.future_state", event.getType());
        assertEquals("future_resource", event.getData().getRelatedObject().getType());
        assertEquals("Z", event.getData().getStatus());
    }

    @Test
    void aCreatedAtWithAnotherOffsetIsNormalizedToUtc() {
        String body = "{\"id\":\"evt_1\",\"type\":\"invoice.canceled\",\"createdAt\":\"2026-10-12T19:47:53+01:00\","
                + "\"personId\":null,\"data\":{\"relatedObject\":{\"id\":\"r1\",\"type\":\"invoice\","
                + "\"url\":\"/api/v4/invoices/r1\"},\"status\":\"X\",\"previousStatus\":\"C\"}}";
        String secret = BackWebhookSigner.generateSecret();
        Map<String, String> headers = BackWebhookSigner.headers("evt_1", TIMESTAMP, body, secret);

        WebhookEvent event = verify(headers, body, secret);

        assertEquals(CREATED_AT, event.getCreatedAt());
        assertEquals(ZoneOffset.UTC, event.getCreatedAt().getOffset());
    }

    @Test
    void theEventTypeConstantsAreTheTypesOfTheBack() {
        assertEquals("invoice.cancellation_requested", WebhookEventTypes.INVOICE_CANCELLATION_REQUESTED);
        assertEquals("invoice.canceled", WebhookEventTypes.INVOICE_CANCELED);
        assertEquals("invoice.cancellation_rejected", WebhookEventTypes.INVOICE_CANCELLATION_REJECTED);
        assertEquals("download_request.completed", WebhookEventTypes.DOWNLOAD_REQUEST_COMPLETED);
        assertEquals("download_request.abandoned", WebhookEventTypes.DOWNLOAD_REQUEST_ABANDONED);
        assertEquals("download_rule.suspended", WebhookEventTypes.DOWNLOAD_RULE_SUSPENDED);
        assertEquals("webhook_endpoint.test", WebhookEventTypes.WEBHOOK_ENDPOINT_TEST);
    }

    private static WebhookEvent verify(Map<String, String> headers, String body, String secret) {
        return Webhook.verify(headers, body, Collections.singletonList(secret), Webhook.DEFAULT_TOLERANCE,
                DELIVERED_AT);
    }
}
