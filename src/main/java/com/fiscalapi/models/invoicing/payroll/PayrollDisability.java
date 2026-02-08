package com.fiscalapi.models.invoicing.payroll;

import java.math.BigDecimal;

public class PayrollDisability {
    private int DisabilityDays;
    private String DisabilityTypeCode;
    private BigDecimal MonetaryAmount;

    public int getDisabilityDays() {
        return DisabilityDays;
    }

    public void setDisabilityDays(int disabilityDays) {
        DisabilityDays = disabilityDays;
    }

    public String getDisabilityTypeCode() {
        return DisabilityTypeCode;
    }

    public void setDisabilityTypeCode(String disabilityTypeCode) {
        DisabilityTypeCode = disabilityTypeCode;
    }

    public BigDecimal getMonetaryAmount() {
        return MonetaryAmount;
    }

    public void setMonetaryAmount(BigDecimal monetaryAmount) {
        MonetaryAmount = monetaryAmount;
    }
}
