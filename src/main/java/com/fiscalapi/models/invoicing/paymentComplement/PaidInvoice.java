package com.fiscalapi.models.invoicing.paymentComplement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.MoneySerializer;

import java.math.BigDecimal;
import java.util.List;

// Factura pagada parcial o totalmente
public class PaidInvoice {
    private String uuid;
    private String series;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal paymentAmount;
    private String number;
    private String currencyCode;
    private Integer partialityNumber;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal subTotal;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal previousBalance;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal remainingBalance;
    private String taxObjectCode;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal equivalence;
    private List<PaidInvoiceTax> paidInvoiceTaxes;

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(BigDecimal amount) {
        this.paymentAmount = amount;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public Integer getPartialityNumber() {
        return partialityNumber;
    }
    public void setPartialityNumber(Integer partialityNumber) {
        this.partialityNumber = partialityNumber;
    }
    public BigDecimal getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }
    public void setPreviousBalance(BigDecimal previousBalance) {
        this.previousBalance = previousBalance;
    }
    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }
    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
    public String getTaxObjectCode() {
        return taxObjectCode;
    }
    public void setTaxObjectCode(String taxObjectCode) {
        this.taxObjectCode = taxObjectCode;
    }
    public BigDecimal getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(BigDecimal equivalence) {
        this.equivalence = equivalence;
    }
    public List<PaidInvoiceTax> getPaidInvoiceTaxes() {
        return paidInvoiceTaxes;
    }
    public void setPaidInvoiceTaxes(List<PaidInvoiceTax> paidInvoiceTaxes) {
        this.paidInvoiceTaxes = paidInvoiceTaxes;
    }
}