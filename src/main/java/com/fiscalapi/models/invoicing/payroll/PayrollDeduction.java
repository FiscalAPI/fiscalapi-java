package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.MoneySerializer;

import java.math.BigDecimal;

public class PayrollDeduction {
    private String deductionTypeCode;
    private String code;
    private String concept;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount;

    public String getDeductionTypeCode() {
        return deductionTypeCode;
    }

    public void setDeductionTypeCode(String deductionTypeCode) {
        this.deductionTypeCode = deductionTypeCode;
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
}
