package com.fiscalapi.models.invoicing.foreignTrade;

/**
 * Descripcion especifica de una mercancia del complemento Comercio Exterior.
 */
public class ComercioExteriorDescripcionEspecifica {
    private String marca;
    private String modelo;
    private String subModelo;
    private String numeroSerie;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSubModelo() {
        return subModelo;
    }

    public void setSubModelo(String subModelo) {
        this.subModelo = subModelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
