package com.fiscalapi.models.invoicing;

import com.fiscalapi.models.invoicing.payroll.EmployeeData;

// Receptor de la factura
public class InvoiceRecipient {
    private String id;
    private String tin;
    private String legalName;
    private String taxRegimeCode;
    private String cfdiUseCode;

    public EmployeeData getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    private EmployeeData employeeData;
    private String zipCode;
    private String email;

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
    public String getCfdiUseCode() {
        return cfdiUseCode;
    }
    public void setCfdiUseCode(String cfdiUseCode) {
        this.cfdiUseCode = cfdiUseCode;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}