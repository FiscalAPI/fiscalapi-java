package com.fiscalapi.abstractions;

import com.fiscalapi.models.ApiKey;

/**
 * Define el contrato específico para operaciones con "apikey".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService<ApiKey>.
 */
public interface IApiKeyService extends IFiscalApiService<ApiKey> {


    // other specific methods here...
}