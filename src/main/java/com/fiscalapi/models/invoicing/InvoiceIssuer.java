package com.fiscalapi.models.invoicing;

import java.util.List;

import com.fiscalapi.models.invoicing.payroll.EmployerData;

// Emisor de la factura
public class InvoiceIssuer {
    private String id;
    private String tin;
    private String legalName;
    private String taxRegimeCode;
    private EmployerData employerData;
    private List<TaxCredential> taxCredentials;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public List<TaxCredential> getTaxCredentials() {
        return taxCredentials;
    }
    public void setTaxCredentials(List<TaxCredential> taxCredentials) {
        this.taxCredentials = taxCredentials;
    }

    public EmployerData getEmployerData() {
        return employerData;
    }

    public void setEmployerData(EmployerData employerData) {
        this.employerData = employerData;
    }
}