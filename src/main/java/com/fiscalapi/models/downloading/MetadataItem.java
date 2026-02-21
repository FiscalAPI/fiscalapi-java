package com.fiscalapi.models.downloading;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.OptUtil;
import com.fiscalapi.common.BaseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

/**
 * Modelo que representa los metadatos de una factura.
 */
public class MetadataItem extends BaseDto {

    /**
     * Folio de la factura - UUID
     */
    private String invoiceUuid;

    /**
     * RFC del emisor del comprobante - RfcEmisor
     */
    private String issuerTin;

    /**
     * Nombre o razón social del emisor - NombreEmisor
     */
    private String issuerName;

    /**
     * RFC del receptor del comprobante - RfcReceptor
     */
    private String recipientTin;

    /**
     * Nombre o razón social del receptor - NombreReceptor
     */
    private String recipientName;

    /**
     * RFC del Proveedor Autorizado de Certificación (PAC) - RfcPac
     */
    private String pacTin;

    /**
     * Fecha y hora de emisión del comprobante - FechaEmision
     */
    @JsonIgnore
    private LocalDateTime invoiceDate;

    /**
     * Fecha y hora de certificación por el SAT - FechaCertificacionSat
     */
    @JsonIgnore
    private LocalDateTime satCertificationDate;

    /**
     * Monto total del comprobante - Monto
     */
    private BigDecimal amount;

    /**
     * Tipo de comprobante (I = Ingreso, E = Egreso, T = Traslado, N = Nómina, P = Pago) - EfectoComprobante
     */
    private String invoiceType;

    /**
     * Estatus del comprobante (1 = Vigente, 0 = Cancelado) - Estatus
     */
    private Integer status;

    /**
     * Fecha de cancelación del comprobante (si aplica) - FechaCancelacion
     */
    @JsonIgnore
    private LocalDateTime cancellationDate;

    private String downloadPackageId;
    private String downloadRequestId;

    public MetadataItem() {}

    // Getters y Setters

    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }

    public String getIssuerTin() {
        return issuerTin;
    }

    public void setIssuerTin(String issuerTin) {
        this.issuerTin = issuerTin;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getRecipientTin() {
        return recipientTin;
    }

    public void setRecipientTin(String recipientTin) {
        this.recipientTin = recipientTin;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPacTin() {
        return pacTin;
    }

    public void setPacTin(String pacTin) {
        this.pacTin = pacTin;
    }

    @JsonIgnore
    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    @JsonIgnore
    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @JsonProperty("invoiceDate")
    public String getSatInvoiceDate() {
        if (invoiceDate == null) {
            return null;
        }
        return invoiceDate.format(SAT_DATE_FORMAT_OUT);
    }

    @JsonProperty("invoiceDate")
    public void setSatInvoiceDate(String satDate) {
        this.invoiceDate = OptUtil.parseLocalDateTime(satDate);
    }

    @JsonIgnore
    public LocalDateTime getSatCertificationDate() {
        return satCertificationDate;
    }

    @JsonIgnore
    public void setSatCertificationDate(LocalDateTime satCertificationDate) {
        this.satCertificationDate = satCertificationDate;
    }

    @JsonProperty("satCertificationDate")
    public String getSatCertificationDateFormatted() {
        if (satCertificationDate == null) {
            return null;
        }
        return satCertificationDate.format(SAT_DATE_FORMAT_OUT);
    }

    @JsonProperty("satCertificationDate")
    public void setSatCertificationDateFormatted(String satDate) {
        this.satCertificationDate = OptUtil.parseLocalDateTime(satDate);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonIgnore
    public LocalDateTime getCancellationDate() {
        return cancellationDate;
    }

    @JsonIgnore
    public void setCancellationDate(LocalDateTime cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    @JsonProperty("cancellationDate")
    public String getSatCancellationDate() {
        if (cancellationDate == null) {
            return null;
        }
        return cancellationDate.format(SAT_DATE_FORMAT_OUT);
    }

    @JsonProperty("cancellationDate")
    public void setSatCancellationDate(String satDate) {
        this.cancellationDate = OptUtil.parseLocalDateTime(satDate);
    }

    public String getDownloadPackageId() {
        return downloadPackageId;
    }

    public void setDownloadPackageId(String downloadPackageId) {
        this.downloadPackageId = downloadPackageId;
    }

    public String getDownloadRequestId() {
        return downloadRequestId;
    }

    public void setDownloadRequestId(String downloadRequestId) {
        this.downloadRequestId = downloadRequestId;
    }
}