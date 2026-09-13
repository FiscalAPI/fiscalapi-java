package com.fiscalapi.models.invoicing.foreignTrade;

/**
 * Emisor del complemento Comercio Exterior.
 */
public class ComercioExteriorEmisor {
    private String curp;
    private ComercioExteriorEmisorDomicilio domicilio;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public ComercioExteriorEmisorDomicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(ComercioExteriorEmisorDomicilio domicilio) {
        this.domicilio = domicilio;
    }
}
