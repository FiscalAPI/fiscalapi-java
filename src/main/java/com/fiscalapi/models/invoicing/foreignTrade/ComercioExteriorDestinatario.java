package com.fiscalapi.models.invoicing.foreignTrade;

import java.util.List;

/**
 * Destinatario de las mercancias exportadas.
 */
public class ComercioExteriorDestinatario {
    private String numRegIdTrib;
    private String nombre;
    private List<ComercioExteriorDestinatarioDomicilio> domicilios;

    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ComercioExteriorDestinatarioDomicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<ComercioExteriorDestinatarioDomicilio> domicilios) {
        this.domicilios = domicilios;
    }
}
