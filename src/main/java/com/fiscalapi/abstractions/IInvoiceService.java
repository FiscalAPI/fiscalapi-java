package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.*;

public interface IInvoiceService extends IFiscalApiService<Invoice> {
    // Podríamos añadir métodos específicos

    //Cancelar una factura, por referencias o por valores.
    ApiResponse<InvoiceCancellationResponse> cancel(InvoiceCancellationRequest request);

    // Consultar la situación (status) de una factura.
    ApiResponse<InvoiceStatusResponse> status(InvoiceStatusRequest request);


    // Generar PDF de una factura por valores o por referencias.
    ApiResponse<PdfResponse> getPdf(PdfRequest request);


    // Envío de facturas por correo

    ApiResponse<Boolean> send (InvoiceEmailRequest request);

    // Obtener XML de factura por Id.

    ApiResponse<XmlResponse> getXml(String id);

    // etc.
}