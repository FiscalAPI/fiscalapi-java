package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class PayrollEarningOvertime {
    private int days;
    private String hoursTypeCode;
    private int extraHours;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal amountPaid;

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
}
