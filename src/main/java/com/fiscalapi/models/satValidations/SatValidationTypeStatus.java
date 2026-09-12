package com.fiscalapi.models.satValidations;

import com.fiscalapi.common.SerializableDto;

/**
 * Estatus que un tipo de validación puede tomar al ejecutarse. Es el elemento de
 * GET /api/{apiVersion}/sat-validations/{id}/statuses, una consulta de solo lectura que no ejecuta
 * el validador ni consume créditos.
 */
public class SatValidationTypeStatus extends SerializableDto {

    private String id;
    private String description;

    /**
     * Id del estatus, por ejemplo {@code Valido}, {@code Vigente} o {@code NoListado}
     * (ver {@link SatValidationStatusIds}).
     *
     * @return El id del estatus
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Descripción del estatus según el catálogo.
     *
     * @return La descripción del estatus
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
