package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class DerechoDePaso {
    private String tipoDerechoDePasoId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal kilometrajePagado;

    public String getTipoDerechoDePasoId() {
        return tipoDerechoDePasoId;
    }

    public void setTipoDerechoDePasoId(String tipoDerechoDePasoId) {
        this.tipoDerechoDePasoId = tipoDerechoDePasoId;
    }

    public BigDecimal getKilometrajePagado() {
        return kilometrajePagado;
    }

    public void setKilometrajePagado(BigDecimal kilometrajePagado) {
        this.kilometrajePagado = kilometrajePagado;
    }
}
