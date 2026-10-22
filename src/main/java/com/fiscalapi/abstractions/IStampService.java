package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;

public interface IStampService extends IFiscalApiService<StampTransaction> {

    /**
     * Transfiere timbres, créditos de validación SAT o créditos de ticket de una persona a otra.
     * POST /api/{apiVersion}/stamps
     *
     * <p>El saldo que se mueve lo elige {@code creditType} del modelo: STAMP mueve timbres,
     * VALIDATION mueve créditos de validación y TICKET mueve créditos de ticket. Los saldos nunca se mezclan.</p>
     *
     * @param requestModel Parámetros de la transferencia
     * @return ApiResponse con true cuando la transferencia se aplicó
     */
    ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel);

    /**
     * Transfiere timbres, créditos de validación SAT o créditos de ticket de una persona a otra, con la llave de
     * idempotencia de la petición. POST /api/{apiVersion}/stamps
     *
     * <p>Con idempotencyKey (hasta 64 caracteres ASCII visibles, sin espacios) se envía el header Idempotency-Key:
     * repetir la misma petición con la misma llave de idempotencia dentro de 24 horas devuelve la respuesta original; otra petición con
     * la misma llave de idempotencia responde 422, y una petición original todavía en proceso responde 409. Con null, el header no se
     * envía.</p>
     *
     * @param requestModel   Parámetros de la transferencia
     * @param idempotencyKey Valor del header Idempotency-Key, o null para no enviarlo
     * @return ApiResponse con true cuando la transferencia se aplicó
     */
    ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel, String idempotencyKey);

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
