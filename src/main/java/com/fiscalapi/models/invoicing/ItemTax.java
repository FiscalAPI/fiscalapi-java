package com.fiscalapi.models.invoicing;

import com.fiscalapi.OptUtil;

import java.math.BigDecimal;

// Impuestos aplicables al concepto
public class ItemTax {
    private String taxCode;
    private String taxTypeCode;
    private BigDecimal taxRate;
    private String taxFlagCode;

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
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    public String getTaxFlagCode() {
        return taxFlagCode;
    }
    public void setTaxFlagCode(String taxFlagCode) {
        this.taxFlagCode = taxFlagCode;
    }
}