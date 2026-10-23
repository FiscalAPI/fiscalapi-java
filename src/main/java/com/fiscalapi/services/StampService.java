package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IStampService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;

import java.util.Collections;
import java.util.Map;

public class StampService extends BaseFiscalApiService<StampTransaction> implements IStampService {

    private static final String IDEMPOTENCY_KEY_HEADER = "Idempotency-Key";

    public StampService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "stamps", settings.getApiVersion());
    }

    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    @Override
    public ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel) {
        return transferStamps(requestModel, null);
    }

    @Override
    public ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel, String idempotencyKey) {
        validateRequest(requestModel);
        Map<String, String> headers = idempotencyKey == null
                ? null
                : Collections.singletonMap(IDEMPOTENCY_KEY_HEADER, idempotencyKey);
        return httpClient.post(buildEndpoint("", null), requestModel, Boolean.class, headers);
    }

    @Override
    public ApiResponse<Boolean> withdrawStamps(StampTransactionParams requestModel) {
        // Retirar es transferir con origen y destino invertidos: delega para que las dos
        // rutas no puedan divergir.
        return transferStamps(requestModel);
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
