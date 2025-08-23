package com.fiscalapi.models.downloading;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.models.Person;

/**
 * Representa una plantilla para crear solicitudes de descarga de CFDI o metadatos.
 */
public class DownloadRule extends BaseDto {

    private String personId;
    private Person person;
    private String tin;
    private String description;

    // 1 Pendiente, 2 Aprobada, 3 Rechazada, 4 Abandonada
    private String downloadRuleStatusId;
    private CatalogDto downloadRuleStatus;

    // CFDI, Metadata
    private String satQueryTypeId;
    private CatalogDto satQueryType;

    // Emitidos, Recibidos
    private String downloadTypeId;
    private CatalogDto downloadType;

    // Vigente, Cancelado
    private String satInvoiceStatusId;
    private CatalogDto satInvoiceStatus;

    /**
     * Constructor por defecto
     */
    public DownloadRule() {
    }

    /**
     * @return ID de la persona asociada a la regla
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * @param personId ID de la persona asociada a la regla
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return Datos de la persona asociada a la regla
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person Datos de la persona asociada a la regla
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return RFC (Registro Federal de Contribuyentes) asociado
     */
    public String getTin() {
        return tin;
    }

    /**
     * @param tin RFC (Registro Federal de Contribuyentes) asociado
     */
    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     * @return Descripción de la regla de descarga
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Descripción de la regla de descarga
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return ID del estado de la regla de descarga
     */
    public String getDownloadRuleStatusId() {
        return downloadRuleStatusId;
    }

    /**
     * @param downloadRuleStatusId ID del estado de la regla de descarga (1 Pendiente, 2 Aprobada, 3 Rechazada, 4 Abandonada)
     */
    public void setDownloadRuleStatusId(String downloadRuleStatusId) {
        this.downloadRuleStatusId = downloadRuleStatusId;
    }

    /**
     * @return Estado de la regla de descarga
     */
    public CatalogDto getDownloadRuleStatus() {
        return downloadRuleStatus;
    }

    /**
     * @param downloadRuleStatus Estado de la regla de descarga
     */
    public void setDownloadRuleStatus(CatalogDto downloadRuleStatus) {
        this.downloadRuleStatus = downloadRuleStatus;
    }

    /**
     * @return ID del tipo de consulta SAT
     */
    public String getSatQueryTypeId() {
        return satQueryTypeId;
    }

    /**
     * @param satQueryTypeId ID del tipo de consulta SAT (CFDI, Metadata)
     */
    public void setSatQueryTypeId(String satQueryTypeId) {
        this.satQueryTypeId = satQueryTypeId;
    }

    /**
     * @return Tipo de consulta SAT
     */
    public CatalogDto getSatQueryType() {
        return satQueryType;
    }

    /**
     * @param satQueryType Tipo de consulta SAT
     */
    public void setSatQueryType(CatalogDto satQueryType) {
        this.satQueryType = satQueryType;
    }

    /**
     * @return ID del tipo de descarga
     */
    public String getDownloadTypeId() {
        return downloadTypeId;
    }

    /**
     * @param downloadTypeId ID del tipo de descarga (Emitidos, Recibidos)
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
     * @return ID del estado de la factura en SAT
     */
    public String getSatInvoiceStatusId() {
        return satInvoiceStatusId;
    }

    /**
     * @param satInvoiceStatusId ID del estado de la factura en SAT (Vigente, Cancelado)
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
}
