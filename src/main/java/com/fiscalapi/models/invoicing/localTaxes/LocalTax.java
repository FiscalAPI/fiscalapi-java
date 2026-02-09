package com.fiscalapi.models.invoicing.localTaxes;

import com.fiscalapi.OptUtil;

import java.math.BigDecimal;

public class LocalTax {
    private String taxName;
    private BigDecimal taxRate;
    private String taxFlagCode;
    private BigDecimal taxAmount;

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = OptUtil.parseBigDecimal(taxRate);
    }

    public String getTaxFlagCode() {
        return taxFlagCode;
    }

    public void setTaxFlagCode(String taxFlagCode) {
        this.taxFlagCode = taxFlagCode;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = OptUtil.parseBigDecimal(taxAmount);
    }
}
