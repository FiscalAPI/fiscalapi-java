package com.fiscalapi.models.invoicing.paymentComplement;

import com.fiscalapi.OptUtil;

import java.math.BigDecimal;
import java.util.List;

// Factura pagada parcial o totalmente
public class PaidInvoice {
    private String uuid;
    private String series;
    private BigDecimal paymentAmount;
    private String number;
    private String currencyCode;
    private Integer partialityNumber;
    private BigDecimal subTotal;
    private BigDecimal previousBalance;
    private BigDecimal remainingBalance;
    private String taxObjectCode;
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
    public void setPaymentAmount(String amount) {
        this.paymentAmount = OptUtil.parseBigDecimal(amount);
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
    public void setSubTotal(String subTotal) {
        this.subTotal = OptUtil.parseBigDecimal(subTotal);
    }
    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }
    public void setPreviousBalance(String previousBalance) {
        this.previousBalance = OptUtil.parseBigDecimal(previousBalance);
    }
    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }
    public void setRemainingBalance(String remainingBalance) {
        this.remainingBalance = OptUtil.parseBigDecimal(remainingBalance);
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
    public void setEquivalence(String equivalence) {
        this.equivalence = OptUtil.parseBigDecimal(equivalence);
    }
    public List<PaidInvoiceTax> getPaidInvoiceTaxes() {
        return paidInvoiceTaxes;
    }
    public void setPaidInvoiceTaxes(List<PaidInvoiceTax> paidInvoiceTaxes) {
        this.paidInvoiceTaxes = paidInvoiceTaxes;
    }
}