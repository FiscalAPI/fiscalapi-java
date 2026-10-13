package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tipos de hecho de la historia de un ticket, con el texto camelCase que usa la API.
 *
 * <p>{@link TicketEvent} guarda el texto de la API tal cual: un tipo que este SDK no conoce se lee como null en
 * {@link TicketEvent#getType()} y conserva su texto en {@link TicketEvent#getTypeValue()}.</p>
 */
public enum TicketEventType {
    INGESTED("ingested"),
    INVOICING_STARTED("invoicingStarted"),
    INVOICED("invoiced"),
    INVOICE_REJECTED("invoiceRejected"),
    OUTCOME_UNKNOWN("outcomeUnknown"),
    LEASE_EXPIRED("leaseExpired"),
    GLOBALIZING("globalizing"),
    GLOBALIZED("globalized"),
    RELEASED_FROM_GLOBAL("releasedFromGlobal"),
    CANCELLED("cancelled"),
    RECOVERY_FAILED("recoveryFailed"),
    RECOVERED("recovered"),
    RESENT("resent"),
    RETURNED_TO_PENDING("returnedToPending");

    private final String value;

    TicketEventType(String value) {
        this.value = value;
    }

    /**
     * @return El texto camelCase del tipo de hecho en la API
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * @param value Texto camelCase de la API
     * @return El tipo de hecho, o null si este SDK no conoce el texto
     */
    public static TicketEventType fromValue(String value) {
        for (TicketEventType type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
