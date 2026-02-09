package com.fiscalapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.common.StripePaymentMethodDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Person extends BaseDto {
    private String legalName;
    private String email;
    private String password;
    private String capitalRegime;
    private String satTaxRegimeId;
    private CatalogDto satTaxRegime;
    private String satCfdiUseId;
    private CatalogDto satCfdiUse;
    private String userTypeId;
    private CatalogDto userType;
    private String tin;
    private String zipCode;
    private String base64Photo;
    private String taxPassword;
    private BigDecimal availableBalance;
    private BigDecimal committedBalance;
    private String tenantId;
//    private String phoneNumber;
//    private LocalDateTime validTo;
//    private Boolean twoFactorEnabled;
//    private String stripeCustomerId;
//    private String stripePaymentMethodId;
//    private String subscriptionStatus;
//    private StripePaymentMethodDto stripePaymentMethod;

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCapitalRegime() {
        return capitalRegime;
    }

    public void setCapitalRegime(String capitalRegime) {
        this.capitalRegime = capitalRegime;
    }

    public String getSatTaxRegimeId() {
        return satTaxRegimeId;
    }

    public void setSatTaxRegimeId(String satTaxRegimeId) {
        this.satTaxRegimeId = satTaxRegimeId;
    }

    public CatalogDto getSatTaxRegime() {
        return satTaxRegime;
    }

    public void setSatTaxRegime(CatalogDto satTaxRegime) {
        this.satTaxRegime = satTaxRegime;
    }

    public String getSatCfdiUseId() {
        return satCfdiUseId;
    }

    public void setSatCfdiUseId(String satCfdiUseId) {
        this.satCfdiUseId = satCfdiUseId;
    }

    public CatalogDto getSatCfdiUse() {
        return satCfdiUse;
    }

    public void setSatCfdiUse(CatalogDto satCfdiUse) {
        this.satCfdiUse = satCfdiUse;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public CatalogDto getUserType() {
        return userType;
    }

    public void setUserType(CatalogDto userType) {
        this.userType = userType;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        this.base64Photo = base64Photo;
    }

    public String getTaxPassword() {
        return taxPassword;
    }

    public void setTaxPassword(String taxPassword) {
        this.taxPassword = taxPassword;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getCommittedBalance() {
        return committedBalance;
    }

    public void setCommittedBalance(BigDecimal committedBalance) {
        this.committedBalance = committedBalance;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}