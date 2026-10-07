package com.fiscalapi.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;


public class Person extends BaseDto {
    private String legalName;
    private String email;
    private String password;
    private String phoneNumber;
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
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal availableBalance;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal committedBalance;
    private Integer availableValidationBalance;
    private String tenantId;
    private String curp;
    private String countryId;
    private String foreignTin;
    private String manifestStatusId;
    private CatalogDto manifestStatus;
    private CatalogDto country;
    private List<CreditBalance> balances;
    private Boolean isOwner;
//    private LocalDateTime validTo;
//    private String stripeCustomerId;
//    private String subscriptionStatus;

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

    /**
     * Contraseña de acceso al dashboard. Requerida al crear; al actualizar, null o vacía conserva la actual.
     * El API nunca la devuelve.
     *
     * @return La contraseña asignada en este objeto
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /**
     * Tipo de persona, solo informativo: "C" (cliente, por omisión al crear) o "U" (usuario). "T" (tenant) solo llega en
     * respuestas: el API lo rechaza al crear y al actualizar solo lo acepta si la persona ya es "T".
     *
     * @return El tipo de persona
     */
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

    /**
     * Contraseña de la llave privada (.key) que la persona guarda en su perfil. El API no la usa para sellar (al timbrar
     * usa la de los certificados registrados o la de taxCredentials). Con valor solo para la propia persona y el owner del
     * tenant; los demás reciben null. Al actualizar, null la conserva (no se envía) y "" la borra.
     *
     * @return La contraseña de la .key del perfil, o null
     */
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

    /**
     * Créditos de validación SAT disponibles. Es de solo lectura en la API y es independiente
     * del saldo de timbres: los saldos nunca se mezclan.
     *
     * @return Los créditos de validación disponibles de la persona
     */
    public Integer getAvailableValidationBalance() {
        return availableValidationBalance;
    }

    public void setAvailableValidationBalance(Integer availableValidationBalance) {
        this.availableValidationBalance = availableValidationBalance;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * CURP de la persona fisica.
     *
     * @return La CURP de la persona
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp CURP de la persona fisica
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Residencia fiscal para personas extranjeras (catalogo c_Pais).
     *
     * @return El codigo del pais de residencia fiscal
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * @param countryId Codigo del pais de residencia fiscal (catalogo c_Pais)
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * Numero de identificacion fiscal de la persona extranjera (NumRegIdTrib).
     *
     * @return El numero de identificacion fiscal extranjero
     */
    public String getForeignTin() {
        return foreignTin;
    }

    /**
     * @param foreignTin Numero de identificacion fiscal de la persona extranjera
     */
    public void setForeignTin(String foreignTin) {
        this.foreignTin = foreignTin;
    }

    /**
     * Estatus de la carta manifiesto de la persona. Lo actualiza la API al firmar el manifiesto.
     *
     * @return El id del estatus de manifiesto
     */
    public String getManifestStatusId() {
        return manifestStatusId;
    }

    /**
     * @param manifestStatusId Id del estatus de la carta manifiesto
     */
    public void setManifestStatusId(String manifestStatusId) {
        this.manifestStatusId = manifestStatusId;
    }

    /**
     * Estatus de la carta manifiesto expandido.
     *
     * @return El estatus de manifiesto con su descripcion
     */
    public CatalogDto getManifestStatus() {
        return manifestStatus;
    }

    /**
     * @param manifestStatus Estatus de la carta manifiesto expandido
     */
    public void setManifestStatus(CatalogDto manifestStatus) {
        this.manifestStatus = manifestStatus;
    }

    /**
     * @return Teléfono de la persona
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber Teléfono de la persona
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * País de residencia fiscal expandido (solo lectura en el API).
     *
     * @return El país con su descripción
     */
    public CatalogDto getCountry() {
        return country;
    }

    /**
     * @param country País de residencia fiscal expandido
     */
    public void setCountry(CatalogDto country) {
        this.country = country;
    }

    /**
     * Saldos por tipo de crédito (solo lectura en el API). Solo aparecen los tipos que la persona ha tenido; un tipo
     * ausente tiene saldo 0.
     *
     * @return Los saldos de la persona
     */
    public List<CreditBalance> getBalances() {
        return balances;
    }

    /**
     * @param balances Saldos por tipo de crédito
     */
    public void setBalances(List<CreditBalance> balances) {
        this.balances = balances;
    }

    /**
     * true si la persona es el owner de su tenant (solo lectura en el API).
     *
     * @return Si la persona es el owner
     */
    public Boolean getIsOwner() {
        return isOwner;
    }

    /**
     * @param isOwner Si la persona es el owner de su tenant
     */
    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }
}