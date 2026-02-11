package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.OptUtil;

import java.time.LocalDateTime;
import java.util.List;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

public class Payroll {
    private String version;
    private String payrollTypeCode;
    private List<PayrollDeduction> deductions;
    private List<PayrollDisability> disabilities;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime paymentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime initialPaymentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
    public LocalDateTime getPaymentDate() {
            if (paymentDate == null) {
                return null;
            }
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getInitialPaymentDate() {
        return initialPaymentDate;
    }

    public void setInitialPaymentDate(LocalDateTime initialPaymentDate) {
        this.initialPaymentDate = initialPaymentDate;
    }

    public LocalDateTime getFinalPaymentDate() {
        return finalPaymentDate;
    }

    public void setFinalPaymentDate(LocalDateTime finalPaymentDate) {
        this.finalPaymentDate = finalPaymentDate;
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
}
