package com.fiscalapi.models.invoicing;


import java.util.List;

/**
 * Modelo para la cancelación de facturas
 */
public class InvoiceCancellationRequest {
    private String id;
    private String invoiceUuid;
    private String tin;
    private String cancellationReasonCode;
    private String replacementUuid;
    private List<TaxCredential> taxCredentials;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getCancellationReasonCode() {
        return cancellationReasonCode;
    }

    public void setCancellationReasonCode(String cancellationReasonCode) {
        this.cancellationReasonCode = cancellationReasonCode;
    }

    public String getReplacementUuid() {
        return replacementUuid;
    }

    public void setReplacementUuid(String replacementUuid) {
        this.replacementUuid = replacementUuid;
    }

    public List<TaxCredential> getTaxCredentials() {
        return taxCredentials;
    }

    public void setTaxCredentials(List<TaxCredential> taxCredentials) {
        this.taxCredentials = taxCredentials;
    }
}