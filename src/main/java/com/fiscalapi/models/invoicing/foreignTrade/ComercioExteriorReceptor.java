package com.fiscalapi.models.invoicing.foreignTrade;

/**
 * Receptor del complemento Comercio Exterior.
 */
public class ComercioExteriorReceptor {
    private String numRegIdTrib;
    private ComercioExteriorReceptorDomicilio domicilio;

    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public ComercioExteriorReceptorDomicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(ComercioExteriorReceptorDomicilio domicilio) {
        this.domicilio = domicilio;
    }
}
