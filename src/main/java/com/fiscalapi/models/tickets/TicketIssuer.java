package com.fiscalapi.models.tickets;

import com.fiscalapi.common.SerializableDto;

/**
 * Emisor de un ticket: una persona del tenant, por su id.
 */
public class TicketIssuer extends SerializableDto {

    private String id;

    public TicketIssuer() {
    }

    /**
     * @param id Id de la persona emisora
     */
    public TicketIssuer(String id) {
        this.id = id;
    }

    /**
     * @return Id de la persona emisora
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
