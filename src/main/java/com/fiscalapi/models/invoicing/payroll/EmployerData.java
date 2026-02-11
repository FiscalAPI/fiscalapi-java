package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.serialization.MoneySerializer;
import java.math.BigDecimal;

public class EmployerData {
    private String personId;
    private String employerRegistration;
    private CatalogDto satFundSource;
    private String satFundSourceId;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal ownResourceAmount;
    private String originEmployerTin;

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setEmployerRegistration(String employerRegistration) {
        this.employerRegistration = employerRegistration;
    }

    public void setSatFundSourceId(String satFundSourceId) {
        this.satFundSourceId = satFundSourceId;
    }

    public void setOwnResourceAmount(BigDecimal ownResourceAmount) {
        this.ownResourceAmount = ownResourceAmount;
    }

    public String getPersonId() {
        return personId;
    }

    public String getEmployerRegistration() {
        return employerRegistration;
    }

    public CatalogDto getSatFundSource() {
        return satFundSource;
    }

    public String getSatFundSourceId() {
        return satFundSourceId;
    }

    public BigDecimal getOwnResourceAmount() {
        return ownResourceAmount;
    }

    public void setSatFundSource(CatalogDto satFundSource) {
        this.satFundSource = satFundSource;
    }

    public String getOriginEmployerTin() {
        return originEmployerTin;
    }

    public void setOriginEmployerTin(String originEmployerTin) {
        this.originEmployerTin = originEmployerTin;
    }
}
