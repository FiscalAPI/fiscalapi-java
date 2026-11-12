package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

import java.util.List;

/**
 * La persona de la credencial ({@code getMeService().get()}, GET /api/v4/me): quién es, de qué tenant y ambiente, si es
 * el owner, lo que puede hacer y sus saldos. Siempre es la persona de la API key; no trae secretos.
 */
public class MeInfo extends SerializableDto {

    private String id;
    private String legalName;
    private String tin;
    private String email;
    private String tenantId;
    private String environment;
    private Boolean isOwner;
    private PersonFeatures features;
    private List<CreditBalance> balances;

    /**
     * @return Id de la persona
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Nombre o razón social
     */
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * @return RFC
     */
    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     * @return Correo
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Tenant de la persona (el del header X-TENANT-KEY)
     */
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * @return Ambiente que responde: Development, Test o Production
     */
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * @return true si la persona es el owner del tenant (el mismo valor que {@link PersonFeatures#getIsOwner()})
     */
    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    /**
     * @return Lo que la persona puede hacer: roles, permisos concedidos y negados, features del tenant y suscripción
     */
    public PersonFeatures getFeatures() {
        return features;
    }

    public void setFeatures(PersonFeatures features) {
        this.features = features;
    }

    /**
     * @return Saldos por tipo de crédito, como {@link Person#getBalances()}; un tipo ausente tiene saldo 0
     */
    public List<CreditBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<CreditBalance> balances) {
        this.balances = balances;
    }
}
