package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class PayrollSeverance {
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalPaid;
    private int yearsOfService;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal lastMonthlySalary;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal accumulableIncome;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal nonAccumulableIncome;

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public BigDecimal getLastMonthlySalary() {
        return lastMonthlySalary;
    }

    public void setLastMonthlySalary(BigDecimal lastMonthlySalary) {
        this.lastMonthlySalary = lastMonthlySalary;
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
