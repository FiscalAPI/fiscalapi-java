package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.invoicing.*;

public interface IInvoiceService extends IFiscalApiService<Invoice> {
    // Podríamos añadir métodos específicos

    /**
     * Lista las facturas del tenant con los filtros y el orden asignados (null o sin filtros: la lista de siempre,
     * primera página). GET /api/{apiVersion}/invoices
     *
     * @param filters Filtros de la consulta
     * @return ApiResponse con la página de facturas
     */
    ApiResponse<PagedList<Invoice>> getList(InvoiceListFilters filters);

    /**
     * Crea una factura con la llave de idempotencia de la petición. POST /api/{apiVersion}/invoices
     * Con idempotencyKey (hasta 64 caracteres ASCII visibles, sin espacios) se envía el header Idempotency-Key: repetir
     * la misma petición con la misma llave de idempotencia dentro de 24 horas devuelve la respuesta original; otra petición con la misma
     * llave de idempotencia responde 422, y una petición original todavía en proceso responde 409. Con null, el header no se envía.
     *
     * @param model          Factura a crear
     * @param idempotencyKey Valor del header Idempotency-Key, o null para no enviarlo
     * @return ApiResponse con la factura creada
     */
    ApiResponse<Invoice> create(Invoice model, String idempotencyKey);

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