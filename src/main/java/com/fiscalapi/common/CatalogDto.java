package com.fiscalapi.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogDto extends BaseDto {
    private String description;

    public String getDescription() { return description; }

    /**
     * Descripción del registro de catálogo. Es de solo lectura: se puebla al deserializar la
     * respuesta y no se envía de vuelta en las peticiones, que viajan solo con el id.
     *
     * @param description Descripción recibida en la respuesta
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setDescription(String description) { this.description = description; }
}
