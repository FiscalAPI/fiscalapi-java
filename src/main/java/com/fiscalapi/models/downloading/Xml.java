package com.fiscalapi.models.downloading;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.OptUtil;
import com.fiscalapi.common.BaseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

/**
 * Representa el XML de un CFDI (Comprobante Fiscal Digital por Internet) descargado desde el SAT.
 */
public class Xml extends BaseDto {

    // Regla de descarga
    private String downloadRequestId;

    // Versión del CFDI
    private String version;

    // Serie
    private String series;

    // Folio
    private String number;

    // Fecha de emisión del CFDI
    @JsonIgnore
    private LocalDateTime date;

    // Código de la forma de pago
    private String paymentForm;

    // Código del método de pago
    private String paymentMethod;

    // Número de certificado del emisor
    private String certificateNumber;

    // Condiciones de pago
    private String paymentConditions;

    // Subtotal del CFDI
    private BigDecimal subTotal;

    // Descuento aplicado al CFDI
    private BigDecimal discount;

    // Código de la moneda del CFDI
    private String currency;

    // Tipo de cambio del CFDI (si aplica)
    private BigDecimal exchangeRate;

    // Total del CFDI
    private BigDecimal total;

    // Tipo de comprobante (I = Ingreso, E = Egreso, T = Traslado, N = Nómina, P = Pago)
    private String invoiceType;

    // Código de exportación (si aplica)
    private String export;

    // Lugar de expedición del CFDI
    private String expeditionZipCode;

    // Confirmación si aplica
    private String confirmation;

    // Total impuestos retenidos
    private BigDecimal totalWithheldTaxes;

    // Total impuestos trasladados
    private BigDecimal totalTransferredTaxes;

    // Información global del CFDI (para CFDI globales)
    private XmlGlobalInformation xmlGlobalInformation;

    // Información de impuestos del CFDI
    private List<XmlTax> taxes = new ArrayList<>();

    // Información sobre facturas relacionadas del CFDI (CFDI relacionados)
    private List<XmlRelated> xmlRelated = new ArrayList<>();

    // Información del emisor del CFDI
    private XmlIssuer xmlIssuer;

    // Información del receptor del CFDI
    private XmlRecipient xmlRecipient;

    // Información de los conceptos del CFDI
    private List<XmlItem> xmlItems = new ArrayList<>();

    // Información de los complementos del CFDI
    private List<XmlComplement> xmlComplements = new ArrayList<>();

    // XML crudo en base64
    private String base64Content;

    // Constructor por defecto
    public Xml() {}

    // Getters y Setters

    public String getDownloadRequestId() {
        return downloadRequestId;
    }

