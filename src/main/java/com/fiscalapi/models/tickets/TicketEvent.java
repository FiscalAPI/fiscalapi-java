package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.common.SerializableDto;

import java.time.LocalDateTime;

/**
 * Un hecho de la historia del ticket (solo lectura; llega con details).
 *
 * <p>type y actorType guardan el texto de la API tal cual: un valor que este SDK no conoce se lee como null en el
 * getter del enum y conserva su texto en el getter *Value.</p>
 */
public class TicketEvent extends SerializableDto {

    @JsonProperty("type")
    private String type;
    private LocalDateTime occurredAt;
    @JsonProperty("actorType")
    private String actorType;
    private String invoiceId;

    /**
     * @return El tipo de hecho, o null si este SDK no conoce el texto de la API (ver {@link #getTypeValue()})
     */
    @JsonIgnore
    public TicketEventType getType() {
        return type == null ? null : TicketEventType.fromValue(type);
    }

    @JsonIgnore
    public void setType(TicketEventType type) {
        this.type = type == null ? null : type.getValue();
    }

    /**
     * @return El texto del tipo de hecho tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public String getTypeValue() {
        return type;
    }

    /**
     * @return Momento del hecho
     */
    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    /**
     * @return Quién actuó, o null si este SDK no conoce el texto de la API (ver {@link #getActorTypeValue()})
     */
    @JsonIgnore
    public TicketActorType getActorType() {
        return actorType == null ? null : TicketActorType.fromValue(actorType);
    }

    @JsonIgnore
    public void setActorType(TicketActorType actorType) {
        this.actorType = actorType == null ? null : actorType.getValue();
    }

    /**
     * @return El texto del actor tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public String getActorTypeValue() {
        return actorType;
    }

    /**
     * @return Factura del hecho (la individual o la global que lo timbró, liberó o devolvió); null si no aplica
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
