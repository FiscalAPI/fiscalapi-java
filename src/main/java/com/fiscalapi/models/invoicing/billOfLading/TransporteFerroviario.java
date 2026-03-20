package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
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

    public static class DerechoDePaso {
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

    public static class Carro {
        private String tipoCarroId;
        private String matriculaCarro;
        private String guiaCarro;

        @JsonSerialize(using = BigDecimalSerializer.class)
        private BigDecimal toneladasNetasCarro;

        private List<ContenedorFerroviario> contenedores;

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

        public List<ContenedorFerroviario> getContenedores() {
            return contenedores;
        }

        public void setContenedores(List<ContenedorFerroviario> contenedores) {
            this.contenedores = contenedores;
        }
    }

    public static class ContenedorFerroviario {
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
}
