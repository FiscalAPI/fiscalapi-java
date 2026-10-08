package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Payroll {
    private String version;
    private String payrollTypeCode;
    private List<PayrollDeduction> deductions;
    private List<PayrollDisability> disabilities;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime paymentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime initialPaymentDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime finalPaymentDate;

    /**
     * Dias pagados (NumDiasPagados): entero o con hasta 3 decimales. Use {@code new BigDecimal("15.5")} o
     * {@code BigDecimal.valueOf(15.5)}, no {@code new BigDecimal(15.5)} con un double que no sea exacto.
     */
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal daysPaid;
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

    public BigDecimal getDaysPaid() {
        return daysPaid;
    }

    public void setDaysPaid(BigDecimal daysPaid) {
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
