package com.fiscalapi.abstractions;

public interface IFiscalApiClient {
    IInvoiceService getInvoiceService();
    IProductService getProductService();
    IPersonService getPersonService();
    IApiKeyService getApiKeyService();
    ITaxFileService getTaxFileService();
    // ... etc
}
