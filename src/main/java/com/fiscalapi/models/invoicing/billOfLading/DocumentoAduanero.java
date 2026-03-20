package com.fiscalapi.models.invoicing.billOfLading;

public class DocumentoAduanero {
    private String tipoDocumentoId;
    private String numPedimento;
    private String rfcImpo;

    public String getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(String tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNumPedimento() {
        return numPedimento;
    }

    public void setNumPedimento(String numPedimento) {
        this.numPedimento = numPedimento;
    }

    public String getRfcImpo() {
        return rfcImpo;
    }

    public void setRfcImpo(String rfcImpo) {
        this.rfcImpo = rfcImpo;
    }
}
