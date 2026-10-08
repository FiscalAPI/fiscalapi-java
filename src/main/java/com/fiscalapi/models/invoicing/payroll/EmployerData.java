package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.serialization.BigDecimalSerializer;
import java.math.BigDecimal;

public class EmployerData {
    private String personId;
    /**
     * CURP del empleador persona fisica (Nomina/Emisor/@Curp). Solo aplica en los datos del empleador del emisor de una
     * factura de nomina por valores (issuer.employerData); en las facturas por referencias el API toma la CURP de la
     * persona emisora, y los datos de empleador de una persona (getPersonService().getEmployerService()) no la guardan.
     */
    private String curp;
    private String employerRegistration;
    private CatalogDto satFundSource;
    private String satFundSourceId;
    @JsonSerialize(using = BigDecimalSerializer.class)
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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
