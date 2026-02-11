package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.MoneySerializer;
import java.math.BigDecimal;
import java.util.List;

public class PayrollEarning {
    private String earningTypeCode;
    private String code;
    private String concept;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal taxedAmount;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal exemptAmount;
    private List<PayrollEarningOvertime> overtime;
    private PayrollStockOptions stockOptions;

    public String getEarningTypeCode() {
        return earningTypeCode;
    }

    public void setEarningTypeCode(String earningTypeCode) {
        this.earningTypeCode = earningTypeCode;
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

    public BigDecimal getTaxedAmount() {
        return taxedAmount;
    }

    public void setTaxedAmount(BigDecimal taxedAmount) {
        this.taxedAmount = taxedAmount;
    }

    public BigDecimal getExemptAmount() {
        return exemptAmount;
    }

    public void setExemptAmount(BigDecimal exemptAmount) {
        this.exemptAmount = exemptAmount;
    }

    public List<PayrollEarningOvertime> getOvertime() {
        return overtime;
    }

    public void setOvertime(List<PayrollEarningOvertime> overtime) {
        this.overtime = overtime;
    }

    public PayrollStockOptions getStockOptions() {
        return stockOptions;
    }

    public void setStockOptions(PayrollStockOptions stockOptions) {
        this.stockOptions = stockOptions;
    }
}
