package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.satValidations.SatValidationRequest;
import com.fiscalapi.models.satValidations.SatValidationResult;
import com.fiscalapi.models.satValidations.SatValidationType;
import com.fiscalapi.models.satValidations.SatValidationTypeStatus;

import java.util.List;

/**
 * Validaciones SAT sobre CFDI: catálogo de tipos y estatus, y ejecución de validaciones
 * (estructura, vigencia del certificado, sellos, estatus en el SAT y listas negras 69-B y
 * 69-B Bis).
 */
public interface ISatValidationService {

    /**
     * Lista los tipos de validación activos, en el orden del catálogo.
     * GET /api/{apiVersion}/sat-validations
     *
     * @return ApiResponse con la lista de tipos de validación
     */
    ApiResponse<List<SatValidationType>> getTypes();

    /**
     * Obtiene un tipo de validación por su id.
     * GET /api/{apiVersion}/sat-validations/{id}
     *
     * @param id Id del tipo, por ejemplo {@code sat.cfdi.status}
     * @return ApiResponse con el tipo de validación
     */
    ApiResponse<SatValidationType> getTypeById(String id);

    /**
     * Lista los estatus que un tipo de validación puede tomar al ejecutarse, aprobatorios primero
     * y luego por id. Es de solo lectura: no ejecuta el validador ni consume créditos.
     * GET /api/{apiVersion}/sat-validations/{id}/statuses
     *
     * @param id Id del tipo, por ejemplo {@code sat.cfdi.status}
     * @return ApiResponse con la lista de estatus posibles del tipo
     */
    ApiResponse<List<SatValidationTypeStatus>> getStatuses(String id);

    /**
     * Ejecuta las validaciones solicitadas sobre un CFDI ({@code xml}) o sobre un RFC
     * ({@code tin}, solo listas negras).
     * POST /api/{apiVersion}/sat-validations
     *
     * <p>Cada tipo solicitado consume un crédito de validación y los resultados vienen en el
     * orden del catálogo, no en el orden solicitado.</p>
     *
     * @param requestModel Solicitud con el CFDI o el RFC y los tipos a ejecutar
     * @return ApiResponse con un resultado por tipo ejecutado
     */
    ApiResponse<List<SatValidationResult>> validate(SatValidationRequest requestModel);
}
