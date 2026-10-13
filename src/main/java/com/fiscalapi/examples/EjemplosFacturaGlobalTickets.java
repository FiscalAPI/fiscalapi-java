package com.fiscalapi.examples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.invoicing.GlobalInformation;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceIssuer;
import com.fiscalapi.models.invoicing.InvoiceItem;
import com.fiscalapi.models.invoicing.InvoiceRecipient;
import com.fiscalapi.models.invoicing.ItemTax;
import com.fiscalapi.models.tickets.Ticket;
import com.fiscalapi.models.tickets.TicketItem;
import com.fiscalapi.models.tickets.TicketItemTax;
import com.fiscalapi.models.tickets.TicketListFilters;
import com.fiscalapi.models.tickets.TicketStatus;
import com.fiscalapi.services.FiscalApiClient;

/**
 * Ejemplo de factura global de tickets de Auto CFDI (POST /api/v4/invoices).
 *
 * La global de tickets es una factura de ingreso estándar (getInvoiceService().create) con globalInformation, el emisor
 * por referencia (issuer.id) y ticketId en cada concepto:
 * - Cada ticket va en un concepto por grupo de objeto de impuesto e impuestos (un ticket con IVA 16 % y 0 % lleva dos
 *   conceptos con el mismo ticketId); la suma de sus conceptos debe reflejar el ticket (si no, 400 en items[i].ticketId).
 * - Si algún ticket ya no está pendiente, 409 con data.unavailableTickets (en getErrorData()): no se cobra el timbre ni
 *   queda tomado ningún ticket.
 * - Una global lleva una sola moneda, tipo de cambio y lugar de expedición, y hasta 1,500 conceptos: este ejemplo asume
 *   tickets en MXN de un solo lugar de expedición.
 * - Una global sin ticketId no marca los tickets.
 */
public class EjemplosFacturaGlobalTickets {

    // ID de la persona emisora (con CSD)
    private static final String EMISOR_ID = "<PERSON_ID>";

    // Importes del CFDI: 6 decimales, redondeo lejos de cero en el medio (como los calcula el API)
    private static final int SEIS_DECIMALES = 6;

    public static void main(String[] args) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://test.fiscalapi.com");
        settings.setApiKey("<API_KEY>");
        settings.setTenant("<TENANT_KEY>");

        FiscalApiClient client = FiscalApiClient.create(settings);

