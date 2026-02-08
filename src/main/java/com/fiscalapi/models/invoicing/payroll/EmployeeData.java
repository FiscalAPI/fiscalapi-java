package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiscalapi.OptUtil;
import com.fiscalapi.common.CatalogDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_OUT;

public class EmployeeData {
    private String curp;
    private String employerPersonId;
    private String employeePersonId;
    private String employeeNumber;
    private String socialSecurityNumber;
    private LocalDateTime laborRelationStartDate;
    private CatalogDto satContractType;
    private CatalogDto satTaxRegimeType;
    private CatalogDto satWorkdayType;
    private CatalogDto satJobRisk;
    private CatalogDto satPaymentPeriodicity;
    private CatalogDto satBank;
    private CatalogDto satPayrollState;
    private CatalogDto satUnionizedStatus;
    private String department;
    private String position;
    private String seniority;
    private String satUnionizedStatusId;
    private String satContractTypeId;
    private String satWorkdayTypeId;
    private String satTaxRegimeTypeId;
    private String satJobRiskId;
    private String satPaymentPeriodicityId;
    private String satBankId;
    private String satPayrollStateId;
    private String bankAccount;
    private java.math.BigDecimal baseSalaryForContributions;
    private java.math.BigDecimal integratedDailySalary;
    private String subcontractorRfc;
    private java.math.BigDecimal timePercentage;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmployerPersonId() {
        return employerPersonId;
    }

    public void setEmployerPersonId(String employerPersonId) {
        this.employerPersonId = employerPersonId;
    }

    public String getEmployeePersonId() {
        return employeePersonId;
    }

    public void setEmployeePersonId(String employeePersonId) {
        this.employeePersonId = employeePersonId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @JsonProperty("laborRelationStartDate")
    public String getLaborRelationStartDate() {
        if (laborRelationStartDate == null) {
            return null;
        }
        return laborRelationStartDate.format(SAT_DATE_FORMAT_OUT);
    }

    @JsonProperty("laborRelationStartDate")
    public void setLaborRelationStartDate(String laborRelationStartDate) {
        this.laborRelationStartDate = OptUtil.formatInputDateToSATFormat(laborRelationStartDate);
    }

    public CatalogDto getSatContractType() {
        return satContractType;
    }

    public void setSatContractType(CatalogDto satContractType) {
        this.satContractType = satContractType;
    }

    public CatalogDto getSatTaxRegimeType() {
        return satTaxRegimeType;
    }

    public void setSatTaxRegimeType(CatalogDto satTaxRegimeType) {
        this.satTaxRegimeType = satTaxRegimeType;
    }

    public CatalogDto getSatWorkdayType() {
        return satWorkdayType;
    }

    public void setSatWorkdayType(CatalogDto satWorkdayType) {
        this.satWorkdayType = satWorkdayType;
    }

    public CatalogDto getSatJobRisk() {
        return satJobRisk;
    }

    public void setSatJobRisk(CatalogDto satJobRisk) {
        this.satJobRisk = satJobRisk;
    }

    public CatalogDto getSatPaymentPeriodicity() {
        return satPaymentPeriodicity;
    }

    public void setSatPaymentPeriodicity(CatalogDto satPaymentPeriodicity) {
        this.satPaymentPeriodicity = satPaymentPeriodicity;
    }

    public CatalogDto getSatBank() {
        return satBank;
    }

    public void setSatBank(CatalogDto satBank) {
        this.satBank = satBank;
    }

    public CatalogDto getSatPayrollState() {
        return satPayrollState;
    }

    public void setSatPayrollState(CatalogDto satPayrollState) {
        this.satPayrollState = satPayrollState;
    }

    public CatalogDto getSatUnionizedStatus() {
        return satUnionizedStatus;
    }

    public void setSatUnionizedStatus(CatalogDto satUnionizedStatus) {
        this.satUnionizedStatus = satUnionizedStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getSatUnionizedStatusId() {
        return satUnionizedStatusId;
    }

    public void setSatUnionizedStatusId(String satUnionizedStatusId) {
        this.satUnionizedStatusId = satUnionizedStatusId;
    }

    public String getSatContractTypeId() {
        return satContractTypeId;
    }

    public void setSatContractTypeId(String satContractTypeId) {
        this.satContractTypeId = satContractTypeId;
    }

    public String getSatWorkdayTypeId() {
        return satWorkdayTypeId;
    }

    public void setSatWorkdayTypeId(String satWorkdayTypeId) {
        this.satWorkdayTypeId = satWorkdayTypeId;
    }

    public String getSatTaxRegimeTypeId() {
        return satTaxRegimeTypeId;
    }

    public void setSatTaxRegimeTypeId(String satTaxRegimeTypeId) {
        this.satTaxRegimeTypeId = satTaxRegimeTypeId;
    }

    public String getSatJobRiskId() {
        return satJobRiskId;
    }

    public void setSatJobRiskId(String satJobRiskId) {
        this.satJobRiskId = satJobRiskId;
    }

    public String getSatPaymentPeriodicityId() {
        return satPaymentPeriodicityId;
    }

    public void setSatPaymentPeriodicityId(String satPaymentPeriodicityId) {
        this.satPaymentPeriodicityId = satPaymentPeriodicityId;
    }

    public String getSatBankId() {
        return satBankId;
    }

    public void setSatBankId(String satBankId) {
        this.satBankId = satBankId;
    }

    public String getSatPayrollStateId() {
        return satPayrollStateId;
    }

    public void setSatPayrollStateId(String satPayrollStateId) {
        this.satPayrollStateId = satPayrollStateId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public java.math.BigDecimal getBaseSalaryForContributions() {
        return baseSalaryForContributions;
    }

    public void setBaseSalaryForContributions(String baseSalaryForContributions) {
        this.baseSalaryForContributions = new BigDecimal(baseSalaryForContributions);
    }

    public java.math.BigDecimal getIntegratedDailySalary() {
        return integratedDailySalary;
    }

    public void setIntegratedDailySalary(String integratedDailySalary) {
        this.integratedDailySalary = new BigDecimal(integratedDailySalary);
    }

    public String getSubcontractorRfc() {
        return subcontractorRfc;
    }

    public void setSubcontractorRfc(String subcontractorRfc) {
        this.subcontractorRfc = subcontractorRfc;
    }

    public java.math.BigDecimal getTimePercentage() {
        return timePercentage;
    }

    public void setTimePercentage(java.math.BigDecimal timePercentage) {
        this.timePercentage = timePercentage;
    }
}
