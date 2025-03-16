package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.Invoice;

public interface IInvoiceService extends IFiscalApiService<Invoice> {
    // Podríamos añadir métodos específicos
    ApiResponse<Invoice> cancelInvoice(String invoiceId);
    // etc.
}