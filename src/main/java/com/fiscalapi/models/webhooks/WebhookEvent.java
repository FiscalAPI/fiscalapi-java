package com.fiscalapi.models.webhooks;

import com.fiscalapi.common.SerializableDto;

import java.time.OffsetDateTime;

/**
 * Un evento de webhook de FiscalAPI: el mismo sobre para todo tipo de evento. Lo devuelve
 * {@link com.fiscalapi.webhooks.Webhook#verify} después de validar la firma. Es una notificación ligera: para el estado
 * autoritativo del recurso (el orden de llegada no está garantizado), consulte {@link WebhookEventData#getRelatedObject()}
 * con el servicio de su tipo (por ejemplo {@code getInvoiceService().getById(id, false)}).
 */
public class WebhookEvent extends SerializableDto {

    private String id;
    private String type;
    private OffsetDateTime createdAt;
    private String personId;
    private WebhookEventData data;

    /**
     * @return Id del evento; es también el header {@code webhook-id} y no cambia entre reintentos: úselo para descartar
     * entregas repetidas
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Tipo de evento (ver {@link WebhookEventTypes}). Es texto y no un enum: un tipo que esta versión del SDK no
     * conoce llega tal cual, sin error, y se ignora
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Momento del cambio de estado, en UTC (desfase {@code Z}), al segundo
     */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return Persona del tenant dueña del recurso; null si el recurso no tiene una (factura emitida por valores)
     */
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return El recurso que cambió y sus estados
     */
    public WebhookEventData getData() {
        return data;
    }

    public void setData(WebhookEventData data) {
        this.data = data;
    }
}
