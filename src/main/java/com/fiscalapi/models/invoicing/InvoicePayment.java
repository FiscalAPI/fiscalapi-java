package com.fiscalapi.models.invoicing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_IN;
import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;


// Pago o pagos para liquidar una factura previa
public class InvoicePayment {
    @JsonIgnore
    private LocalDateTime paymentDate;
    private String paymentFormCode;
    private String currencyCode;
    private Double exchangeRate;
    private Double amount;
    private String sourceBankTin;
    private String sourceBankAccount;
    private String targetBankTin;
    private String targetBankAccount;
    private List<PaidInvoice> paidInvoices;


    /**
     * @return Fecha y hora de expedición del comprobante fiscal
     */
    @JsonIgnore
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param date Fecha y hora de expedición como objeto LocalDateTime
     */
    @JsonIgnore
    public void setPaymentDate(LocalDateTime date) {
        this.paymentDate = date;
    }

    /**
     * Obtiene la fecha en formato SAT para serialización JSON.
     * Este método se serializa como "date" en el JSON resultante.
     * Siempre se formatea exactamente como 'yyyy-MM-ddTHH:mm:ss' (sin fracciones ni zona)
     *
     * @return Fecha y hora de expedición formateada según el estándar del SAT
     */
    @JsonProperty("paymentDate")
    public String getSatDate() {
        if (paymentDate == null) {
            return null;
        }
        return paymentDate.format(SAT_DATE_FORMAT_OUT);
    }

    /**
     * Establece la fecha a partir de una cadena en formato SAT.
     * Este método deserializa el campo "date" del JSON recibido.
     * Acepta varios formatos de entrada (con milisegundos, con zona horaria, etc.)
     *
     * @param satDate Fecha y hora en formato de texto del SAT
     */
    @JsonProperty("paymentDate")
    public void setSatDate(String satDate) {
        if (satDate == null || satDate.isEmpty()) {
            this.paymentDate = null;
            return;
        }

        try {
            // Intenta primero parsearlo como LocalDateTime
            this.paymentDate = LocalDateTime.parse(satDate, SAT_DATE_FORMAT_IN);
        } catch (DateTimeParseException e) {
            try {
                // Si falla, intenta parsearlo como ZonedDateTime y convertirlo a LocalDateTime
                ZonedDateTime zdt = ZonedDateTime.parse(satDate);
                this.paymentDate = zdt.toLocalDateTime();
            } catch (DateTimeParseException e2) {
                // Si todo falla, lanza la excepción original
                throw new IllegalArgumentException("Formato de fecha inválido: " + satDate +
                        " (debe ser compatible con el formato yyyy-MM-ddTHH:mm:ss)", e);
            }
        }
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