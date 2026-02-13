package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;

public interface IStampService extends IFiscalApiService<StampTransaction> {
    ApiResponse<Boolean> transferStamps(StampTransactionParams requestModel);
    ApiResponse<Boolean> withdrawStamps(StampTransactionParams requestModel);
}
