package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.common.SerializableDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Respuesta de {@code create}: un ticket nuevo (201) y la repetición con la misma llave de idempotencia y el mismo cuerpo
 * devuelven la misma respuesta original. status guarda el texto de la API tal cual (ver {@link #getStatusValue()}).
 */
public class TicketIngestionResult extends SerializableDto {

    private String id;
    private String ticketCode;
    private String qrUrl;
    @JsonProperty("status")
    private String status;
    private boolean selfInvoiceEligible;
    private LocalDateTime eligibleUntil;
    private BigDecimal subtotal;
    private BigDecimal totalTransferredTaxes;
    private BigDecimal totalWithheldTaxes;
    private BigDecimal total;

    /**
     * @return Id del ticket
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Código sin guiones, como lo lleva el QR; se imprime en grupos (XXXX-XXXX-XXXX)
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

    /**
     * @return El estado (al ingerir, PENDING), o null si este SDK no conoce el texto de la API
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
     * @return Si hoy el receptor puede autofacturarlo
     */
    public boolean isSelfInvoiceEligible() {
        return selfInvoiceEligible;
    }

    public void setSelfInvoiceEligible(boolean selfInvoiceEligible) {
        this.selfInvoiceEligible = selfInvoiceEligible;
    }

    /**
     * @return Último momento de la ventana de autofactura; null si no cierra
     */
    public LocalDateTime getEligibleUntil() {
        return eligibleUntil;
    }

    public void setEligibleUntil(LocalDateTime eligibleUntil) {
        this.eligibleUntil = eligibleUntil;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotalTransferredTaxes() {
        return totalTransferredTaxes;
    }

    public void setTotalTransferredTaxes(BigDecimal totalTransferredTaxes) {
        this.totalTransferredTaxes = totalTransferredTaxes;
    }

    public BigDecimal getTotalWithheldTaxes() {
        return totalWithheldTaxes;
    }

    public void setTotalWithheldTaxes(BigDecimal totalWithheldTaxes) {
        this.totalWithheldTaxes = totalWithheldTaxes;
    }

    /**
     * @return Total calculado (cuadra con el enviado)
     */
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
