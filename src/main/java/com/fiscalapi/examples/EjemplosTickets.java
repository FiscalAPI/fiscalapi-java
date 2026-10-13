package com.fiscalapi.examples;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.tickets.Ticket;
import com.fiscalapi.models.tickets.TicketCodeResult;
import com.fiscalapi.models.tickets.TicketIngestionResult;
import com.fiscalapi.models.tickets.TicketIssuer;
import com.fiscalapi.models.tickets.TicketItem;
import com.fiscalapi.models.tickets.TicketItemTax;
import com.fiscalapi.models.tickets.TicketListFilters;
import com.fiscalapi.models.tickets.TicketStatus;
import com.fiscalapi.services.FiscalApiClient;

/**
 * Ejemplos de uso del servicio de tickets de Auto CFDI.
 *
 * Reglas del endpoint POST /api/v4/tickets:
 * - Ingerir un ticket cobra 1 crédito de ticket al emisor.
 * - Con Idempotency-Key, repetir la misma key con el mismo cuerpo responde 200 con el ticket original sin cobrar otra vez.
 * - El total debe cuadrar al centavo con los conceptos e impuestos (si no, 422).
 * - Un folio y serie ya activos del emisor responden 409.
 */
public class EjemplosTickets {

    // ID de la persona emisora (con CSD y créditos de ticket)
    private static final String EMISOR_ID = "<PERSON_ID>";

    public static void main(String[] args) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://test.fiscalapi.com");
        settings.setApiKey("<API_KEY>");
        settings.setTenant("<TENANT_KEY>");

        FiscalApiClient client = FiscalApiClient.create(settings);

        String ticketId = ingerirTicket(client);
        listarPendientes(client);
        if (ticketId != null) {
            consultarYCancelar(client, ticketId);
        }
    }

    /**
     * Ingiere la venta de un refresco de 100 + IVA 16 % = 116, pagado en efectivo, e imprime el código y la URL del
     * QR que van en el ticket de venta. Los importes se construyen desde texto para conservar su escala.
     */
    private static String ingerirTicket(FiscalApiClient client) {
        TicketItemTax iva = new TicketItemTax();
        iva.setTaxCode("002");
        iva.setTaxTypeCode("Tasa");
        iva.setTaxRate(new BigDecimal("0.160000"));
        iva.setTaxFlagCode("T");

        TicketItem refresco = new TicketItem();
        refresco.setItemCode("50202306");
        refresco.setItemSku("SKU-1");
        refresco.setQuantity(new BigDecimal("1"));
        refresco.setUnitOfMeasurementCode("H87");
        refresco.setDescription("Refresco");
        refresco.setUnitPrice(new BigDecimal("100.00"));
        refresco.setTaxObjectCode("02");
        refresco.setItemTaxes(Collections.singletonList(iva));

        Ticket ticket = new Ticket();
        ticket.setIssuer(new TicketIssuer(EMISOR_ID));
        ticket.setFolio("F-1001");
        ticket.setSeries("A");
        ticket.setPaymentDate(LocalDateTime.of(2026, 10, 15, 12, 30, 0)); // hora civil de México
        ticket.setPaymentFormCode("01");
        ticket.setTotal(new BigDecimal("116.00"));
        ticket.setItems(Collections.singletonList(refresco));

        ApiResponse<TicketIngestionResult> response = client.getTicketService().create(ticket, "pos-01-F-1001");
        if (!response.isSucceeded()) {
            // 409: folio y serie ya activos; 422: total que no cuadra, emisor sin CSD o sin créditos de ticket, etc.
            // getErrorData() trae el data del error: existingTicketId (409) o expectedTotal y computedTotal (422).
            System.out.println("Error " + response.getHttpStatusCode() + ": " + response.getDetails() + " " + response.getErrorData());
            return null;
        }

        System.out.println("Código: " + response.getData().getTicketCode() + " QR: " + response.getData().getQrUrl());
        return response.getData().getId();
    }

    /**
     * Lista los tickets pendientes del emisor en octubre de 2026 (fechas civiles de México, ambas incluidas).
     */
    private static void listarPendientes(FiscalApiClient client) {
        TicketListFilters filters = new TicketListFilters();
        filters.setStatus(Collections.singletonList(TicketStatus.PENDING));
        filters.setPersonId(EMISOR_ID);
        filters.setFrom(LocalDate.of(2026, 10, 1));
        filters.setTo(LocalDate.of(2026, 10, 31));
        filters.setPageNumber(1);
        filters.setPageSize(50);

        ApiResponse<PagedList<Ticket>> response = client.getTicketService().getList(filters);
        if (!response.isSucceeded()) {
            System.out.println("Error: " + response.getDetails());
            return;
        }

        for (Ticket ticket : response.getData().getItems()) {
            // getStatusValue conserva el texto de un estado que esta versión del SDK todavía no conoce.
            System.out.println("- " + ticket.getFolio() + " " + ticket.getPaymentDate() + " " + ticket.getTotal()
                    + " " + ticket.getStatusValue());
        }
    }

    /**
     * Consulta el detalle con conceptos e historia, reimprime el código y cancela el ticket (solo en estado pending;
     * el crédito de ticket no se devuelve).
     */
    private static void consultarYCancelar(FiscalApiClient client, String ticketId) {
        ApiResponse<Ticket> detail = client.getTicketService().getById(ticketId, true);
        System.out.println(detail.getData());

        ApiResponse<TicketCodeResult> code = client.getTicketService().getCode(ticketId);
        System.out.println(code.getData());

        ApiResponse<Boolean> cancelled = client.getTicketService().cancel(ticketId);
        System.out.println("Cancelado: " + cancelled.getData());
    }
}
