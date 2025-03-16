package com.fiscalapi.models.invoicing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.common.BaseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;


/**
 * Modelo anémico que representa una factura electrónica.
 * Contiene toda la información de una factura, como datos del emisor, receptor,
 * productos/servicios, importes, método de pago, tipo de factura, entre otros.
 */
public class Invoice extends BaseDto{
    private static final DateTimeFormatter SAT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private String versionCode;
    private String series;
    @JsonIgnore
    private LocalDateTime date;
    private String paymentFormCode;
    private String currencyCode;
    private String typeCode;
    private String expeditionZipCode;
    private String exportCode;
    private String paymentMethodCode;
    private Double exchangeRate;
    private InvoiceIssuer issuer;
    private InvoiceRecipient recipient;
    private List<InvoiceItem> items;
    private GlobalInformation globalInformation;
    private List<RelatedInvoice> relatedInvoices;
    private List<InvoicePayment> payments;
    private List<InvoiceResponse> responses;

    /**
     * Constructor por defecto
     */
    public Invoice() {
        this.versionCode = "4.0";
        this.currencyCode = "MXN";
        this.exportCode = "01";
        //this.exchangeRate = 1.0;
    }

    /**
     * @return Código de la versión de la factura
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * @param versionCode Código de la versión de la factura
     */
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    /**
     * @return Número de serie para control interno
     */
    public String getSeries() {
        return series;
    }

    /**
     * @param series Número de serie para control interno (1-25 caracteres alfanuméricos)
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * @return Fecha y hora de expedición del comprobante fiscal
     */
    @JsonIgnore
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date Fecha y hora de expedición como objeto LocalDateTime
     */
    @JsonIgnore
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Obtiene la fecha en formato SAT para serialización JSON.
     * Este método se serializa como "date" en el JSON resultante.
     *
     * @return Fecha y hora de expedición formateada según el estándar del SAT (AAAA-MM-DDThh:mm:ss)
     */
    @JsonProperty("date")
    public String getSatDate() {
        if (date == null) {
            return null;
        }
        return date.format(SAT_DATE_FORMAT);
    }

    /**
     * Establece la fecha a partir de una cadena en formato SAT.
     * Este método deserializa el campo "date" del JSON recibido.
     *
     * @param satDate Fecha y hora en formato de texto según el estándar del SAT (AAAA-MM-DDThh:mm:ss)
     */
    @JsonProperty("date")
    public void setSatDate(String satDate) {
        if (satDate == null || satDate.isEmpty()) {
            this.date = null;
            return;
        }
        this.date = LocalDateTime.parse(satDate, SAT_DATE_FORMAT);
    }



    /**
     * @return Código de la forma de pago para la factura
     */
    public String getPaymentFormCode() {
        return paymentFormCode;
    }

    /**
     * @param paymentFormCode Código de la forma de pago (Catálogo del SAT c_FormaPago)
     */
    public void setPaymentFormCode(String paymentFormCode) {
        this.paymentFormCode = paymentFormCode;
    }

    /**
     * @return Código de la moneda utilizada para expresar los montos
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode Código de la moneda (Catálogo del SAT c_Moneda)
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return Código de tipo de factura
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * @param typeCode Código de tipo de factura (Catálogo del SAT c_TipoDeComprobante)
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * @return Código postal del emisor
     */
    public String getExpeditionZipCode() {
        return expeditionZipCode;
    }

    /**
     * @param expeditionZipCode Código postal del emisor según constancia de situación fiscal
     */
    public void setExpeditionZipCode(String expeditionZipCode) {
        this.expeditionZipCode = expeditionZipCode;
    }

    /**
     * @return Código que identifica si la factura ampara una operación de exportación
     */
    public String getExportCode() {
        return exportCode;
    }

    /**
     * @param exportCode Código de exportación (Catálogo del SAT c_Exportacion)
     */
    public void setExportCode(String exportCode) {
        this.exportCode = exportCode;
    }

    /**
     * @return Código de método para la factura de pago
     */
    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    /**
     * @param paymentMethodCode Código del método de pago (Catálogo del SAT c_MetodoPago)
     */
    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    /**
     * @return Tipo de cambio conforme a la moneda registrada
     */
    public Double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param exchangeRate Tipo de cambio FIX (Si la moneda es MXN, el valor debe ser 1)
     */
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * @return Datos del emisor de la factura
     */
    public InvoiceIssuer getIssuer() {
        return issuer;
    }

    /**
     * @param issuer Datos del emisor de la factura
     */
    public void setIssuer(InvoiceIssuer issuer) {
        this.issuer = issuer;
    }

    /**
     * @return Datos del receptor de la factura
     */
    public InvoiceRecipient getRecipient() {
        return recipient;
    }

    /**
     * @param recipient Datos del receptor de la factura
     */
    public void setRecipient(InvoiceRecipient recipient) {
        this.recipient = recipient;
    }

    /**
     * @return Lista de ítems o conceptos de la factura
     */
    public List<InvoiceItem> getItems() {
        return items;
    }

    /**
     * @param items Lista de ítems o conceptos de la factura
     */
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    /**
     * @return Información global de la factura
     */
    public GlobalInformation getGlobalInformation() {
        return globalInformation;
    }

    /**
     * @param globalInformation Información global de la factura
     */
    public void setGlobalInformation(GlobalInformation globalInformation) {
        this.globalInformation = globalInformation;
    }

    /**
     * @return Lista de facturas relacionadas
     */
    public List<RelatedInvoice> getRelatedInvoices() {
        return relatedInvoices;
    }

    /**
     * @param relatedInvoices Lista de facturas relacionadas
     */
    public void setRelatedInvoices(List<RelatedInvoice> relatedInvoices) {
        this.relatedInvoices = relatedInvoices;
    }

    /**
     * @return Lista de pagos asociados a la factura
     */
    public List<InvoicePayment> getPayments() {
        return payments;
    }

    /**
     * @param payments Lista de pagos asociados a la factura
     */
    public void setPayments(List<InvoicePayment> payments) {
        this.payments = payments;
    }

    /**
     * @return Lista de respuestas asociadas a la factura
     */
    public List<InvoiceResponse> getResponses() {
        return responses;
    }

    /**
     * @param responses Lista de respuestas asociadas a la factura
     */
    public void setResponses(List<InvoiceResponse> responses) {
        this.responses = responses;
    }
}