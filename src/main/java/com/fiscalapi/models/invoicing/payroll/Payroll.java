package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.OptUtil;

import java.time.LocalDateTime;
import java.util.List;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

public class Payroll {
    private String version;
    private String payrollTypeCode;
    private LocalDateTime paymentDate;
    private LocalDateTime initialPaymentDate;
    private LocalDateTime finalPaymentDate;
    private int daysPaid;
    private PayrollEarnings earnings;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPayrollTypeCode() {
        return payrollTypeCode;
    }

    public void setPayrollTypeCode(String payrollTypeCode) {
        this.payrollTypeCode = payrollTypeCode;
    }

    @JsonProperty("paymentDate")
    public String getPaymentDate() {
        if (paymentDate == null) {
            return null;
        }
        return paymentDate.format(SAT_DATE_FORMAT_OUT);
    }

    @JsonProperty("paymentDate")
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = OptUtil.formatInputDateToSATFormat(paymentDate);
    }

    public String getInitialPaymentDate() {
        if (initialPaymentDate == null) {
            return null;
        }
        return initialPaymentDate.format(SAT_DATE_FORMAT_OUT);
    }

    public void setInitialPaymentDate(String initialPaymentDate) {
        this.initialPaymentDate = OptUtil.formatInputDateToSATFormat(initialPaymentDate);
    }

    public String getFinalPaymentDate() {
        if (finalPaymentDate == null) {
            return null;
        }
        return finalPaymentDate.format(SAT_DATE_FORMAT_OUT);
    }

    public void setFinalPaymentDate(String finalPaymentDate) {
        this.finalPaymentDate = OptUtil.formatInputDateToSATFormat(finalPaymentDate);
    }

    public int getDaysPaid() {
        return daysPaid;
    }

    public void setDaysPaid(int daysPaid) {
        this.daysPaid = daysPaid;
    }

    public PayrollEarnings getEarnings() {
        return earnings;
    }

    public void setEarnings(PayrollEarnings earnings) {
        this.earnings = earnings;
    }

    public List<PayrollDeduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<PayrollDeduction> deductions) {
        this.deductions = deductions;
    }

    public List<PayrollDisability> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<PayrollDisability> disabilities) {
        this.disabilities = disabilities;
    }

    private List<PayrollDeduction> deductions;
    private List<PayrollDisability> disabilities;
}
