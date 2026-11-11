package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

/**
 * Un asiento de la persona en un feature por persona ({@link PersonFeatures#getSeatAssignments()}).
 */
public class PersonSeatAssignment extends SerializableDto {

    private String featureCode;
    private Integer units;
    private String status;

    /**
     * @return Código del feature (por ejemplo, descarga_cfdi)
     */
    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * @return Unidades que ocupa de la cantidad contratada
     */
    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    /**
     * @return Active si cabe en la cantidad contratada (la persona usa el feature) o Suspended si no cabe
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
