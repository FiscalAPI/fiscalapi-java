package com.fiscalapi.models.invoicing;

import java.util.List;

// Pago o pagos para liquidar una factura previa
public class InvoicePayment {
    private String paymentDate;
    private String paymentFormCode;
    private String currencyCode;
    private Double exchangeRate;
    private Double amount;
    private String sourceBankTin;
    private String sourceBankAccount;
    private String targetBankTin;
    private String targetBankAccount;
    private List<PaidInvoice> paidInvoices;

    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getPaymentFormCode() {
        return paymentFormCode;
    }
    public void setPaymentFormCode(String paymentFormCode) {
        this.paymentFormCode = paymentFormCode;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public Double getExchangeRate() {
        return exchangeRate;
    }
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getSourceBankTin() {
        return sourceBankTin;
    }
    public void setSourceBankTin(String sourceBankTin) {
        this.sourceBankTin = sourceBankTin;
    }
    public String getSourceBankAccount() {
        return sourceBankAccount;
    }
    public void setSourceBankAccount(String sourceBankAccount) {
        this.sourceBankAccount = sourceBankAccount;
    }
    public String getTargetBankTin() {
        return targetBankTin;
    }
    public void setTargetBankTin(String targetBankTin) {
        this.targetBankTin = targetBankTin;
    }
    public String getTargetBankAccount() {
        return targetBankAccount;
    }
    public void setTargetBankAccount(String targetBankAccount) {
        this.targetBankAccount = targetBankAccount;
    }
    public List<PaidInvoice> getPaidInvoices() {
        return paidInvoices;
    }
    public void setPaidInvoices(List<PaidInvoice> paidInvoices) {
        this.paidInvoices = paidInvoices;
    }
}