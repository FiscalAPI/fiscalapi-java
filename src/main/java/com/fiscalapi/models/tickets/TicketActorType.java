package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Quién actuó en un hecho del ticket, con el texto camelCase que usa la API.
 *
 * <p>{@link TicketEvent} guarda el texto de la API tal cual: un actor que este SDK no conoce se lee como null en
 * {@link TicketEvent#getActorType()} y conserva su texto en {@link TicketEvent#getActorTypeValue()}.</p>
 */
public enum TicketActorType {
    /** Una persona del tenant por la API o el dashboard. */
    TENANT("tenant"),
    /** El receptor en el portal de autofactura. */
    PORTAL("portal"),
    /** Un proceso en segundo plano de FiscalAPI. */
    SYSTEM("system");

    private final String value;

    TicketActorType(String value) {
        this.value = value;
    }

    /**
     * @return El texto camelCase del actor en la API
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * @param value Texto camelCase de la API
     * @return El actor, o null si este SDK no conoce el texto
     */
    public static TicketActorType fromValue(String value) {
        for (TicketActorType actorType : values()) {
            if (actorType.value.equals(value)) {
                return actorType;
            }
        }
        return null;
    }
}