        List<Ticket> tickets = ticketsPendientes(client);
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets pendientes en el periodo.");
            return;
        }

        ApiResponse<Invoice> response = client.getInvoiceService().create(facturaGlobal(tickets));
        if (response.isSucceeded()) {
            System.out.println("Global timbrada: " + response.getData().getUuid());
        } else if (response.getHttpStatusCode() == 409) {
            // Algún ticket ya no estaba pendiente: no se cobró el timbre ni quedó tomado ningún ticket.
            for (JsonNode unavailable : response.getErrorData().get("unavailableTickets")) {
                System.out.println("- " + unavailable.get("ticketId").asText() + ": " + unavailable.get("status").asText());
            }
        } else {
            // 400 en items[i].ticketId: los conceptos de ese ticket no lo reflejan (importes, descuentos o impuestos).
            System.out.println("Error " + response.getHttpStatusCode() + ": " + response.getDetails());
        }
    }

    /**
     * Tickets pendientes del emisor en septiembre de 2026, con el detalle de cada uno (conceptos e impuestos).
     */
    private static List<Ticket> ticketsPendientes(FiscalApiClient client) {
        List<Ticket> tickets = new ArrayList<>();
        for (int pageNumber = 1; ; pageNumber++) {
            TicketListFilters filters = new TicketListFilters();
            filters.setStatus(Collections.singletonList(TicketStatus.PENDING));
            filters.setPersonId(EMISOR_ID);
            filters.setFrom(LocalDate.of(2026, 9, 1));
            filters.setTo(LocalDate.of(2026, 9, 30));
            filters.setPageNumber(pageNumber);
            filters.setPageSize(50);

            ApiResponse<PagedList<Ticket>> page = client.getTicketService().getList(filters);
            if (!page.isSucceeded()) {
                throw new IllegalStateException("Error " + page.getHttpStatusCode() + ": " + page.getDetails());
            }
            for (Ticket summary : page.getData().getItems()) {
                tickets.add(client.getTicketService().getById(summary.getId(), true).getData());
            }
            if (!page.getData().isHasNextPage()) {
                return tickets;
            }
        }
    }

    /**
     * Global mensual de septiembre de 2026 a público en general. La forma de pago es la del ticket de mayor monto.
     */
    private static Invoice facturaGlobal(List<Ticket> tickets) {
        String lugarDeExpedicion = tickets.get(0).getExpeditionZipCode();
        Ticket mayor = tickets.get(0);
        List<InvoiceItem> conceptos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            conceptos.addAll(conceptosDelTicket(ticket));
            if (ticket.getTotal().compareTo(mayor.getTotal()) > 0) {
                mayor = ticket;
            }
        }

        InvoiceIssuer emisor = new InvoiceIssuer();
        emisor.setId(EMISOR_ID);

        InvoiceRecipient publicoEnGeneral = new InvoiceRecipient();
        publicoEnGeneral.setTin("XAXX010101000");
        publicoEnGeneral.setLegalName("PUBLICO EN GENERAL");
        publicoEnGeneral.setZipCode(lugarDeExpedicion);
        publicoEnGeneral.setTaxRegimeCode("616");
        publicoEnGeneral.setCfdiUseCode("S01");

        GlobalInformation informacionGlobal = new GlobalInformation();
        informacionGlobal.setPeriodicityCode("04");
        informacionGlobal.setMonthCode("09");
        informacionGlobal.setYear(2026);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("G");
        invoice.setDate(LocalDateTime.now());
        invoice.setPaymentFormCode(mayor.getPaymentFormCode());
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode(lugarDeExpedicion);
        invoice.setExportCode("01");
        invoice.setIssuer(emisor);
        invoice.setRecipient(publicoEnGeneral);
        invoice.setGlobalInformation(informacionGlobal);
        invoice.setItems(conceptos);
        return invoice;
    }

    /**
     * Un concepto por grupo de objeto de impuesto e impuestos del ticket: valor unitario = suma de cantidad × valor
     * unitario (6 decimales por concepto) y descuento = suma de descuentos.
     */
    private static List<InvoiceItem> conceptosDelTicket(Ticket ticket) {
        Map<String, List<TicketItem>> grupos = new LinkedHashMap<>();
        for (TicketItem item : ticket.getItems()) {
            grupos.computeIfAbsent(firmaDeImpuestos(item), key -> new ArrayList<>()).add(item);
        }

        List<InvoiceItem> conceptos = new ArrayList<>();
        for (List<TicketItem> items : grupos.values()) {
            BigDecimal importe = BigDecimal.ZERO;
            BigDecimal descuento = BigDecimal.ZERO;
            for (TicketItem item : items) {
                importe = importe.add(item.getQuantity().multiply(item.getUnitPrice()).setScale(SEIS_DECIMALES, RoundingMode.HALF_UP));
                if (item.getDiscount() != null) {
                    descuento = descuento.add(item.getDiscount());
                }
            }

            List<ItemTax> impuestos = new ArrayList<>();
            for (TicketItemTax tax : impuestosDe(items.get(0))) {
                ItemTax impuesto = new ItemTax();
                impuesto.setTaxCode(tax.getTaxCode());
                impuesto.setTaxTypeCode(tax.getTaxTypeCode());
                impuesto.setTaxRate(tax.getTaxRate());
                impuesto.setTaxFlagCode(tax.getTaxFlagCode());
                impuestos.add(impuesto);
            }

            InvoiceItem concepto = new InvoiceItem();
            concepto.setTicketId(ticket.getId());
            concepto.setItemCode("01010101");
            concepto.setItemSku(ticket.getFolio()); // NoIdentificacion: folio del ticket
            concepto.setQuantity(BigDecimal.ONE);
            concepto.setUnitOfMeasurementCode("ACT");
            concepto.setDescription("Venta");
            concepto.setUnitPrice(importe);
            concepto.setDiscount(descuento);
            concepto.setTaxObjectCode(items.get(0).getTaxObjectCode());
            concepto.setItemTaxes(impuestos);
            conceptos.add(concepto);
        }
        return conceptos;
    }

    /** Objeto de impuesto e impuestos de un concepto, sin importar el orden de los impuestos. */
    private static String firmaDeImpuestos(TicketItem item) {
        List<String> impuestos = new ArrayList<>();
        for (TicketItemTax tax : impuestosDe(item)) {
            impuestos.add(tax.getTaxCode() + "|" + tax.getTaxTypeCode() + "|"
                    + tax.getTaxRate().setScale(SEIS_DECIMALES, RoundingMode.HALF_UP).toPlainString() + "|" + tax.getTaxFlagCode());
        }
        Collections.sort(impuestos);
        return item.getTaxObjectCode() + ";" + String.join(";", impuestos);
    }

    private static List<TicketItemTax> impuestosDe(TicketItem item) {
        return item.getItemTaxes() == null ? Collections.<TicketItemTax>emptyList() : item.getItemTaxes();
    }
}
