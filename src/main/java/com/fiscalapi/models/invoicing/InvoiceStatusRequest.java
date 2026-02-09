package com.fiscalapi.models.invoicing;

import com.fiscalapi.OptUtil;

import java.math.BigDecimal;

/**
 * Modelo para consultar el estado de facturas
 */
public class InvoiceStatusRequest {
    private String id;
    private String issuerTin;
    private String recipientTin;
    private BigDecimal invoiceTotal;
    private String invoiceUuid;
    private String last8DigitsIssuerSignature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuerTin() {
        return issuerTin;
    }

    public void setIssuerTin(String issuerTin) {
        this.issuerTin = issuerTin;
    }

    public String getRecipientTin() {
        return recipientTin;
    }

    public void setRecipientTin(String recipientTin) {
        this.recipientTin = recipientTin;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(String invoiceTotal) {
        this.invoiceTotal = OptUtil.parseBigDecimal(invoiceTotal);
    }

    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }

    public String getLast8DigitsIssuerSignature() {
        return last8DigitsIssuerSignature;
    }

    public void setLast8DigitsIssuerSignature(String last8DigitsIssuerSignature) {
        this.last8DigitsIssuerSignature = last8DigitsIssuerSignature;
    }
}