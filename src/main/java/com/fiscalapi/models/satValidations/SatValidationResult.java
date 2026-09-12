package com.fiscalapi.models.satValidations;

import com.fiscalapi.common.SerializableDto;

/**
 * Un tipo de validación ejecutado con el estatus obtenido y su veredicto. Es el elemento de
 * POST /api/{apiVersion}/sat-validations, que los devuelve en el orden del catálogo y no en el
 * orden solicitado.
 */
public class SatValidationResult extends SerializableDto {

    private SatValidationType type;
    private SatValidationStatus status;
    private boolean passed;

    /**
     * Tipo de validación evaluado.
     *
     * @return El tipo de validación evaluado
     */
    public SatValidationType getType() {
        return type;
    }

    public void setType(SatValidationType type) {
        this.type = type;
    }

    /**
     * Estatus obtenido al ejecutar la validación.
     *
     * @return El estatus obtenido
     */
    public SatValidationStatus getStatus() {
        return status;
    }

    public void setStatus(SatValidationStatus status) {
        this.status = status;
    }

    /**
     * Veredicto del estatus para ese tipo. Un resultado adverso sigue siendo una respuesta
     * exitosa de la API y consume crédito igual.
     *
     * @return true cuando el estatus obtenido se considera aprobado para ese tipo
     */
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
