package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class GuiaIdentificacion {
    private String numeroGuiaIdentificacion;
    private String descripGuiaIdentificacion;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoGuiaIdentificacion;

    public String getNumeroGuiaIdentificacion() {
        return numeroGuiaIdentificacion;
    }

    public void setNumeroGuiaIdentificacion(String numeroGuiaIdentificacion) {
        this.numeroGuiaIdentificacion = numeroGuiaIdentificacion;
    }

    public String getDescripGuiaIdentificacion() {
        return descripGuiaIdentificacion;
    }

    public void setDescripGuiaIdentificacion(String descripGuiaIdentificacion) {
        this.descripGuiaIdentificacion = descripGuiaIdentificacion;
    }

    public BigDecimal getPesoGuiaIdentificacion() {
        return pesoGuiaIdentificacion;
    }

    public void setPesoGuiaIdentificacion(BigDecimal pesoGuiaIdentificacion) {
        this.pesoGuiaIdentificacion = pesoGuiaIdentificacion;
    }
}
