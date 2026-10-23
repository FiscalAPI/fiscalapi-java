package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.tickets.Ticket;
import com.fiscalapi.models.tickets.TicketCodeResult;
import com.fiscalapi.models.tickets.TicketIngestionResult;
import com.fiscalapi.models.tickets.TicketListFilters;

/**
 * Tickets de Auto CFDI: ingesta de ventas pagadas del punto de venta, consulta con filtros, código para reimprimir y
 * cancelación.
 */
public interface ITicketService {

    /**
     * Ingiere un ticket y cobra 1 crédito de ticket, sin header Idempotency-Key.
     * POST /api/{apiVersion}/tickets
     *
     * @param ticket Ticket a ingerir
     * @return ApiResponse con el ticket ingerido (código y URL del QR)
     */
    ApiResponse<TicketIngestionResult> create(Ticket ticket);

    /**
     * Ingiere un ticket y cobra 1 crédito de ticket. POST /api/{apiVersion}/tickets
     * Con idempotencyKey (de 1 a 64 caracteres ASCII visibles, sin espacios) se envía el header Idempotency-Key: repetir
     * la misma llave de idempotencia con el mismo cuerpo, dentro de 24 h, devuelve la respuesta original (201, con el
     * header Idempotent-Replayed: true) sin registrar otro ticket ni cobrar otra vez; con otro cuerpo, 422; con la
     * original aún en proceso, 409 con Retry-After. Con null, el header no se envía. Un folio y serie ya activos del
     * emisor responden 409.
     *
     * @param ticket         Ticket a ingerir
     * @param idempotencyKey Llave de idempotencia (idempotency key), valor del header Idempotency-Key, o null para no
     *                       enviarlo
     * @return ApiResponse con el ticket ingerido (código y URL del QR)
     */
    ApiResponse<TicketIngestionResult> create(Ticket ticket, String idempotencyKey);

    /**
     * Lista los tickets del tenant con los filtros asignados (null o sin filtros: todos, primera página).
     * GET /api/{apiVersion}/tickets
     *
     * @param filters Filtros de la consulta
     * @return ApiResponse con la página de tickets
     */
    ApiResponse<PagedList<Ticket>> getList(TicketListFilters filters);

    /**
     * Obtiene un ticket; con details trae también sus conceptos e historia.
     * GET /api/{apiVersion}/tickets/{id}?details=true
     *
     * @param id      Id del ticket
     * @param details Incluir conceptos e historia
     * @return ApiResponse con el ticket
     */
    ApiResponse<Ticket> getById(String id, boolean details);

    /**
     * Obtiene el código del ticket y la URL de su QR, para reimprimirlo. GET /api/{apiVersion}/tickets/{id}/code
     *
     * @param id Id del ticket
     * @return ApiResponse con el código y la URL del QR
     */
    ApiResponse<TicketCodeResult> getCode(String id);

    /**
     * Cancela un ticket en estado pending (409 en cualquier otro estado); el crédito de ticket no se devuelve.
     * DELETE /api/{apiVersion}/tickets/{id}
     *
     * @param id Id del ticket
     * @return ApiResponse con true si se canceló
     */
    ApiResponse<Boolean> cancel(String id);
}
