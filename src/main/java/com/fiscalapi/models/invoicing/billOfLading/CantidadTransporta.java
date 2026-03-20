package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class CantidadTransporta {
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal cantidad;

    private String idOrigen;
    private String idDestino;
    private String cvesTransporteId;

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(String idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getCvesTransporteId() {
        return cvesTransporteId;
    }

    public void setCvesTransporteId(String cvesTransporteId) {
        this.cvesTransporteId = cvesTransporteId;
    }
}
