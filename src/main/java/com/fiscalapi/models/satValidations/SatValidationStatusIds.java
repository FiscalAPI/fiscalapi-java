package com.fiscalapi.models.satValidations;

/**
 * Ids de los estatus de validación SAT. No todos aplican a todos los tipos: los estatus que puede
 * tomar cada tipo se consultan con GET /api/{apiVersion}/sat-validations/{id}/statuses.
 */
public final class SatValidationStatusIds {

    public static final String VALIDO = "Valido";
    public static final String INVALIDO = "Invalido";
    public static final String VIGENTE = "Vigente";
    public static final String EXPIRADO = "Expirado";
    public static final String NO_VIGENTE_AUN = "NoVigenteAun";
    public static final String CANCELADO = "Cancelado";

    /** Solo existe en {@code sat.cfdi.status}. */
    public static final String NO_ENCONTRADO = "NoEncontrado";

    /** Solo existe en las listas negras. */
    public static final String NO_LISTADO = "NoListado";

    public static final String PRESUNTO = "Presunto";
    public static final String DESVIRTUADO = "Desvirtuado";
    public static final String DEFINITIVO = "Definitivo";
    public static final String SENTENCIA_FAVORABLE = "SentenciaFavorable";

    /**
     * El servicio externo no respondió o no hay corte de lista importado. Consume crédito y
     * conviene reintentar.
     */
    public static final String NO_DISPONIBLE = "NoDisponible";

    /**
     * No se evaluó porque la entrada no lo permite: XML inválido, sin TimbreFiscalDigital o sin
     * certificado legible.
     */
    public static final String OMITIDO = "Omitido";

    private SatValidationStatusIds() {
    }
}
