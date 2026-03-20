package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ubicacion {
    private String tipoUbicacion;
    private String idUbicacion;
    private String rfcRemitenteDestinatario;
    private String numRegIdTrib;
    private String residenciaFiscalId;
    private String nombreRemitenteDestinatario;
    private String numEstacionId;
    private String nombreEstacion;
    private String navegacionTraficoId;
    private String tipoEstacionId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime fechaHoraSalidaLlegada;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal distanciaRecorrida = null;

    private Domicilio domicilio;

    public String getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getRfcRemitenteDestinatario() {
        return rfcRemitenteDestinatario;
    }

    public void setRfcRemitenteDestinatario(String rfcRemitenteDestinatario) {
        this.rfcRemitenteDestinatario = rfcRemitenteDestinatario;
    }

    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public String getResidenciaFiscalId() {
        return residenciaFiscalId;
    }

    public void setResidenciaFiscalId(String residenciaFiscalId) {
        this.residenciaFiscalId = residenciaFiscalId;
    }

    public String getNombreRemitenteDestinatario() {
        return nombreRemitenteDestinatario;
    }

    public void setNombreRemitenteDestinatario(String nombreRemitenteDestinatario) {
        this.nombreRemitenteDestinatario = nombreRemitenteDestinatario;
    }

    public String getNumEstacionId() {
        return numEstacionId;
    }

    public void setNumEstacionId(String numEstacionId) {
        this.numEstacionId = numEstacionId;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public String getNavegacionTraficoId() {
        return navegacionTraficoId;
    }

    public void setNavegacionTraficoId(String navegacionTraficoId) {
        this.navegacionTraficoId = navegacionTraficoId;
    }

    public String getTipoEstacionId() {
        return tipoEstacionId;
    }

    public void setTipoEstacionId(String tipoEstacionId) {
        this.tipoEstacionId = tipoEstacionId;
    }

    public LocalDateTime getFechaHoraSalidaLlegada() {
        return fechaHoraSalidaLlegada;
    }

    public void setFechaHoraSalidaLlegada(LocalDateTime fechaHoraSalidaLlegada) {
        this.fechaHoraSalidaLlegada = fechaHoraSalidaLlegada;
    }

    public BigDecimal getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(BigDecimal distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
