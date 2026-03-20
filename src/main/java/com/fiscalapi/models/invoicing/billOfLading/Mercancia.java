package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Mercancia {
    private String bienesTranspId;
    private String descripcion;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal cantidad;

    private String claveUnidadId;
    private String materialPeligrosoId;
    private String denominacionGenericaProd;
    private String denominacionDistintivaProd;
    private String fabricante;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime fechaCaducidad;

    private String loteMedicamento;
    private String formaFarmaceuticaId;
    private String condicionesEspTranspId;
    private String registroSanitarioFolioAutorizacion;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoEnKg;

    private String fraccionArancelariaId;
    private String tipoMateriaId;
    private String descripcionMateria;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal valorMercancia = null;

    private String monedaId;
    private List<DocumentoAduanero> documentacionAduanera;
    private List<CantidadTransporta> cantidadTransporta;
    private DetalleMercancia detalleMercancia;

    public String getBienesTranspId() {
        return bienesTranspId;
    }

    public void setBienesTranspId(String bienesTranspId) {
        this.bienesTranspId = bienesTranspId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getClaveUnidadId() {
        return claveUnidadId;
    }

    public void setClaveUnidadId(String claveUnidadId) {
        this.claveUnidadId = claveUnidadId;
    }

    public String getMaterialPeligrosoId() {
        return materialPeligrosoId;
    }

    public void setMaterialPeligrosoId(String materialPeligrosoId) {
        this.materialPeligrosoId = materialPeligrosoId;
    }

    public String getDenominacionGenericaProd() {
        return denominacionGenericaProd;
    }

    public void setDenominacionGenericaProd(String denominacionGenericaProd) {
        this.denominacionGenericaProd = denominacionGenericaProd;
    }

    public String getDenominacionDistintivaProd() {
        return denominacionDistintivaProd;
    }

    public void setDenominacionDistintivaProd(String denominacionDistintivaProd) {
        this.denominacionDistintivaProd = denominacionDistintivaProd;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDateTime getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getLoteMedicamento() {
        return loteMedicamento;
    }

    public void setLoteMedicamento(String loteMedicamento) {
        this.loteMedicamento = loteMedicamento;
    }

    public String getFormaFarmaceuticaId() {
        return formaFarmaceuticaId;
    }

    public void setFormaFarmaceuticaId(String formaFarmaceuticaId) {
        this.formaFarmaceuticaId = formaFarmaceuticaId;
    }

    public String getCondicionesEspTranspId() {
        return condicionesEspTranspId;
    }

    public void setCondicionesEspTranspId(String condicionesEspTranspId) {
        this.condicionesEspTranspId = condicionesEspTranspId;
    }

    public String getRegistroSanitarioFolioAutorizacion() {
        return registroSanitarioFolioAutorizacion;
    }

    public void setRegistroSanitarioFolioAutorizacion(String registroSanitarioFolioAutorizacion) {
        this.registroSanitarioFolioAutorizacion = registroSanitarioFolioAutorizacion;
    }

    public BigDecimal getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(BigDecimal pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    public String getFraccionArancelariaId() {
        return fraccionArancelariaId;
    }

    public void setFraccionArancelariaId(String fraccionArancelariaId) {
        this.fraccionArancelariaId = fraccionArancelariaId;
    }

    public String getTipoMateriaId() {
        return tipoMateriaId;
    }

    public void setTipoMateriaId(String tipoMateriaId) {
        this.tipoMateriaId = tipoMateriaId;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public BigDecimal getValorMercancia() {
        return valorMercancia;
    }

    public void setValorMercancia(BigDecimal valorMercancia) {
        this.valorMercancia = valorMercancia;
    }

    public String getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(String monedaId) {
        this.monedaId = monedaId;
    }

    public List<DocumentoAduanero> getDocumentacionAduanera() {
        return documentacionAduanera;
    }

    public void setDocumentacionAduanera(List<DocumentoAduanero> documentacionAduanera) {
        this.documentacionAduanera = documentacionAduanera;
    }

    public List<CantidadTransporta> getCantidadTransporta() {
        return cantidadTransporta;
    }

    public void setCantidadTransporta(List<CantidadTransporta> cantidadTransporta) {
        this.cantidadTransporta = cantidadTransporta;
    }

    public DetalleMercancia getDetalleMercancia() {
        return detalleMercancia;
    }

    public void setDetalleMercancia(DetalleMercancia detalleMercancia) {
        this.detalleMercancia = detalleMercancia;
    }
}
