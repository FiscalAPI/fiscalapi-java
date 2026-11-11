package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

import java.util.Map;

/**
 * Un feature habilitado del tenant ({@link PersonFeatures#getFeatures()}).
 */
public class PersonFeature extends SerializableDto {

    private Map<String, Integer> values;

    /**
     * @return Valores del feature por código (por ejemplo, seats); vacío si no tiene
     */
    public Map<String, Integer> getValues() {
        return values;
    }

    public void setValues(Map<String, Integer> values) {
        this.values = values;
    }
}
