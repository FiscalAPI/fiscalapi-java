package com.fiscalapi.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class AuditableDto extends  SerializableDto {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() { return createdAt; }

    /**
     * Fecha de creación que asigna la API. Es de solo lectura: se puebla al deserializar la
     * respuesta y no se envía de vuelta en las peticiones.
     *
     * @param createdAt Fecha de creación recibida en la respuesta
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    /**
     * Fecha de última actualización que asigna la API. Es de solo lectura: se puebla al
     * deserializar la respuesta y no se envía de vuelta en las peticiones.
     *
     * @param updatedAt Fecha de actualización recibida en la respuesta
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
