package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;

public interface IStampService extends IFiscalApiService<StampTransaction> {

    /**
     * Transfiere timbres o créditos de validación SAT de una persona a otra.
     * POST /api/{apiVersion}/stamps
     *
     * <p>El saldo que se mueve lo elige {@code creditType} del modelo: STAMP mueve timbres y
     * VALIDATION mueve créditos de validación. Los dos saldos nunca se mezclan.</p>
     *
     * @param requestModel Parámetros de la transferencia
     * @return ApiResponse con true cuando la transferencia se aplicó
     */
    ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel);

    /**
     * Retira timbres o créditos de validación SAT de una persona.
     * POST /api/{apiVersion}/stamps
     *
     * <p>La API expone una sola operación de movimiento: retirar es transferir invirtiendo
     * {@code fromPersonId} y {@code toPersonId}. Este método hace exactamente la misma petición
     * que {@link #transferStamps(StampTransactionParams)} y existe para que la intención quede
     * clara en el punto de llamada.</p>
     *
     * @param requestModel Parámetros del retiro, con la persona de la que se retira como origen
     * @return ApiResponse con true cuando el retiro se aplicó
     */
    ApiResponse<Boolean> withdrawStamps(StampTransactionParams requestModel);
}
