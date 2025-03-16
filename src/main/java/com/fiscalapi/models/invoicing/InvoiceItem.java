package com.fiscalapi.models.invoicing;

import java.util.List;

// Concepto de la factura (producto o servicio)
public class InvoiceItem {
    private String id;
    private String itemCode;
    private Double quantity;
    private Double discount;
    private String unitOfMeasurementCode;
    private String description;
    private Double unitPrice;
    private String taxObjectCode;
    private String itemSku;
    private List<ItemTax> itemTaxes;

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
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
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
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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
}