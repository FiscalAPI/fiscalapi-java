package com.fiscalapi.models.webhooks;

import com.fiscalapi.common.SerializableDto;

/**
 * Datos de un {@link WebhookEvent}.
 */
public class WebhookEventData extends SerializableDto {

    private WebhookRelatedObject relatedObject;
    private String status;
    private String previousStatus;

    /**
     * @return El recurso que cambió de estado
     */
    public WebhookRelatedObject getRelatedObject() {
        return relatedObject;
    }

    public void setRelatedObject(WebhookRelatedObject relatedObject) {
        this.relatedObject = relatedObject;
    }

    /**
     * @return Estado al que llegó el recurso, con los códigos públicos de la API v4 (factura {@code V}, {@code C},
     * {@code X}; solicitud de descarga {@code 1}, {@code 2}, {@code 3}, {@code -1}; regla de descarga {@code 1}..{@code 4},
     * {@code -1}); null si el tipo de evento no lo lleva
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Estado del que salió el recurso, con los mismos códigos que {@link #getStatus()}; null si no aplica
     */
    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }
}
