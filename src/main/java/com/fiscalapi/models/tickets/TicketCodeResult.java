package com.fiscalapi.models.tickets;

import com.fiscalapi.common.SerializableDto;

/**
 * Código de un ticket y la URL de su QR, para reimprimirlo (GET /api/v4/tickets/{id}/code).
 */
public class TicketCodeResult extends SerializableDto {

    private String ticketCode;
    private String qrUrl;

    /**
     * @return Código sin guiones, el mismo de la ingesta
     */
    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    /**
     * @return URL del portal de autofactura que abre el ticket
     */
    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }
}
