package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.MoneySerializer;
import java.math.BigDecimal;

public class PayrollRetirement {
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal totalOneTime;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal totalInstallments;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal dailyAmount;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal accumulableIncome;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal nonAccumulableIncome;

    public BigDecimal getTotalOneTime() {
        return totalOneTime;
    }

    public void setTotalOneTime(BigDecimal totalOneTime) {
        this.totalOneTime = totalOneTime;
    }

    public BigDecimal getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(BigDecimal totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public BigDecimal getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(BigDecimal dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public BigDecimal getAccumulableIncome() {
        return accumulableIncome;
    }

    public void setAccumulableIncome(BigDecimal accumulableIncome) {
        this.accumulableIncome = accumulableIncome;
    }

    public BigDecimal getNonAccumulableIncome() {
        return nonAccumulableIncome;
    }

    public void setNonAccumulableIncome(BigDecimal nonAccumulableIncome) {
        this.nonAccumulableIncome = nonAccumulableIncome;
    }
}
