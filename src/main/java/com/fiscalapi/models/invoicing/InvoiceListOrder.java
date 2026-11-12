package com.fiscalapi.models.invoicing;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Orden de la lista de facturas por fecha de creación ({@link InvoiceListFilters#setOrder}), con el texto que usa la API.
 */
public enum InvoiceListOrder {
    /** De la más antigua a la más reciente (el orden por omisión). */
    ASC("asc"),
    /** Las más recientes primero. */
    DESC("desc");

    private final String value;

    InvoiceListOrder(String value) {
        this.value = value;
    }

    /**
     * @return El texto del orden en la API
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
