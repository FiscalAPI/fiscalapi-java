package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class DetalleMercancia {
    private String unidadPesoMercId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoBruto;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoNeto;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoTara;

    private Integer numPiezas = null;

    public String getUnidadPesoMercId() {
        return unidadPesoMercId;
    }

    public void setUnidadPesoMercId(String unidadPesoMercId) {
        this.unidadPesoMercId = unidadPesoMercId;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public BigDecimal getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(BigDecimal pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public BigDecimal getPesoTara() {
        return pesoTara;
    }

    public void setPesoTara(BigDecimal pesoTara) {
        this.pesoTara = pesoTara;
    }

    public Integer getNumPiezas() {
        return numPiezas;
    }

    public void setNumPiezas(Integer numPiezas) {
        this.numPiezas = numPiezas;
    }
}
