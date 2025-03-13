package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.ITaxFileService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.TaxFile;

import java.util.List;


public class TaxFileService extends BaseFiscalApiService<TaxFile> implements ITaxFileService {

    /**
     * Crea un TaxFileService con el path "tax-files" y la versión de API dada.
     */
    public TaxFileService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "tax-files", settings.getApiVersion());
    }

    @Override
    protected Class<TaxFile> getTypeParameterClass() {
        return TaxFile.class;
    }


    @SuppressWarnings("unchecked")
    protected Class<List<TaxFile>> getListTypeParameterClass() {
        // Debido a type erasure, se utiliza un cast para retornar la clase base de List
        return (Class<List<TaxFile>>) (Class) List.class;
    }

    @Override
    public ApiResponse<List<TaxFile>> getDefaultReferences(String personId) {
        String path = personId + "/default-references";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getListTypeParameterClass());
    }

    @Override
    public ApiResponse<List<TaxFile>> getDefaultValues(String personId) {
        String path = personId + "/default-values";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getListTypeParameterClass());
    }
}