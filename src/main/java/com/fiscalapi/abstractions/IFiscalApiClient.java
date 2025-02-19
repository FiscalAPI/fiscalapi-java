package com.fiscalapi.abstractions;

public interface IFiscalApiClient {
    IInvoiceService getInvoices();
    IProductService getProducts();
    IPersonService getPersons();
    // ... etc
}
