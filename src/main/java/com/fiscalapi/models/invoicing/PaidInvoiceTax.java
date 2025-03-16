package com.fiscalapi.models.invoicing;

// Impuestos aplicables a la factura pagada
public class PaidInvoiceTax {
    private Double base;
    private String taxCode;
    private String taxTypeCode;
    private Double taxRate;
    private String taxFlagCode;

    public Double getBase() {
        return base;
    }
    public void setBase(Double base) {
        this.base = base;
    }
    public String getTaxCode() {
        return taxCode;
    }
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
    public String getTaxTypeCode() {
        return taxTypeCode;
    }
    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }
    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public String getTaxFlagCode() {
        return taxFlagCode;
    }
    public void setTaxFlagCode(String taxFlagCode) {
        this.taxFlagCode = taxFlagCode;
    }
}