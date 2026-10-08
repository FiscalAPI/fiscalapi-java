package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseImmutableFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.ITaxFileService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.TaxFile;

import java.util.List;


public class TaxFileService extends BaseImmutableFiscalApiService<TaxFile> implements ITaxFileService {

    /**
     * Crea un TaxFileService con el path "tax-files" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public TaxFileService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "tax-files", settings.getApiVersion());
    }

    @Override
    protected Class<TaxFile> getTypeParameterClass() {
        return TaxFile.class;
    }



    @Override
    public ApiResponse<List<TaxFile>> getDefaultReferences(String personId) {
        String path = personId + "/default-references";
        String endpoint = buildEndpoint(path, null);
        return httpClient.getList(endpoint, TaxFile.class);
    }

    @Override
    public ApiResponse<List<TaxFile>> getDefaultValues(String personId) {
        String path = personId + "/default-values";
        String endpoint = buildEndpoint(path, null);
        return httpClient.getList(endpoint, TaxFile.class);
    }
}