package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.FiscalApiSettings;

public abstract class BaseFiscalApiService<T extends BaseDto> extends BaseImmutableFiscalApiService<T> implements IFiscalApiService<T> {

    protected BaseFiscalApiService(
            IFiscalApiHttpClient httpClient,
            FiscalApiSettings settings,
            String resourcePath,
            String apiVersion
    ) {
        super(httpClient, settings, resourcePath, apiVersion);
    }

    @Override
    public ApiResponse<T> update(T model) {
        if (model.getId() == null || model.getId().trim().isEmpty())
            throw new IllegalArgumentException("El id del modelo no puede ser nulo o vacío.");

        String endpoint = buildEndpoint(model.getId(), null);
        return httpClient.put(endpoint, model, getTypeParameterClass());
    }
}