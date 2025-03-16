package com.fiscalapi.models.invoicing;

import java.util.Map;

/**
 * Modelo de respuesta de cancelación de facturas
 */
public class InvoiceCancellationResponse {
    private String base64CancellationAcknowledgement;
    private Map<String, String> invoiceUuids;

    public String getBase64CancellationAcknowledgement() {
        return base64CancellationAcknowledgement;
    }

    public void setBase64CancellationAcknowledgement(String base64CancellationAcknowledgement) {
        this.base64CancellationAcknowledgement = base64CancellationAcknowledgement;
    }

    public Map<String, String> getInvoiceUuids() {
        return invoiceUuids;
    }

    public void setInvoiceUuids(Map<String, String> invoiceUuids) {
        this.invoiceUuids = invoiceUuids;
    }
}