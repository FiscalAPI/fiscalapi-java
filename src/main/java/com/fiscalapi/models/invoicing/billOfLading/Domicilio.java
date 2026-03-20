package com.fiscalapi.models.invoicing.billOfLading;

public class Domicilio {
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String coloniaId;
    private String localidadId;
    private String referencia;
    private String municipioId;
    private String estadoId;
    private String paisId;
    private String codigoPostalId;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColoniaId() {
        return coloniaId;
    }

    public void setColoniaId(String coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(String localidadId) {
        this.localidadId = localidadId;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(String municipioId) {
        this.municipioId = municipioId;
    }

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public String getCodigoPostalId() {
        return codigoPostalId;
    }

    public void setCodigoPostalId(String codigoPostalId) {
        this.codigoPostalId = codigoPostalId;
    }
}
