package com.fiscalapi.models.webhooks;

import com.fiscalapi.common.SerializableDto;

/**
 * El recurso al que se refiere un {@link WebhookEvent}.
 */
public class WebhookRelatedObject extends SerializableDto {

    private String id;
    private String type;
    private String url;

    /**
     * @return Id del recurso: el que reciben los {@code getById} de los servicios del SDK
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Tipo de recurso: {@code invoice}, {@code download_request}, {@code download_rule} o
     * {@code webhook} (el de {@link WebhookEventTypes#WEBHOOK_TEST}); el conjunto puede crecer
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Ruta relativa del GET v4 del recurso (por ejemplo {@code /api/v4/invoices/{id}}), sin host: el mismo evento
     * es idéntico en pruebas y en producción. Para leer el recurso use su servicio con {@link #getId()}
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
