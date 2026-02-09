package com.fiscalapi.models.invoicing.payroll;

import java.math.BigDecimal;

public class PayrollEarningOvertime {
    private int days;
    private String hoursTypeCode;
    private int extraHours;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getHoursTypeCode() {
        return hoursTypeCode;
    }

    public void setHoursTypeCode(String hoursTypeCode) {
        this.hoursTypeCode = hoursTypeCode;
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    private BigDecimal amountPaid;
}