    public void setDownloadRequestId(String downloadRequestId) {
        this.downloadRequestId = downloadRequestId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonIgnore
    public LocalDateTime getDate() {
        return date;
    }

    @JsonIgnore
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Obtiene la fecha en formato SAT para serialización JSON.
     * Este método se serializa como "date" en el JSON resultante.
     * Siempre se formatea exactamente como 'yyyy-MM-ddTHH:mm:ss' (sin fracciones ni zona)
     *
     * @return Fecha y hora de expedición formateada según el estándar del SAT
     */
    @JsonProperty("date")
    public String getSatDate() {
        if (date == null) {
            return null;
        }
        return date.format(SAT_DATE_FORMAT_OUT);
    }

    /**
     * Establece la fecha a partir de una cadena en formato SAT.
     * Este método deserializa el campo "date" del JSON recibido.
     * Acepta varios formatos de entrada (con milisegundos, con zona horaria, etc.)
     *
     * @param satDate Fecha y hora en formato de texto del SAT
     */
    @JsonProperty("date")
    public void setSatDate(String satDate) {
        this.date = OptUtil.parseLocalDateTime(satDate);
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getPaymentConditions() {
        return paymentConditions;
    }

    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public String getExpeditionZipCode() {
        return expeditionZipCode;
    }

    public void setExpeditionZipCode(String expeditionZipCode) {
        this.expeditionZipCode = expeditionZipCode;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public BigDecimal getTotalWithheldTaxes() {
        return totalWithheldTaxes;
    }

    public void setTotalWithheldTaxes(BigDecimal totalWithheldTaxes) {
        this.totalWithheldTaxes = totalWithheldTaxes;
    }

    public BigDecimal getTotalTransferredTaxes() {
        return totalTransferredTaxes;
    }

    public void setTotalTransferredTaxes(BigDecimal totalTransferredTaxes) {
        this.totalTransferredTaxes = totalTransferredTaxes;
    }

    public XmlGlobalInformation getXmlGlobalInformation() {
        return xmlGlobalInformation;
    }

    public void setXmlGlobalInformation(XmlGlobalInformation xmlGlobalInformation) {
        this.xmlGlobalInformation = xmlGlobalInformation;
    }

    public List<XmlTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<XmlTax> taxes) {
        this.taxes = taxes;
    }

    public List<XmlRelated> getXmlRelated() {
        return xmlRelated;
    }

    public void setXmlRelated(List<XmlRelated> xmlRelated) {
        this.xmlRelated = xmlRelated;
    }

    public XmlIssuer getXmlIssuer() {
        return xmlIssuer;
    }

    public void setXmlIssuer(XmlIssuer xmlIssuer) {
        this.xmlIssuer = xmlIssuer;
    }

    public XmlRecipient getXmlRecipient() {
        return xmlRecipient;
    }

    public void setXmlRecipient(XmlRecipient xmlRecipient) {
        this.xmlRecipient = xmlRecipient;
    }

    public List<XmlItem> getXmlItems() {
        return xmlItems;
    }

    public void setXmlItems(List<XmlItem> xmlItems) {
        this.xmlItems = xmlItems;
    }

    public List<XmlComplement> getXmlComplements() {
        return xmlComplements;
    }

    public void setXmlComplements(List<XmlComplement> xmlComplements) {
        this.xmlComplements = xmlComplements;
    }

    public String getBase64Content() {
        return base64Content;
    }

    public void setBase64Content(String base64Content) {
        this.base64Content = base64Content;
    }
}

/**
 * Información global del CFDI.
 */
class XmlGlobalInformation extends BaseDto {
    private String periodicity;
    private String month;
    private Integer year;

    public XmlGlobalInformation() {}

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

/**
 * Información del emisor del CFDI.
 */
class XmlIssuer extends BaseDto {
    private String tin;
    private String legalName;
    private String taxRegime;

    public XmlIssuer() {}

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }
}

/**
 * Información del receptor del CFDI.
 */
class XmlRecipient extends BaseDto {
    private String tin;
    private String legalName;
    private String zipCode;
    private String taxRegime;
    private String cfdiUse;
    private String foreignTaxId;
    private String fiscalResidence;

    public XmlRecipient() {}

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }

    public String getCfdiUse() {
        return cfdiUse;
    }

    public void setCfdiUse(String cfdiUse) {
        this.cfdiUse = cfdiUse;
    }

    public String getForeignTaxId() {
        return foreignTaxId;
    }

    public void setForeignTaxId(String foreignTaxId) {
        this.foreignTaxId = foreignTaxId;
    }

    public String getFiscalResidence() {
        return fiscalResidence;
    }

    public void setFiscalResidence(String fiscalResidence) {
        this.fiscalResidence = fiscalResidence;
    }
}

/**
 * Información de los conceptos del CFDI.
 */
class XmlItem extends BaseDto {
    private String xmlId;
    private String itemCode;
    private String sku;
    private BigDecimal quantity;
    private String unitMeasurement;
    private String description;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private BigDecimal discount;
    private String taxObject;
    private String thirdPartyAccount;

    private List<XmlItemCustomsInformation> xmlItemCustomsInformation = new ArrayList<>();
    private List<XmlItemPropertyAccount> xmlItemPropertyAccounts = new ArrayList<>();
    private List<XmlItemTax> taxes = new ArrayList<>();

    public XmlItem() {}

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getTaxObject() {
        return taxObject;
    }

    public void setTaxObject(String taxObject) {
        this.taxObject = taxObject;
    }

    public String getThirdPartyAccount() {
        return thirdPartyAccount;
    }

