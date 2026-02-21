package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class PayrollDisability {
    private int disabilityDays;
    private String disabilityTypeCode;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal monetaryAmount;

    public int getDisabilityDays() {
        return disabilityDays;
    }

    public void setDisabilityDays(int disabilityDays) {
        this.disabilityDays = disabilityDays;
    }

    public String getDisabilityTypeCode() {
        return disabilityTypeCode;
    }

    public void setDisabilityTypeCode(String disabilityTypeCode) {
        this.disabilityTypeCode = disabilityTypeCode;
    }

    public BigDecimal getMonetaryAmount() {
        return monetaryAmount;
    }

    public void setMonetaryAmount(BigDecimal monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }
}
