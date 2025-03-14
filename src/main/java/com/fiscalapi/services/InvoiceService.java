package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IInvoiceService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.Invoice;

public class InvoiceService extends BaseFiscalApiService<Invoice> implements IInvoiceService {

    public InvoiceService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "invoices", settings.getApiVersion());
    }

    @Override
    protected Class<Invoice> getTypeParameterClass() {
        return Invoice.class;
    }

    @Override
    public ApiResponse<Invoice> cancelInvoice(String invoiceId) {
        String endpoint = buildEndpoint(invoiceId + "/cancel", null);
        // Supongamos que el body es vacío:
        return httpClient.post(endpoint, null, Invoice.class);
    }
}