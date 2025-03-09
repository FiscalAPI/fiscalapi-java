package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IApiKeyService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IPersonService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.ApiKey;
import com.fiscalapi.models.Person;



public class ApiKeyService extends BaseFiscalApiService<ApiKey> implements IApiKeyService {

    /**
     * Crea un ApiKeyService con el path "apikeys" y la versión de API dada.
     */
    public ApiKeyService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "apikeys", settings.getApiVersion());
    }

    @Override
    protected Class<ApiKey> getTypeParameterClass() {
        return ApiKey.class;
    }

}