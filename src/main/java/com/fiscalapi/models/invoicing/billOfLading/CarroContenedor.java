package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class CarroContenedor {
    private String tipoContenedorId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoContenedorVacio;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoNetoMercancia;

    public String getTipoContenedorId() {
        return tipoContenedorId;
    }

    public void setTipoContenedorId(String tipoContenedorId) {
        this.tipoContenedorId = tipoContenedorId;
    }

    public BigDecimal getPesoContenedorVacio() {
        return pesoContenedorVacio;
    }

    public void setPesoContenedorVacio(BigDecimal pesoContenedorVacio) {
        this.pesoContenedorVacio = pesoContenedorVacio;
    }

    public BigDecimal getPesoNetoMercancia() {
        return pesoNetoMercancia;
    }

    public void setPesoNetoMercancia(BigDecimal pesoNetoMercancia) {
        this.pesoNetoMercancia = pesoNetoMercancia;
    }
}
