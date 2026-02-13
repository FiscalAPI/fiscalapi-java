package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeData {
    private String curp;
    private String employerPersonId;
    private String employeePersonId;
    private String employeeNumber;
    private String socialSecurityNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal baseSalaryForContributions;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal integratedDailySalary;
    private String subcontractorRfc;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal timePercentage;

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

    public LocalDateTime getLaborRelationStartDate() {
        return laborRelationStartDate;
    }

    public void setLaborRelationStartDate(LocalDateTime laborRelationStartDate) {
        this.laborRelationStartDate = laborRelationStartDate;
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

    public BigDecimal getBaseSalaryForContributions() {
        return baseSalaryForContributions;
    }

    public void setBaseSalaryForContributions(BigDecimal baseSalaryForContributions) {
        this.baseSalaryForContributions = baseSalaryForContributions;
    }

    public BigDecimal getIntegratedDailySalary() {
        return integratedDailySalary;
    }

    public void setIntegratedDailySalary(BigDecimal integratedDailySalary) {
        this.integratedDailySalary = integratedDailySalary;
    }

    public String getSubcontractorRfc() {
        return subcontractorRfc;
    }

    public void setSubcontractorRfc(String subcontractorRfc) {
        this.subcontractorRfc = subcontractorRfc;
    }

    public BigDecimal getTimePercentage() {
        return timePercentage;
    }

    public void setTimePercentage(BigDecimal timePercentage) {
        this.timePercentage = timePercentage;
    }
}
