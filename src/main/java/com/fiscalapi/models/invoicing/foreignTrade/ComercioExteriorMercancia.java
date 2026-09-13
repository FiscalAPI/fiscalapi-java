package com.fiscalapi.models.invoicing.foreignTrade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Mercancia del complemento Comercio Exterior.
 *
 * Los importes se declaran como BigDecimal y se serializan con BigDecimalSerializer para que
 * la escala llegue intacta al SAT: valorDolares alimenta el TotalUSD del comprobante, que se
 * valida a dos decimales.
 */
public class ComercioExteriorMercancia {
    private String noIdentificacion;
    private String fraccionArancelariaId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal cantidadAduana;

    private String unidadAduanaId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal valorUnitarioAduana;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal valorDolares;

    private List<ComercioExteriorDescripcionEspecifica> descripcionesEspecificas;

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getFraccionArancelariaId() {
        return fraccionArancelariaId;
    }

    public void setFraccionArancelariaId(String fraccionArancelariaId) {
        this.fraccionArancelariaId = fraccionArancelariaId;
    }

    public BigDecimal getCantidadAduana() {
        return cantidadAduana;
    }

    public void setCantidadAduana(BigDecimal cantidadAduana) {
        this.cantidadAduana = cantidadAduana;
    }

    public String getUnidadAduanaId() {
        return unidadAduanaId;
    }

    public void setUnidadAduanaId(String unidadAduanaId) {
        this.unidadAduanaId = unidadAduanaId;
    }

    public BigDecimal getValorUnitarioAduana() {
        return valorUnitarioAduana;
    }

    public void setValorUnitarioAduana(BigDecimal valorUnitarioAduana) {
        this.valorUnitarioAduana = valorUnitarioAduana;
    }

    public BigDecimal getValorDolares() {
        return valorDolares;
    }

    public void setValorDolares(BigDecimal valorDolares) {
        this.valorDolares = valorDolares;
    }

    public List<ComercioExteriorDescripcionEspecifica> getDescripcionesEspecificas() {
        return descripcionesEspecificas;
    }

    public void setDescripcionesEspecificas(List<ComercioExteriorDescripcionEspecifica> descripcionesEspecificas) {
        this.descripcionesEspecificas = descripcionesEspecificas;
    }
}
