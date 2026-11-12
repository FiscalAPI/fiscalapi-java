package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.ITicketService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.tickets.Ticket;
import com.fiscalapi.models.tickets.TicketCodeResult;
import com.fiscalapi.models.tickets.TicketIngestionResult;
import com.fiscalapi.models.tickets.TicketListFilters;
import com.fiscalapi.models.tickets.TicketStatus;

import java.util.Collections;

public class TicketService implements ITicketService {

    private static final String IDEMPOTENCY_KEY_HEADER = "Idempotency-Key";

    private final IFiscalApiHttpClient httpClient;
    private final FiscalApiSettings settings;
    private final String apiVersion;
    private final String resourcePath = "tickets";

    public TicketService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
    }

    @Override
    public ApiResponse<TicketIngestionResult> create(Ticket ticket) {
        return create(ticket, null);
    }

    @Override
    public ApiResponse<TicketIngestionResult> create(Ticket ticket, String idempotencyKey) {
        if (ticket == null) {
            throw new IllegalArgumentException("No se acepta un ticket nulo");
        }

        if (idempotencyKey == null) {
            return httpClient.post(buildEndpoint(null), ticket, TicketIngestionResult.class);
        }
        return httpClient.post(buildEndpoint(null), ticket, TicketIngestionResult.class,
                Collections.singletonMap(IDEMPOTENCY_KEY_HEADER, idempotencyKey));
    }

    @Override
    public ApiResponse<PagedList<Ticket>> getList(TicketListFilters filters) {
        return httpClient.getPagedList(toQuery(filters).appendTo(buildEndpoint(null)), Ticket.class);
    }

    @Override
    public ApiResponse<Ticket> getById(String id, boolean details) {
        validateId(id);
        // Como getById de los demás servicios: details viaja siempre, como true o false.
        return httpClient.get(buildEndpoint(id) + "?details=" + details, Ticket.class);
    }

    @Override
    public ApiResponse<TicketCodeResult> getCode(String id) {
        validateId(id);
        return httpClient.get(buildEndpoint(id + "/code"), TicketCodeResult.class);
    }

    @Override
    public ApiResponse<Boolean> cancel(String id) {
        validateId(id);
        return httpClient.delete(buildEndpoint(id));
    }

    private String buildEndpoint(String path) {
        String baseUrl = settings.getApiUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        StringBuilder fullUrl = new StringBuilder(baseUrl)
                .append("/api/")
                .append(apiVersion)
                .append("/")
                .append(resourcePath);

        if (path != null && !path.isEmpty()) {
            fullUrl.append("/").append(path);
        }

        return fullUrl.toString();
    }

    // Los filtros asignados: status se repite por cada estado, details solo viaja en true y los null no se envían.
    private static ListQuery toQuery(TicketListFilters filters) {
        ListQuery query = new ListQuery();
        if (filters == null) {
            return query;
        }
        if (filters.getStatus() != null) {
            for (TicketStatus status : filters.getStatus()) {
                query.add("status", status.getValue());
            }
        }
        return query
                .add("personId", filters.getPersonId())
                .add("details", Boolean.TRUE.equals(filters.getDetails()) ? Boolean.TRUE : null)
                .add("globalInvoiceId", filters.getGlobalInvoiceId())
                .add("from", filters.getFrom())
                .add("to", filters.getTo())
                .add("pageNumber", filters.getPageNumber())
                .add("pageSize", filters.getPageSize());
    }

    // Sin id, la ruta sería la de la lista (GET) o la colección (DELETE): se rechaza antes de llamar a la API.
    private static void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Se requiere el id del ticket");
        }
    }
}
