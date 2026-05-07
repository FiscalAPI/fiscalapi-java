package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

public class Carro {
    private String tipoCarroId;
    private String matriculaCarro;
    private String guiaCarro;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal toneladasNetasCarro;

    private List<CarroContenedor> contenedores;

    public String getTipoCarroId() {
        return tipoCarroId;
    }

    public void setTipoCarroId(String tipoCarroId) {
        this.tipoCarroId = tipoCarroId;
    }

    public String getMatriculaCarro() {
        return matriculaCarro;
    }

    public void setMatriculaCarro(String matriculaCarro) {
        this.matriculaCarro = matriculaCarro;
    }

    public String getGuiaCarro() {
        return guiaCarro;
    }

    public void setGuiaCarro(String guiaCarro) {
        this.guiaCarro = guiaCarro;
    }

    public BigDecimal getToneladasNetasCarro() {
        return toneladasNetasCarro;
    }

    public void setToneladasNetasCarro(BigDecimal toneladasNetasCarro) {
        this.toneladasNetasCarro = toneladasNetasCarro;
    }

    public List<CarroContenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<CarroContenedor> contenedores) {
        this.contenedores = contenedores;
    }
}
