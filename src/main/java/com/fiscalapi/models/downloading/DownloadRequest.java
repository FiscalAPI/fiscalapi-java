package com.fiscalapi.models.downloading;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una solicitud de descarga de CFDI o metadatos al SAT.
 */
public class DownloadRequest extends BaseDto {

    private Integer consecutive;
    private String satRequestId;
    private String downloadRuleId;
    private String downloadTypeId;
    private CatalogDto downloadType;
    private String downloadRequestTypeId;
    private CatalogDto downloadRequestType;
    private String recipientTin;
    private String issuerTin;
    private String requesterTin;
    //  ISO  startDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    // ISO endDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    private String satQueryTypeId;
    private CatalogDto satQueryType;
    private String satInvoiceTypeId;
    private CatalogDto satInvoiceType;
    private String satInvoiceStatusId;
    private CatalogDto satInvoiceStatus;
    private String satInvoiceComplementId;
    private CatalogDto satInvoiceComplement;
    private String satRequestStatusId;
    private CatalogDto satRequestStatus;
    private String downloadRequestStatusId;
    private CatalogDto downloadRequestStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastAttemptDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime nextAttemptDate;
    private Integer invoiceCount;
    private List<String> packageIds;
    private Boolean isReadyToDownload;
    private Integer retriesCount;

    /**
     * Constructor por defecto
     */
    public DownloadRequest() {
        this.packageIds = new ArrayList<>();
        this.invoiceCount = 0;
        this.retriesCount = 0;
        this.isReadyToDownload = false;
    }

    /**
     * @return Número consecutivo interno de control
     */
    public Integer getConsecutive() {
        return consecutive;
    }

    /**
     * @param consecutive Número consecutivo interno de control
     */
    public void setConsecutive(Integer consecutive) {
        this.consecutive = consecutive;
    }

    /**
     * @return ID de solicitud SAT utilizado para rastrear la solicitud en el sistema SAT
     */
    public String getSatRequestId() {
        return satRequestId;
    }

    /**
     * @param satRequestId ID de solicitud SAT utilizado para rastrear la solicitud en el sistema SAT
     */
    public void setSatRequestId(String satRequestId) {
        this.satRequestId = satRequestId;
    }

    /**
     * @return ID de la regla asociada con la solicitud
     */
    public String getDownloadRuleId() {
        return downloadRuleId;
    }

    /**
     * @param downloadRuleId ID de la regla asociada con la solicitud
     */
    public void setDownloadRuleId(String downloadRuleId) {
        this.downloadRuleId = downloadRuleId;
    }

    /**
     * @return ID del tipo de descarga
     */
    public String getDownloadTypeId() {
        return downloadTypeId;
    }

    /**
     * @param downloadTypeId ID del tipo de descarga
     */
    public void setDownloadTypeId(String downloadTypeId) {
        this.downloadTypeId = downloadTypeId;
    }

    /**
     * @return Tipo de descarga
     */
    public CatalogDto getDownloadType() {
        return downloadType;
    }

    /**
     * @param downloadType Tipo de descarga
     */
    public void setDownloadType(CatalogDto downloadType) {
        this.downloadType = downloadType;
    }

    /**
     * @return ID del tipo de solicitud de descarga
     */
    public String getDownloadRequestTypeId() {
        return downloadRequestTypeId;
    }

    /**
     * @param downloadRequestTypeId ID del tipo de solicitud de descarga
     */
    public void setDownloadRequestTypeId(String downloadRequestTypeId) {
        this.downloadRequestTypeId = downloadRequestTypeId;
    }

    /**
     * @return Tipo de solicitud de descarga
     */
    public CatalogDto getDownloadRequestType() {
        return downloadRequestType;
    }

    /**
     * @param downloadRequestType Tipo de solicitud de descarga
     */
    public void setDownloadRequestType(CatalogDto downloadRequestType) {
        this.downloadRequestType = downloadRequestType;
    }

    /**
     * @return RFC del receptor - CFDIs o metadatos específicos del RFC receptor dado
     */
    public String getRecipientTin() {
        return recipientTin;
    }

    /**
     * @param recipientTin RFC del receptor - CFDIs o metadatos específicos del RFC receptor dado
     */
    public void setRecipientTin(String recipientTin) {
        this.recipientTin = recipientTin;
    }

