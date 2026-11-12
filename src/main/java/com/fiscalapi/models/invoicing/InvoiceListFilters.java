package com.fiscalapi.models.invoicing;

import com.fiscalapi.common.SerializableDto;

import java.time.LocalDate;

/**
 * Filtros de {@code getList} (GET /api/v4/invoices). Cada filtro aplica solo si se asigna; los que quedan en null no se
 * envían. Sin ninguno, la lista es la de siempre: primera página, de la más antigua a la más reciente.
 */
public class InvoiceListFilters extends SerializableDto {

    private LocalDate from;
    private LocalDate to;
    private String issuerTin;
    private String recipientTin;
    private String typeCode;
    private String statusId;
    private String series;
    private String number;
    private String uuid;
    private InvoiceListOrder order;
    private Integer pageNumber;
    private Integer pageSize;

    /**
     * @return Primer día de la fecha de la factura (incluido), en fecha civil de México; va junto con to
     */
    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    /**
     * @return Último día de la fecha de la factura (incluido), en fecha civil de México; va junto con from
     */
    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    /**
     * @return RFC del emisor, exacto
     */
    public String getIssuerTin() {
        return issuerTin;
    }

    public void setIssuerTin(String issuerTin) {
        this.issuerTin = issuerTin;
    }

    /**
     * @return RFC del receptor, exacto
     */
    public String getRecipientTin() {
        return recipientTin;
    }

    public void setRecipientTin(String recipientTin) {
        this.recipientTin = recipientTin;
    }

    /**
     * @return Tipo de comprobante (c_TipoDeComprobante): I, E, T, P o N
     */
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * @return Estatus de la factura: B (borrador), V (vigente), C (cancelando) o X (cancelada)
     */
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * @return Serie, exacta
     */
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * @return Folio, exacto
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return Folio fiscal (UUID)
     */
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return Orden por fecha de creación; sin él, la API usa {@link InvoiceListOrder#ASC}
     */
    public InvoiceListOrder getOrder() {
        return order;
    }

    public void setOrder(InvoiceListOrder order) {
        this.order = order;
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
