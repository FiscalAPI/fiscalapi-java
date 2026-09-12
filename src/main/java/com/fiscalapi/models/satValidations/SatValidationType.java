package com.fiscalapi.models.satValidations;

import com.fiscalapi.common.SerializableDto;

/**
 * Tipo de validación SAT del catálogo.
 */
public class SatValidationType extends SerializableDto {

    private String id;
    private String description;

    /**
     * Id del tipo, por ejemplo {@code sat.cfdi.status} (ver {@link SatValidationTypeIds}).
     *
     * @return El id del tipo de validación
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Descripción de lo que verifica el tipo.
     *
     * @return La descripción del tipo de validación
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
