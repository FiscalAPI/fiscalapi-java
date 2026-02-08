package com.fiscalapi.models.invoicing;

import com.fiscalapi.models.invoicing.localTaxes.LocalTaxes;
import com.fiscalapi.models.invoicing.paymentComplement.InvoicePayment;
import com.fiscalapi.models.invoicing.payroll.Payroll;

public class Complement {
    private Payroll payroll;
    private InvoicePayment payment;
    private LocalTaxes localTaxes;

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public InvoicePayment getPayment() {
        return payment;
    }

    public void setPayment(InvoicePayment payment) {
        this.payment = payment;
    }

    public LocalTaxes getLocalTaxes() {
        return localTaxes;
    }

    public void setLocalTaxes(LocalTaxes localTaxes) {
        this.localTaxes = localTaxes;
    }
}
