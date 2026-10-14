package com.fiscalapi.models.webhooks;

/**
 * Tipos de evento de webhook, como llegan en {@link WebhookEvent#getType()}. Los de un cambio de estado nombran el estado
 * al que llegó el recurso. Son una ayuda para comparar: el catálogo puede crecer y un tipo desconocido se ignora.
 */
public final class WebhookEventTypes {

    /** La factura pasó de vigente a cancelación en proceso ({@code V} → {@code C}). */
    public static final String INVOICE_CANCELLATION_REQUESTED = "invoice.cancellation_requested";

    /** La cancelación en proceso terminó y la factura quedó cancelada ({@code C} → {@code X}). */
    public static final String INVOICE_CANCELED = "invoice.canceled";

    /** La cancelación en proceso se rechazó y la factura volvió a vigente ({@code C} → {@code V}). */
    public static final String INVOICE_CANCELLATION_REJECTED = "invoice.cancellation_rejected";

    /** La solicitud de descarga masiva terminó con éxito (→ {@code 3}). */
    public static final String DOWNLOAD_REQUEST_COMPLETED = "download_request.completed";

    /**
     * La solicitud de descarga masiva se abandonó (→ {@code -1}). No implica un error: el motivo está en la solicitud
     * ({@code getDownloadRequestService().getById(id, false)}).
     */
    public static final String DOWNLOAD_REQUEST_ABANDONED = "download_request.abandoned";

    /** La regla de descarga masiva quedó suspendida ({@code 2} → {@code 4}). */
    public static final String DOWNLOAD_RULE_SUSPENDED = "download_rule.suspended";

    /**
     * Prueba de un webhook: no se suscribe; llega solo al pulsar "Enviar prueba"
     * ({@code POST /api/v4/webhooks/{id}/test}), y solo a ese webhook. Su {@link WebhookEventData#getRelatedObject()}
     * es el webhook mismo (tipo {@code webhook}, url {@code /api/v4/webhooks/{id}}), sin persona ni estados.
     */
    public static final String WEBHOOK_TEST = "webhook.test";

    private WebhookEventTypes() {
    }
}
