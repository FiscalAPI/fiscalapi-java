package com.fiscalapi.models;

import com.fiscalapi.common.BaseDto;

public class StampTransaction extends BaseDto {
    private int consecutive;

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

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
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

    private UserLookupDto fromPerson;
    private UserLookupDto toPerson;
    private int amount;
    private int transactionType;
    private String referenceId;
    private String comments;
}
