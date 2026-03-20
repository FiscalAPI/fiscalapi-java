package com.fiscalapi.models.invoicing.billOfLading;

public class TransporteAereo {
    private String permSCTId;
    private String numPermisoSCT;
    private String matriculaAeronave;
    private String nombreAseg;
    private String numPolizaSeguro;
    private String numeroGuia;
    private String lugarContrato;
    private String codigoTransportistaId;
    private String rfcEmbarcador;
    private String nombreEmbarcador;
    private String rfcTransportista;

    public String getPermSCTId() {
        return permSCTId;
    }

    public void setPermSCTId(String permSCTId) {
        this.permSCTId = permSCTId;
    }

    public String getNumPermisoSCT() {
        return numPermisoSCT;
    }

    public void setNumPermisoSCT(String numPermisoSCT) {
        this.numPermisoSCT = numPermisoSCT;
    }

    public String getMatriculaAeronave() {
        return matriculaAeronave;
    }

    public void setMatriculaAeronave(String matriculaAeronave) {
        this.matriculaAeronave = matriculaAeronave;
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

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getLugarContrato() {
        return lugarContrato;
    }

    public void setLugarContrato(String lugarContrato) {
        this.lugarContrato = lugarContrato;
    }

    public String getCodigoTransportistaId() {
        return codigoTransportistaId;
    }

    public void setCodigoTransportistaId(String codigoTransportistaId) {
        this.codigoTransportistaId = codigoTransportistaId;
    }

    public String getRfcEmbarcador() {
        return rfcEmbarcador;
    }

    public void setRfcEmbarcador(String rfcEmbarcador) {
        this.rfcEmbarcador = rfcEmbarcador;
    }

    public String getNombreEmbarcador() {
        return nombreEmbarcador;
    }

    public void setNombreEmbarcador(String nombreEmbarcador) {
        this.nombreEmbarcador = nombreEmbarcador;
    }

    public String getRfcTransportista() {
        return rfcTransportista;
    }

    public void setRfcTransportista(String rfcTransportista) {
        this.rfcTransportista = rfcTransportista;
    }
}
