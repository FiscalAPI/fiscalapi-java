package com.fiscalapi.abstractions;

public interface IFiscalApiClient {
    IInvoiceService getInvoiceService();
    IProductService getProductService();
    IPersonService getPersonService();
    IApiKeyService getApiKeyService();
    ITaxFileService getTaxFileService();
    ICatalogService getCatalogService();
    IDownloadCatalogService getDownloadCatalogService();
    IDownloadRuleService getDownloadRuleService();
    IDownloadRequestService getDownloadRequestService();
    IStampService getStampService();
    // ... etc
}
