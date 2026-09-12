package com.fiscalapi.models.satValidations;

import com.fiscalapi.common.SerializableDto;

/**
 * Estatus obtenido al ejecutar una validación SAT.
 */
public class SatValidationStatus extends SerializableDto {

    private String id;
    private String description;
    private String details;

    /**
     * Id del estatus obtenido, por ejemplo {@code Valido}, {@code Vigente} o {@code NoListado}
     * (ver {@link SatValidationStatusIds}).
     *
     * @return El id del estatus obtenido
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

    /**
     * Hechos del caso en texto libre: RFC y corte del listado, número de certificado, estado en
     * el SAT. Puede ser null.
     *
     * @return Los hechos del caso, o null cuando el estatus no los aporta
     */
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