    /**
     * @return RFC del emisor - CFDIs o metadatos específicos del RFC emisor dado
     */
    public String getIssuerTin() {
        return issuerTin;
    }

    /**
     * @param issuerTin RFC del emisor - CFDIs o metadatos específicos del RFC emisor dado
     */
    public void setIssuerTin(String issuerTin) {
        this.issuerTin = issuerTin;
    }

    /**
     * @return RFC del solicitante - RFC que está solicitando la consulta
     */
    public String getRequesterTin() {
        return requesterTin;
    }

    /**
     * @param requesterTin RFC del solicitante - RFC que está solicitando la consulta
     */
    public void setRequesterTin(String requesterTin) {
        this.requesterTin = requesterTin;
    }

    /**
     * @return Fecha inicial - Fecha de inicio para la solicitud asociada
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * @param startDate Fecha inicial - Fecha de inicio para la solicitud asociada
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Fecha final - Fecha de fin para la solicitud asociada
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * @param endDate Fecha final - Fecha de fin para la solicitud asociada como String
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * @return ID del tipo de solicitud - Tipo de solicitud para la petición (CFDI o Metadata)
     */
    public String getSatQueryTypeId() {
        return satQueryTypeId;
    }

    /**
     * @param satQueryTypeId ID del tipo de solicitud - Tipo de solicitud para la petición (CFDI o Metadata)
     */
    public void setSatQueryTypeId(String satQueryTypeId) {
        this.satQueryTypeId = satQueryTypeId;
    }

    /**
     * @return Tipo de solicitud SAT
     */
    public CatalogDto getSatQueryType() {
        return satQueryType;
    }

    /**
     * @param satQueryType Tipo de solicitud SAT
     */
    public void setSatQueryType(CatalogDto satQueryType) {
        this.satQueryType = satQueryType;
    }

    /**
     * @return ID del tipo de comprobante específico a solicitar (Ingreso, Egreso, Traslado, Nómina, Pago, Todos)
     */
    public String getSatInvoiceTypeId() {
        return satInvoiceTypeId;
    }

    /**
     * @param satInvoiceTypeId ID del tipo de comprobante específico a solicitar (Ingreso, Egreso, Traslado, Nómina, Pago, Todos)
     */
    public void setSatInvoiceTypeId(String satInvoiceTypeId) {
        this.satInvoiceTypeId = satInvoiceTypeId;
    }

    /**
     * @return Tipo de comprobante
     */
    public CatalogDto getSatInvoiceType() {
        return satInvoiceType;
    }

    /**
     * @param satInvoiceType Tipo de comprobante
     */
    public void setSatInvoiceType(CatalogDto satInvoiceType) {
        this.satInvoiceType = satInvoiceType;
    }

    /**
     * @return ID del estado de los CFDIs a solicitar
     */
    public String getSatInvoiceStatusId() {
        return satInvoiceStatusId;
    }

    /**
     * @param satInvoiceStatusId ID del estado de los CFDIs a solicitar
     */
    public void setSatInvoiceStatusId(String satInvoiceStatusId) {
        this.satInvoiceStatusId = satInvoiceStatusId;
    }

    /**
     * @return Estado de la factura en SAT
     */
    public CatalogDto getSatInvoiceStatus() {
        return satInvoiceStatus;
    }

    /**
     * @param satInvoiceStatus Estado de la factura en SAT
     */
    public void setSatInvoiceStatus(CatalogDto satInvoiceStatus) {
        this.satInvoiceStatus = satInvoiceStatus;
    }

    /**
     * @return ID del complemento de CFDIs para la solicitud
     */
    public String getSatInvoiceComplementId() {
        return satInvoiceComplementId;
    }

    /**
     * @param satInvoiceComplementId ID del complemento de CFDIs para la solicitud
     */
    public void setSatInvoiceComplementId(String satInvoiceComplementId) {
        this.satInvoiceComplementId = satInvoiceComplementId;
    }

    /**
     * @return Complemento de factura SAT
     */
    public CatalogDto getSatInvoiceComplement() {
        return satInvoiceComplement;
    }

    /**
     * @param satInvoiceComplement Complemento de factura SAT
     */
    public void setSatInvoiceComplement(CatalogDto satInvoiceComplement) {
        this.satInvoiceComplement = satInvoiceComplement;
    }

