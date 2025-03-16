package com.fiscalapi.models.invoicing;

// Respuesta del SAT (timbrado)
public class InvoiceResponse {
    private String id;
    private String invoiceId;
    private String invoiceUuid;
    private String invoiceCertificateNumber;
    private String invoiceBase64Sello;
    private String invoiceSignatureDate;
    private String invoiceBase64QrCode;
    private String invoiceBase64;
    private String satBase64Sello;
    private String satBase64OriginalString;
    private String satCertificateNumber;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
    public String getInvoiceUuid() {
        return invoiceUuid;
    }
    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }
    public String getInvoiceCertificateNumber() {
        return invoiceCertificateNumber;
    }
    public void setInvoiceCertificateNumber(String invoiceCertificateNumber) {
        this.invoiceCertificateNumber = invoiceCertificateNumber;
    }
    public String getInvoiceBase64Sello() {
        return invoiceBase64Sello;
    }
    public void setInvoiceBase64Sello(String invoiceBase64Sello) {
        this.invoiceBase64Sello = invoiceBase64Sello;
    }
    public String getInvoiceSignatureDate() {
        return invoiceSignatureDate;
    }
    public void setInvoiceSignatureDate(String invoiceSignatureDate) {
        this.invoiceSignatureDate = invoiceSignatureDate;
    }
    public String getInvoiceBase64QrCode() {
        return invoiceBase64QrCode;
    }
    public void setInvoiceBase64QrCode(String invoiceBase64QrCode) {
        this.invoiceBase64QrCode = invoiceBase64QrCode;
    }
    public String getInvoiceBase64() {
        return invoiceBase64;
    }
    public void setInvoiceBase64(String invoiceBase64) {
        this.invoiceBase64 = invoiceBase64;
    }
    public String getSatBase64Sello() {
        return satBase64Sello;
    }
    public void setSatBase64Sello(String satBase64Sello) {
        this.satBase64Sello = satBase64Sello;
    }
    public String getSatBase64OriginalString() {
        return satBase64OriginalString;
    }
    public void setSatBase64OriginalString(String satBase64OriginalString) {
        this.satBase64OriginalString = satBase64OriginalString;
    }
    public String getSatCertificateNumber() {
        return satCertificateNumber;
    }
    public void setSatCertificateNumber(String satCertificateNumber) {
        this.satCertificateNumber = satCertificateNumber;
    }
}