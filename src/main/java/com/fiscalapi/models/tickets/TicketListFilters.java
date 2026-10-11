package com.fiscalapi.models.tickets;

import com.fiscalapi.common.SerializableDto;

import java.time.LocalDate;
import java.util.List;

/**
 * Filtros de {@code getList} (GET /api/v4/tickets). Cada filtro aplica solo si se asigna; los que quedan en null no se
 * envían. Los tickets llegan ordenados por fecha de pago.
 */
public class TicketListFilters extends SerializableDto {

    private List<TicketStatus> status;
    private String personId;
    private LocalDate from;
    private LocalDate to;
    private Integer pageNumber;
    private Integer pageSize;

    /**
     * @return Uno o más estados; se envían repitiendo la llave status
     */
    public List<TicketStatus> getStatus() {
        return status;
    }

    public void setStatus(List<TicketStatus> status) {
        this.status = status;
    }

    /**
     * @return Persona emisora
     */
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return Primer día del pago (incluido), en fecha civil de México
     */
    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    /**
     * @return Último día del pago (incluido), en fecha civil de México
     */
    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    /**
     * @return Página, desde 1; sin ella, la API devuelve la primera
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return Tamaño de página (1 a 50); sin él, la API usa 10
     */
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
