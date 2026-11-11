package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.MeInfo;

/**
 * La persona de la credencial con que se llama a la API.
 */
public interface IMeService {

    /**
     * Obtiene la persona de la API key: su id, nombre, RFC y correo, su tenant, el ambiente que responde, si es el
     * owner, lo que puede hacer y sus saldos. Sirve para validar una credencial: con una API key o un tenant que no son
     * válidos responde 401. GET /api/{apiVersion}/me
     *
     * @return ApiResponse con la persona de la credencial
     */
    ApiResponse<MeInfo> get();
}
