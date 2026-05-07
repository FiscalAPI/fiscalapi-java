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
    private String claveSTCCId;
    private String descripcion;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal cantidad;

    private String claveUnidadId;
    private String unidad;
    private String dimensiones;
    private String materialPeligrosoId;
    private String cveMaterialPeligrosoId;
    private String embalajeId;
    private String descripEmbalaje;
    private String sectorCOFEPRISId;
    private String nombreIngredienteActivo;
    private String nomQuimico;
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
    private String permisoImportacion;
    private String folioImpoVUCEM;
    private String numCAS;
    private String razonSocialEmpImp;
    private String numRegSanPlagCOFEPRIS;
    private String datosFabricante;
    private String datosFormulador;
    private String datosMaquilador;
    private String usoAutorizado;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoEnKg;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal valorMercancia = null;

    private String monedaId;
    private String fraccionArancelariaId;
    private String uuidComercioExt;
    private String tipoMateriaId;
    private String descripcionMateria;
    private List<DocumentoAduanero> documentacionAduanera;
    private List<GuiaIdentificacion> guiasIdentificacion;
    private List<CantidadTransporta> cantidadTransporta;
    private DetalleMercancia detalleMercancia;

    public String getBienesTranspId() {
        return bienesTranspId;
    }

    public void setBienesTranspId(String bienesTranspId) {
        this.bienesTranspId = bienesTranspId;
    }

    public String getClaveSTCCId() {
        return claveSTCCId;
    }

    public void setClaveSTCCId(String claveSTCCId) {
        this.claveSTCCId = claveSTCCId;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getMaterialPeligrosoId() {
        return materialPeligrosoId;
    }

    public void setMaterialPeligrosoId(String materialPeligrosoId) {
        this.materialPeligrosoId = materialPeligrosoId;
    }

    public String getCveMaterialPeligrosoId() {
        return cveMaterialPeligrosoId;
    }

    public void setCveMaterialPeligrosoId(String cveMaterialPeligrosoId) {
        this.cveMaterialPeligrosoId = cveMaterialPeligrosoId;
    }

    public String getEmbalajeId() {
        return embalajeId;
    }

    public void setEmbalajeId(String embalajeId) {
        this.embalajeId = embalajeId;
    }

    public String getDescripEmbalaje() {
        return descripEmbalaje;
    }

    public void setDescripEmbalaje(String descripEmbalaje) {
        this.descripEmbalaje = descripEmbalaje;
    }

    public String getSectorCOFEPRISId() {
        return sectorCOFEPRISId;
    }

    public void setSectorCOFEPRISId(String sectorCOFEPRISId) {
        this.sectorCOFEPRISId = sectorCOFEPRISId;
    }

    public String getNombreIngredienteActivo() {
        return nombreIngredienteActivo;
    }

    public void setNombreIngredienteActivo(String nombreIngredienteActivo) {
        this.nombreIngredienteActivo = nombreIngredienteActivo;
    }

    public String getNomQuimico() {
        return nomQuimico;
    }

    public void setNomQuimico(String nomQuimico) {
        this.nomQuimico = nomQuimico;
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

    public String getPermisoImportacion() {
        return permisoImportacion;
    }

    public void setPermisoImportacion(String permisoImportacion) {
        this.permisoImportacion = permisoImportacion;
    }

    public String getFolioImpoVUCEM() {
        return folioImpoVUCEM;
    }

    public void setFolioImpoVUCEM(String folioImpoVUCEM) {
        this.folioImpoVUCEM = folioImpoVUCEM;
    }

    public String getNumCAS() {
        return numCAS;
    }

    public void setNumCAS(String numCAS) {
        this.numCAS = numCAS;
    }

    public String getRazonSocialEmpImp() {
        return razonSocialEmpImp;
    }

    public void setRazonSocialEmpImp(String razonSocialEmpImp) {
        this.razonSocialEmpImp = razonSocialEmpImp;
    }

    public String getNumRegSanPlagCOFEPRIS() {
        return numRegSanPlagCOFEPRIS;
    }

    public void setNumRegSanPlagCOFEPRIS(String numRegSanPlagCOFEPRIS) {
        this.numRegSanPlagCOFEPRIS = numRegSanPlagCOFEPRIS;
    }

    public String getDatosFabricante() {
        return datosFabricante;
    }

    public void setDatosFabricante(String datosFabricante) {
        this.datosFabricante = datosFabricante;
    }

    public String getDatosFormulador() {
        return datosFormulador;
    }

    public void setDatosFormulador(String datosFormulador) {
        this.datosFormulador = datosFormulador;
    }

    public String getDatosMaquilador() {
        return datosMaquilador;
    }

    public void setDatosMaquilador(String datosMaquilador) {
        this.datosMaquilador = datosMaquilador;
    }

    public String getUsoAutorizado() {
        return usoAutorizado;
    }

    public void setUsoAutorizado(String usoAutorizado) {
        this.usoAutorizado = usoAutorizado;
    }

    public BigDecimal getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(BigDecimal pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
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

    public String getFraccionArancelariaId() {
        return fraccionArancelariaId;
    }

    public void setFraccionArancelariaId(String fraccionArancelariaId) {
        this.fraccionArancelariaId = fraccionArancelariaId;
    }

    public String getUuidComercioExt() {
        return uuidComercioExt;
    }

    public void setUuidComercioExt(String uuidComercioExt) {
        this.uuidComercioExt = uuidComercioExt;
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

    public List<DocumentoAduanero> getDocumentacionAduanera() {
        return documentacionAduanera;
    }

    public void setDocumentacionAduanera(List<DocumentoAduanero> documentacionAduanera) {
        this.documentacionAduanera = documentacionAduanera;
    }

    public List<GuiaIdentificacion> getGuiasIdentificacion() {
        return guiasIdentificacion;
    }

    public void setGuiasIdentificacion(List<GuiaIdentificacion> guiasIdentificacion) {
        this.guiasIdentificacion = guiasIdentificacion;
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
