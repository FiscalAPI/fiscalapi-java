package com.fiscalapi.models.invoicing.foreignTrade;

/**
 * Propietario de las mercancias exportadas.
 */
public class ComercioExteriorPropietario {
    private String numRegIdTrib;
    private String residenciaFiscalId;

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
}
