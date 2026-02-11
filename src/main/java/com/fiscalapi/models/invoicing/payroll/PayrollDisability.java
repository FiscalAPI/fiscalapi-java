package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class PayrollDisability {
    private int DisabilityDays;
    private String DisabilityTypeCode;
    @JsonSerialize(using = BigDecimalSerializer.class)
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
