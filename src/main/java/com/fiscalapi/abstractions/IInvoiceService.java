package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Invoice;

import java.util.concurrent.CompletableFuture;

public interface IInvoiceService extends IFiscalApiService<Invoice> {
    // Podríamos añadir métodos específicos
    CompletableFuture<ApiResponse<Invoice>> cancelInvoice(String invoiceId);
    // etc.
}
