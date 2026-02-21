package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class PayrollEarningOtherPayment {
    private String otherPaymentTypeCode;
    private String code;
    private String concept;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal amount;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal subsidyCaused;

    public String getOtherPaymentTypeCode() {
        return otherPaymentTypeCode;
    }

    public void setOtherPaymentTypeCode(String otherPaymentTypeCode) {
        this.otherPaymentTypeCode = otherPaymentTypeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSubsidyCaused() {
        return subsidyCaused;
    }

    public void setSubsidyCaused(BigDecimal subsidyCaused) {
        this.subsidyCaused = subsidyCaused;
    }

    public BalanceCompensation getBalanceCompensation() {
        return balanceCompensation;
    }

    public void setBalanceCompensation(BalanceCompensation balanceCompensation) {
        this.balanceCompensation = balanceCompensation;
    }

    private BalanceCompensation balanceCompensation;
}
