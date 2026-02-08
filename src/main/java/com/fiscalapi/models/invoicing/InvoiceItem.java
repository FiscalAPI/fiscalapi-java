package com.fiscalapi.models.invoicing;

import java.math.BigDecimal;
import java.util.List;

// Concepto de la factura (producto o servicio)
public class InvoiceItem {
    private String id;
    private String itemCode;
    private BigDecimal quantity;
    private BigDecimal discount;
    private String unitOfMeasurementCode;
    private String unitOfMeasurement;
    private String description;
    private BigDecimal unitPrice;
    private String taxObjectCode;
    private String itemSku;
    private List<ItemTax> itemTaxes;
    private OnBehalfOf onBehalfOf;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = new BigDecimal(quantity);
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = new BigDecimal(discount);
    }
    public String getUnitOfMeasurementCode() {
        return unitOfMeasurementCode;
    }
    public void setUnitOfMeasurementCode(String unitOfMeasurementCode) {
        this.unitOfMeasurementCode = unitOfMeasurementCode;
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
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = new BigDecimal(unitPrice);
    }
    public String getTaxObjectCode() {
        return taxObjectCode;
    }
    public void setTaxObjectCode(String taxObjectCode) {
        this.taxObjectCode = taxObjectCode;
    }
    public String getItemSku() {
        return itemSku;
    }
    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }
    public List<ItemTax> getItemTaxes() {
        return itemTaxes;
    }
    public void setItemTaxes(List<ItemTax> itemTaxes) {
        this.itemTaxes = itemTaxes;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public OnBehalfOf getOnBehalfOf() {
        return onBehalfOf;
    }

    public void setOnBehalfOf(OnBehalfOf onBehalfOf) {
        this.onBehalfOf = onBehalfOf;
    }
}