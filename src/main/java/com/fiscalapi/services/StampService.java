package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IStampService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;

public class StampService extends BaseFiscalApiService<StampTransaction> implements IStampService {
    public StampService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "stamps", settings.getApiVersion());
    }

    @Override
    protected Class<StampTransaction> getTypeParameterClass() {
        return StampTransaction.class;
    }

    @Override
    public ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel) {
        return httpClient.post(buildEndpoint("", null), requestModel, Boolean.class);
    }

    @Override
    public ApiResponse<Boolean> withdrawStamps(StampTransactionParams requestModel) {
        return httpClient.post(buildEndpoint("", null), requestModel, Boolean.class);
    }
}
