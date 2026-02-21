package com.fiscalapi.models.invoicing;

public class OnBehalfOf {
    private String tin;
    private String legalName;
    private String taxRegimeCode;
    private String zipCode;

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getTaxRegimeCode() {
        return taxRegimeCode;
    }

    public void setTaxRegimeCode(String taxRegimeCode) {
        this.taxRegimeCode = taxRegimeCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
