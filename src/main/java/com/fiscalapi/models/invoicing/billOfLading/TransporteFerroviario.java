package com.fiscalapi.models.invoicing.billOfLading;

import java.util.List;

public class TransporteFerroviario {
    private String tipoDeServicioId;
    private String tipoDeTraficoId;
    private String nombreAseg;
    private String numPolizaSeguro;
    private List<DerechoDePaso> derechosDePaso;
    private List<Carro> carros;

    public String getTipoDeServicioId() {
        return tipoDeServicioId;
    }

    public void setTipoDeServicioId(String tipoDeServicioId) {
        this.tipoDeServicioId = tipoDeServicioId;
    }

    public String getTipoDeTraficoId() {
        return tipoDeTraficoId;
    }

    public void setTipoDeTraficoId(String tipoDeTraficoId) {
        this.tipoDeTraficoId = tipoDeTraficoId;
    }

    public String getNombreAseg() {
        return nombreAseg;
    }

    public void setNombreAseg(String nombreAseg) {
        this.nombreAseg = nombreAseg;
    }

    public String getNumPolizaSeguro() {
        return numPolizaSeguro;
    }

    public void setNumPolizaSeguro(String numPolizaSeguro) {
        this.numPolizaSeguro = numPolizaSeguro;
    }

    public List<DerechoDePaso> getDerechosDePaso() {
        return derechosDePaso;
    }

    public void setDerechosDePaso(List<DerechoDePaso> derechosDePaso) {
        this.derechosDePaso = derechosDePaso;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