    public void setThirdPartyAccount(String thirdPartyAccount) {
        this.thirdPartyAccount = thirdPartyAccount;
    }

    public List<XmlItemCustomsInformation> getXmlItemCustomsInformation() {
        return xmlItemCustomsInformation;
    }

    public void setXmlItemCustomsInformation(List<XmlItemCustomsInformation> xmlItemCustomsInformation) {
        this.xmlItemCustomsInformation = xmlItemCustomsInformation;
    }

    public List<XmlItemPropertyAccount> getXmlItemPropertyAccounts() {
        return xmlItemPropertyAccounts;
    }

    public void setXmlItemPropertyAccounts(List<XmlItemPropertyAccount> xmlItemPropertyAccounts) {
        this.xmlItemPropertyAccounts = xmlItemPropertyAccounts;
    }

    public List<XmlItemTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<XmlItemTax> taxes) {
        this.taxes = taxes;
    }
}

/**
 * Información de aduanas de los conceptos.
 */
class XmlItemCustomsInformation extends BaseDto {
    private String xmlItemId;
    private String customsDocumentNumber;

    public XmlItemCustomsInformation() {}

    public String getXmlItemId() {
        return xmlItemId;
    }

    public void setXmlItemId(String xmlItemId) {
        this.xmlItemId = xmlItemId;
    }

    public String getCustomsDocumentNumber() {
        return customsDocumentNumber;
    }

    public void setCustomsDocumentNumber(String customsDocumentNumber) {
        this.customsDocumentNumber = customsDocumentNumber;
    }
}

/**
 * Información de cuenta predial de los conceptos.
 */
class XmlItemPropertyAccount extends BaseDto {
    private String xmlItemId;
    private String propertyAccountNumber;

    public XmlItemPropertyAccount() {}

    public String getXmlItemId() {
        return xmlItemId;
    }

    public void setXmlItemId(String xmlItemId) {
        this.xmlItemId = xmlItemId;
    }

    public String getPropertyAccountNumber() {
        return propertyAccountNumber;
    }

    public void setPropertyAccountNumber(String propertyAccountNumber) {
        this.propertyAccountNumber = propertyAccountNumber;
    }
}

/**
 * Información de impuestos de los conceptos.
 */
class XmlItemTax extends BaseDto {
    private BigDecimal base;
    private String tax;
    private String taxType;
    private BigDecimal rate;
    private BigDecimal amount;
    private String taxFlag;
    private String xmlItemId;

    public XmlItemTax() {}

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(String taxFlag) {
        this.taxFlag = taxFlag;
    }

    public String getXmlItemId() {
        return xmlItemId;
    }

    public void setXmlItemId(String xmlItemId) {
        this.xmlItemId = xmlItemId;
    }
}

/**
 * Información sobre facturas relacionadas del CFDI (CFDI relacionados).
 */
class XmlRelated extends BaseDto {
    private String xmlId;
    private String relationshipType;
    private String cfdiUuid;

    public XmlRelated() {}

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getCfdiUuid() {
        return cfdiUuid;
    }

    public void setCfdiUuid(String cfdiUuid) {
        this.cfdiUuid = cfdiUuid;
    }
}

/**
 * Información de impuestos del CFDI.
 */
class XmlTax extends BaseDto {
    private BigDecimal base;
    private String tax;
    private String taxType;
    private BigDecimal rate;
    private BigDecimal amount;
    private String taxFlag;
    private String xmlId;

    public XmlTax() {}

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(String taxFlag) {
        this.taxFlag = taxFlag;
    }

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }
}

/**
 * Información de los complementos del CFDI.
 */
class XmlComplement extends BaseDto {
    private String complementName;
    private String base64ComplementValue;
    private String xmlId;

    public XmlComplement() {}

    public String getComplementName() {
        return complementName;
    }

    public void setComplementName(String complementName) {
        this.complementName = complementName;
    }

    public String getBase64ComplementValue() {
        return base64ComplementValue;
    }

    public void setBase64ComplementValue(String base64ComplementValue) {
        this.base64ComplementValue = base64ComplementValue;
    }

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }
}

