package com.fiscalapi.models;

public class StampTransactionParams
{
    private String fromPersonId;
    private String toPersonId;
    private int amount;
    private String comments;

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
}
