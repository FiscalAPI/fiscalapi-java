package com.fiscalapi.models;

public class StampTransactionParams
{
    private String fromPersonId;
    private String toPersonId;
    private int amount;
    private String comments;
    private CreditType creditType = CreditType.STAMP;

    public String getFromPersonId() {
        return fromPersonId;
    }

    public void setFromPersonId(String fromPersonId) {
        this.fromPersonId = fromPersonId;
    }

    public String getToPersonId() {
        return toPersonId;
    }

    public void setToPersonId(String toPersonId) {
        this.toPersonId = toPersonId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Tipo de crédito a transferir: STAMP (timbres) o VALIDATION (créditos de validación SAT).
     * Si no se asigna, se transfieren timbres.
     *
     * @return El tipo de crédito que se va a transferir
     */
    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }
}
