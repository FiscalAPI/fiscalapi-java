package com.fiscalapi.models.invoicing.billOfLading;

import java.util.List;

public class TipoFigura {
    private String tipoFiguraId;
    private String rfcFigura;
    private String numLicencia;
    private String nombreFigura;
    private List<ParteTransporte> partesTransporte;
    private Domicilio domicilio;

    public String getTipoFiguraId() {
        return tipoFiguraId;
    }

    public void setTipoFiguraId(String tipoFiguraId) {
        this.tipoFiguraId = tipoFiguraId;
    }

    public String getRfcFigura() {
        return rfcFigura;
    }

    public void setRfcFigura(String rfcFigura) {
        this.rfcFigura = rfcFigura;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public List<ParteTransporte> getPartesTransporte() {
        return partesTransporte;
    }

    public void setPartesTransporte(List<ParteTransporte> partesTransporte) {
        this.partesTransporte = partesTransporte;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
