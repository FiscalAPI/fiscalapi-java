package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Estados de un ticket de Auto CFDI, con el texto camelCase que usa la API.
 *
 * <p>Los modelos guardan el texto de la API tal cual: un estado que este SDK no conoce se lee como null en el getter
 * del enum y conserva su texto en el getter *Value.</p>
 */
public enum TicketStatus {
    /** Ingerido y sin factura: lo puede facturar el receptor o entrar a una global. */
    PENDING("pending"),
    /** El receptor lo está facturando. */
    INVOICING("invoicing"),
    /** Tiene su factura individual (invoiceId). */
    INVOICED("invoiced"),
    /** Una factura global lo está timbrando. */
    GLOBALIZING("globalizing"),
    /** Está en una factura global (globalInvoiceId). */
    GLOBALIZED("globalized"),
    /** Cancelado por el tenant antes de facturarse. */
    CANCELLED("cancelled");

    private final String value;

    TicketStatus(String value) {
        this.value = value;
    }

    /**
     * @return El texto camelCase del estado en la API
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    /**
     * @param value Texto camelCase de la API
     * @return El estado, o null si este SDK no conoce el texto
     */
    public static TicketStatus fromValue(String value) {
        for (TicketStatus status : values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        return null;
    }
}
