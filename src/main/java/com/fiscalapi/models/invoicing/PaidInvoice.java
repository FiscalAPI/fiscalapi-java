package com.fiscalapi.models.invoicing;

import java.util.List;

// Factura pagada parcial o totalmente
public class PaidInvoice {
    private String uuid;
    private String series;
    private Double paymentAmount;
    private String number;
    private String currencyCode;
    private Integer partialityNumber;
    private Double subTotal;
    private Double previousBalance;
    private Double remainingBalance;
    private String taxObjectCode;
    private Double equivalence;
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
    public Double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(Double amount) {
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
    public Double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    public Double getPreviousBalance() {
        return previousBalance;
    }
    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }
    public Double getRemainingBalance() {
        return remainingBalance;
    }
    public void setRemainingBalance(Double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
    public String getTaxObjectCode() {
        return taxObjectCode;
    }
    public void setTaxObjectCode(String taxObjectCode) {
        this.taxObjectCode = taxObjectCode;
    }
    public Double getEquivalence() {
        return equivalence;
    }
    public void setEquivalence(Double equivalence) {
        this.equivalence = equivalence;
    }
    public List<PaidInvoiceTax> getPaidInvoiceTaxes() {
        return paidInvoiceTaxes;
    }
    public void setPaidInvoiceTaxes(List<PaidInvoiceTax> paidInvoiceTaxes) {
        this.paidInvoiceTaxes = paidInvoiceTaxes;
    }
}