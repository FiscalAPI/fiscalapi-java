package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

public class Autotransporte {
    private String permSCTId;
    private String numPermisoSCT;
    private String configVehicularId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoBrutoVehicular;

    private String placaVM;
    private int anioModeloVM;
    private String aseguraRespCivil;
    private String polizaRespCivil;
    private List<Remolque> remolques;

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

    public String getConfigVehicularId() {
        return configVehicularId;
    }

    public void setConfigVehicularId(String configVehicularId) {
        this.configVehicularId = configVehicularId;
    }

    public BigDecimal getPesoBrutoVehicular() {
        return pesoBrutoVehicular;
    }

    public void setPesoBrutoVehicular(BigDecimal pesoBrutoVehicular) {
        this.pesoBrutoVehicular = pesoBrutoVehicular;
    }

    public String getPlacaVM() {
        return placaVM;
    }

    public void setPlacaVM(String placaVM) {
        this.placaVM = placaVM;
    }

    public int getAnioModeloVM() {
        return anioModeloVM;
    }

    public void setAnioModeloVM(int anioModeloVM) {
        this.anioModeloVM = anioModeloVM;
    }

    public String getAseguraRespCivil() {
        return aseguraRespCivil;
    }

    public void setAseguraRespCivil(String aseguraRespCivil) {
        this.aseguraRespCivil = aseguraRespCivil;
    }

    public String getPolizaRespCivil() {
        return polizaRespCivil;
    }

    public void setPolizaRespCivil(String polizaRespCivil) {
        this.polizaRespCivil = polizaRespCivil;
    }

    public List<Remolque> getRemolques() {
        return remolques;
    }

    public void setRemolques(List<Remolque> remolques) {
        this.remolques = remolques;
    }
}
