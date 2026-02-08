package com.fiscalapi.models.invoicing.payroll;

import java.math.BigDecimal;

public class PayrollRetirement {
    private BigDecimal totalOneTime;
    private BigDecimal totalInstallments;
    private BigDecimal dailyAmount;
    private BigDecimal accumulableIncome;
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