    /**
     * @return Estado actual de la solicitud (DESCONOCIDO, ACEPTADA, EN PROCESO, TERMINADA, ERROR, RECHAZADA, VENCIDA)
     */
    public String getSatRequestStatusId() {
        return satRequestStatusId;
    }

    /**
     * @param satRequestStatusId Estado actual de la solicitud (DESCONOCIDO, ACEPTADA, EN PROCESO, TERMINADA, ERROR, RECHAZADA, VENCIDA)
     */
    public void setSatRequestStatusId(String satRequestStatusId) {
        this.satRequestStatusId = satRequestStatusId;
    }

    /**
     * @return Estado de la solicitud en SAT
     */
    public CatalogDto getSatRequestStatus() {
        return satRequestStatus;
    }

    /**
     * @param satRequestStatus Estado de la solicitud en SAT
     */
    public void setSatRequestStatus(CatalogDto satRequestStatus) {
        this.satRequestStatus = satRequestStatus;
    }

    /**
     * @return ID del estado de la solicitud en Fiscalapi
     */
    public String getDownloadRequestStatusId() {
        return downloadRequestStatusId;
    }

    /**
     * @param downloadRequestStatusId ID del estado de la solicitud en Fiscalapi
     */
    public void setDownloadRequestStatusId(String downloadRequestStatusId) {
        this.downloadRequestStatusId = downloadRequestStatusId;
    }

    /**
     * @return Estado de la solicitud de descarga
     */
    public CatalogDto getDownloadRequestStatus() {
        return downloadRequestStatus;
    }

    /**
     * @param downloadRequestStatus Estado de la solicitud de descarga
     */
    public void setDownloadRequestStatus(CatalogDto downloadRequestStatus) {
        this.downloadRequestStatus = downloadRequestStatus;
    }

    /**
     * @return Fecha del último intento para la solicitud asociada
     */
    public LocalDateTime getLastAttemptDate() {
        return lastAttemptDate;
    }

    /**
     * @param lastAttemptDate Fecha del último intento para la solicitud asociada
     */
    public void setLastAttemptDate(LocalDateTime lastAttemptDate) {
        this.lastAttemptDate = lastAttemptDate;
    }

    /**
     * @return Fecha del siguiente intento para la solicitud asociada
     */
    public LocalDateTime getNextAttemptDate() {
        return nextAttemptDate;
    }

    /**
     * @param nextAttemptDate Fecha del siguiente intento para la solicitud asociada
     */
    public void setNextAttemptDate(LocalDateTime nextAttemptDate) {
        this.nextAttemptDate = nextAttemptDate;
    }

    /**
     * @return Número de CFDIs encontrados para la solicitud cuando la solicitud ha terminado
     */
    public Integer getInvoiceCount() {
        return invoiceCount;
    }

    /**
     * @param invoiceCount Número de CFDIs encontrados para la solicitud cuando la solicitud ha terminado
     */
    public void setInvoiceCount(Integer invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    /**
     * @return Lista de IDs de paquetes disponibles para descarga cuando la solicitud ha terminado
     */
    public List<String> getPackageIds() {
        return packageIds;
    }

    /**
     * @param packageIds Lista de IDs de paquetes disponibles para descarga cuando la solicitud ha terminado
     */
    public void setPackageIds(List<String> packageIds) {
        this.packageIds = packageIds;
    }

    /**
     * @return Indica si la solicitud está lista para descarga, se vuelve verdadero cuando la solicitud ha terminado y los paquetes están disponibles
     */
    public Boolean getIsReadyToDownload() {
        return isReadyToDownload;
    }

    /**
     * @param isReadyToDownload Indica si la solicitud está lista para descarga, se vuelve verdadero cuando la solicitud ha terminado y los paquetes están disponibles
     */
    public void setIsReadyToDownload(Boolean isReadyToDownload) {
        this.isReadyToDownload = isReadyToDownload;
    }

    /**
     * @return Número de reintentos totales intentados para esta solicitud a través de todas las re-sumisiones
     */
    public Integer getRetriesCount() {
        return retriesCount;
    }

    /**
     * @param retriesCount Número de reintentos totales intentados para esta solicitud a través de todas las re-sumisiones
     */
    public void setRetriesCount(Integer retriesCount) {
        this.retriesCount = retriesCount;
    }
}
