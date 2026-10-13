package com.fiscalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.common.BaseDto;

/**
 * Movimiento del ledger de timbres.
 *
 * <p>transactionType, transactionStatus y creditType guardan el entero de la API tal cual: un valor que este SDK
 * todavía no conoce se lee como null en el getter del enum (igual que antes), conserva su número en el getter *Value y
 * se vuelve a serializar sin perderse.</p>
 */
public class StampTransaction extends BaseDto {
    private int consecutive;
    private UserLookupDto fromPerson;
    private UserLookupDto toPerson;
    private int amount;
    @JsonProperty("transactionType")
    private Integer transactionType;
    @JsonProperty("transactionStatus")
    private Integer transactionStatus;
    private String referenceId;
    private String comments;
    @JsonProperty("creditType")
    private Integer creditType;

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public UserLookupDto getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(UserLookupDto fromPerson) {
        this.fromPerson = fromPerson;
    }

    public UserLookupDto getToPerson() {
        return toPerson;
    }

    public void setToPerson(UserLookupDto toPerson) {
        this.toPerson = toPerson;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return El tipo de movimiento, o null si este SDK no conoce el número de la API (ver {@link #getTransactionTypeValue()})
     */
    @JsonIgnore
    public StampTransactionType getTransactionType() {
        return transactionType == null ? null : StampTransactionType.fromValue(transactionType);
    }

    @JsonIgnore
    public void setTransactionType(StampTransactionType transactionType) {
        this.transactionType = transactionType == null ? null : transactionType.getValue();
    }

    /**
     * @return El entero del tipo de movimiento tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public Integer getTransactionTypeValue() {
        return transactionType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return El estado del movimiento, o null si este SDK no conoce el número de la API (ver {@link #getTransactionStatusValue()})
     */
    @JsonIgnore
    public StampTransactionStatus getTransactionStatus() {
        return transactionStatus == null ? null : StampTransactionStatus.fromValue(transactionStatus);
    }

    @JsonIgnore
    public void setTransactionStatus(StampTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus == null ? null : transactionStatus.getValue();
    }

    /**
     * @return El entero del estado tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public Integer getTransactionStatusValue() {
        return transactionStatus;
    }

    /**
     * Tipo de crédito que movió la transacción: timbres, créditos de validación SAT o créditos de ticket.
     *
     * @return El tipo de crédito de la transacción, o null si este SDK no conoce el número de la API (ver {@link #getCreditTypeValue()})
     */
    @JsonIgnore
    public CreditType getCreditType() {
        return creditType == null ? null : CreditType.fromValue(creditType);
    }

    @JsonIgnore
    public void setCreditType(CreditType creditType) {
        this.creditType = creditType == null ? null : creditType.getValue();
    }

    /**
     * @return El entero del tipo de crédito tal como lo envió la API, también si este SDK no lo conoce
     */
    @JsonIgnore
    public Integer getCreditTypeValue() {
        return creditType;
    }
}
