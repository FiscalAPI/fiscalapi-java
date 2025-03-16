package com.fiscalapi.models.invoicing;

/**
 * Modelo de respuesta para consulta de estado de facturas
 */
public class InvoiceStatusResponse {
    private String statusCode;
    private String status;
    private String cancelableStatus;
    private String cancellationStatus;
    private String efosValidation;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCancelableStatus() {
        return cancelableStatus;
    }

    public void setCancelableStatus(String cancelableStatus) {
        this.cancelableStatus = cancelableStatus;
    }

    public String getCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(String cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    public String getEfosValidation() {
        return efosValidation;
    }

    public void setEfosValidation(String efosValidation) {
        this.efosValidation = efosValidation;
    }
}