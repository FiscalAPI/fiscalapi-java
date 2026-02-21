package com.fiscalapi.models.invoicing.payroll;

import java.util.List;

public class PayrollEarnings {
    private List<PayrollEarning> earnings;
    private List<PayrollEarningOtherPayment> otherPayments;
    private PayrollRetirement retirement;
    private PayrollSeverance severance;


    public List<PayrollEarning> getEarnings() {
        return earnings;
    }

    public void setEarnings(List<PayrollEarning> earnings) {
        this.earnings = earnings;
    }

    public List<PayrollEarningOtherPayment> getOtherPayments() {
        return otherPayments;
    }

    public void setOtherPayments(List<PayrollEarningOtherPayment> otherPayments) {
        this.otherPayments = otherPayments;
    }

    public PayrollRetirement getRetirement() {
        return retirement;
    }

    public void setRetirement(PayrollRetirement retirement) {
        this.retirement = retirement;
    }

    public PayrollSeverance getSeverance() {
        return severance;
    }

    public void setSeverance(PayrollSeverance severance) {
        this.severance = severance;
    }
}
