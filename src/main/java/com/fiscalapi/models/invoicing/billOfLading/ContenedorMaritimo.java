package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class ContenedorMaritimo {
    private String tipoContenedorId;
    private String matriculaContenedor;
    private String numPrecinto;
    private String idCCPRelacionado;
    private String placaVMCCP;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime fechaCertificacionCCP;

    private List<RemolqueCCP> remolquesCCP;

    public String getTipoContenedorId() {
        return tipoContenedorId;
    }

    public void setTipoContenedorId(String tipoContenedorId) {
        this.tipoContenedorId = tipoContenedorId;
    }

    public String getMatriculaContenedor() {
        return matriculaContenedor;
    }

    public void setMatriculaContenedor(String matriculaContenedor) {
        this.matriculaContenedor = matriculaContenedor;
    }

    public String getNumPrecinto() {
        return numPrecinto;
    }

    public void setNumPrecinto(String numPrecinto) {
        this.numPrecinto = numPrecinto;
    }

    public String getIdCCPRelacionado() {
        return idCCPRelacionado;
    }

    public void setIdCCPRelacionado(String idCCPRelacionado) {
        this.idCCPRelacionado = idCCPRelacionado;
    }

    public String getPlacaVMCCP() {
        return placaVMCCP;
    }

    public void setPlacaVMCCP(String placaVMCCP) {
        this.placaVMCCP = placaVMCCP;
    }

    public LocalDateTime getFechaCertificacionCCP() {
        return fechaCertificacionCCP;
    }

    public void setFechaCertificacionCCP(LocalDateTime fechaCertificacionCCP) {
        this.fechaCertificacionCCP = fechaCertificacionCCP;
    }

    public List<RemolqueCCP> getRemolquesCCP() {
        return remolquesCCP;
    }

    public void setRemolquesCCP(List<RemolqueCCP> remolquesCCP) {
        this.remolquesCCP = remolquesCCP;
    }
}
