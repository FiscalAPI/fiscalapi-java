package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.OptUtil;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

/**
 * Ticket de Auto CFDI: una venta pagada del punto de venta que el receptor puede autofacturar o que entra a una
 * factura global. Se envía en {@code create} (POST /api/v4/tickets) y llega en {@code getList} y {@code getById}.
 *
 * <p>Los miembros de solo lectura (id, personId, importes calculados, status, vigencia, facturas, createdAt y events)
 * los asigna la API: al crear quedan en null y no se envían. Los importes se envían tal cual (como texto, con su
 * escala). status guarda el texto de la API tal cual: un estado que este SDK no conoce se lee como null en
 * {@link #getStatus()} y conserva su texto en {@link #getStatusValue()}.</p>
 */
public class Ticket extends BaseDto {

    private TicketIssuer issuer;
    private String personId;
    private String folio;
    private String series;
    @JsonIgnore
    private LocalDateTime paymentDate;
    private String paymentFormCode;
    private String currencyCode;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal exchangeRate;
    private String expeditionZipCode;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal subtotal;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalTransferredTaxes;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalWithheldTaxes;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal total;
    @JsonProperty("status")
    private String status;
    private Boolean selfInvoiceEligible;
    private LocalDateTime eligibleUntil;
    private String invoiceId;
    private String globalInvoiceId;
    private List<TicketItem> items;
    private List<TicketEvent> events;

    /**
     * @return Emisor por referencia; se envía al crear y no llega en las consultas
     */
    public TicketIssuer getIssuer() {
        return issuer;
    }

    public void setIssuer(TicketIssuer issuer) {
        this.issuer = issuer;
    }

    /**
     * @return Persona emisora del tenant (solo lectura; al crear se envía en issuer)
     */
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return Folio del punto de venta (no es el folio del CFDI)
     */
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return Serie del punto de venta; opcional
     */
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * @return Momento del pago en hora civil de México
     */
    @JsonIgnore
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    @JsonIgnore
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * El momento del pago como viaja en el JSON: hora civil de México sin zona, 'yyyy-MM-ddTHH:mm:ss'.
     *
     * @return La fecha formateada, o null si no se asignó
     */
    @JsonProperty("paymentDate")
    public String getSatPaymentDate() {
        return paymentDate == null ? null : paymentDate.format(SAT_DATE_FORMAT_OUT);
    }

    /**
     * @param satPaymentDate Fecha del JSON (acepta milisegundos, como la envía la API)
     */
    @JsonProperty("paymentDate")
    public void setSatPaymentDate(String satPaymentDate) {
        this.paymentDate = OptUtil.parseLocalDateTime(satPaymentDate);
    }

    /**
     * @return Forma de pago (c_FormaPago), por ejemplo 01 (efectivo)
     */
    public String getPaymentFormCode() {
        return paymentFormCode;
    }

    public void setPaymentFormCode(String paymentFormCode) {
        this.paymentFormCode = paymentFormCode;
    }

    /**
     * @return Moneda (c_Moneda); opcional, sin ella la API usa MXN
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return Tipo de cambio; opcional
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * @return Código postal de expedición; opcional, sin él la API usa el del emisor
     */
    public String getExpeditionZipCode() {
        return expeditionZipCode;
    }

    public void setExpeditionZipCode(String expeditionZipCode) {
        this.expeditionZipCode = expeditionZipCode;
    }

    /**
     * @return Subtotal calculado por la API (solo lectura)
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return Total de impuestos trasladados calculado por la API (solo lectura)
     */
    public BigDecimal getTotalTransferredTaxes() {
        return totalTransferredTaxes;
    }

    public void setTotalTransferredTaxes(BigDecimal totalTransferredTaxes) {
        this.totalTransferredTaxes = totalTransferredTaxes;
    }

    /**
     * @return Total de impuestos retenidos calculado por la API (solo lectura)
     */
    public BigDecimal getTotalWithheldTaxes() {
        return totalWithheldTaxes;
    }

    public void setTotalWithheldTaxes(BigDecimal totalWithheldTaxes) {
        this.totalWithheldTaxes = totalWithheldTaxes;
    }

    /**
     * @return Total que cobró el punto de venta: debe cuadrar al centavo con el calculado (si no, 422)
     */
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return El estado, o null si este SDK no conoce el texto de la API (ver {@link #getStatusValue()})
     */
    @JsonIgnore
    public TicketStatus getStatus() {
        return status == null ? null : TicketStatus.fromValue(status);
    }

    @JsonIgnore
    public void setStatus(TicketStatus status) {
        this.status = status == null ? null : status.getValue();
    }

    /**
     * @return El texto del estado tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public String getStatusValue() {
        return status;
    }

    /**
     * @return Si hoy el receptor puede autofacturarlo (solo lectura)
     */
    public Boolean getSelfInvoiceEligible() {
        return selfInvoiceEligible;
    }

    public void setSelfInvoiceEligible(Boolean selfInvoiceEligible) {
        this.selfInvoiceEligible = selfInvoiceEligible;
    }

    /**
     * @return Último momento de la ventana de autofactura; null si no cierra (solo lectura)
     */
    public LocalDateTime getEligibleUntil() {
        return eligibleUntil;
    }

    public void setEligibleUntil(LocalDateTime eligibleUntil) {
        this.eligibleUntil = eligibleUntil;
    }

    /**
     * @return Factura individual (estado invoiced; solo lectura)
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * @return Factura global (estado globalized; solo lectura)
     */
    public String getGlobalInvoiceId() {
        return globalInvoiceId;
    }

    public void setGlobalInvoiceId(String globalInvoiceId) {
        this.globalInvoiceId = globalInvoiceId;
    }

    /**
     * @return Conceptos; obligatorios al crear, en las consultas solo llegan con details
     */
    public List<TicketItem> getItems() {
        return items;
    }

    public void setItems(List<TicketItem> items) {
        this.items = items;
    }

    /**
     * @return Historia del ticket en orden (solo lectura; solo llega con details)
     */
    public List<TicketEvent> getEvents() {
        return events;
    }

    public void setEvents(List<TicketEvent> events) {
        this.events = events;
    }
}
