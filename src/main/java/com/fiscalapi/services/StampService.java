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

    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    @Override
    public ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel) {
        validateRequest(requestModel);
        return httpClient.post(buildEndpoint("", null), requestModel, Boolean.class);
    }

    @Override
    public ApiResponse<Boolean> withdrawStamps(StampTransactionParams requestModel) {
        validateRequest(requestModel);
        return httpClient.post(buildEndpoint("", null), requestModel, Boolean.class);
    }

    @Override
    protected Class<StampTransaction> getTypeParameterClass() {
        return StampTransaction.class;
    }

    private void validateRequest(StampTransactionParams requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("No se acepta modelo de transaccion nulo");
        }

        if (requestModel.getFromPersonId() == null || requestModel.getFromPersonId().trim().isEmpty()) {
            throw new IllegalArgumentException("Se requiere el ID de la persona de origen para la transferencia de timbres");
        }

        if (requestModel.getToPersonId() == null || requestModel.getToPersonId().trim().isEmpty()) {
            throw new IllegalArgumentException("Se requiere el ID de la persona de destino para la transferencia de timbres");
        }

        if (requestModel.getAmount() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }
}
