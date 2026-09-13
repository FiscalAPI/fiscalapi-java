package com.fiscalapi.models.invoicing.foreignTrade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Complemento Comercio Exterior para la exportacion de mercancias en CFDI 4.0.
 *
 * El TotalUSD del comprobante no se envia: la API lo calcula sumando el valorDolares de las
 * mercancias.
 */
public class ComercioExterior {
    private String motivoTrasladoId;
    private String claveDePedimentoId;
    private int certificadoOrigen;
    private String numCertificadoOrigen;
    private String numeroExportadorConfiable;
    private String incotermId;
    private String observaciones;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal tipoCambioUSD;

    private ComercioExteriorEmisor emisor;
    private ComercioExteriorReceptor receptor;
    private List<ComercioExteriorPropietario> propietarios;
    private List<ComercioExteriorDestinatario> destinatarios;
    private List<ComercioExteriorMercancia> mercancias;

    public String getMotivoTrasladoId() {
        return motivoTrasladoId;
    }

    public void setMotivoTrasladoId(String motivoTrasladoId) {
        this.motivoTrasladoId = motivoTrasladoId;
    }

    public String getClaveDePedimentoId() {
        return claveDePedimentoId;
    }

    public void setClaveDePedimentoId(String claveDePedimentoId) {
        this.claveDePedimentoId = claveDePedimentoId;
    }

    public int getCertificadoOrigen() {
        return certificadoOrigen;
    }

    public void setCertificadoOrigen(int certificadoOrigen) {
        this.certificadoOrigen = certificadoOrigen;
    }

    public String getNumCertificadoOrigen() {
        return numCertificadoOrigen;
    }

    public void setNumCertificadoOrigen(String numCertificadoOrigen) {
        this.numCertificadoOrigen = numCertificadoOrigen;
    }

    public String getNumeroExportadorConfiable() {
        return numeroExportadorConfiable;
    }

    public void setNumeroExportadorConfiable(String numeroExportadorConfiable) {
        this.numeroExportadorConfiable = numeroExportadorConfiable;
    }

    public String getIncotermId() {
        return incotermId;
    }

    public void setIncotermId(String incotermId) {
        this.incotermId = incotermId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTipoCambioUSD() {
        return tipoCambioUSD;
    }

    public void setTipoCambioUSD(BigDecimal tipoCambioUSD) {
        this.tipoCambioUSD = tipoCambioUSD;
    }

    public ComercioExteriorEmisor getEmisor() {
        return emisor;
    }

    public void setEmisor(ComercioExteriorEmisor emisor) {
        this.emisor = emisor;
    }

    public ComercioExteriorReceptor getReceptor() {
        return receptor;
    }

    public void setReceptor(ComercioExteriorReceptor receptor) {
        this.receptor = receptor;
    }

    public List<ComercioExteriorPropietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<ComercioExteriorPropietario> propietarios) {
        this.propietarios = propietarios;
    }

    public List<ComercioExteriorDestinatario> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<ComercioExteriorDestinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<ComercioExteriorMercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<ComercioExteriorMercancia> mercancias) {
        this.mercancias = mercancias;
    }
}
