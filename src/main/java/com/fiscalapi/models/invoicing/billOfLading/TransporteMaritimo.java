package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

public class TransporteMaritimo {
    private String permSCTId;
    private String numPermisoSCT;
    private String configMaritimaId;
    private String nombreAseg;
    private String numPolizaSeguro;
    private String tipoEmbarcacionId;
    private String matricula;
    private String numeroOMI;
    private Integer anioEmbarcacion = null;
    private String nombreEmbarc;
    private String nacionalidadEmbarcId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal unidadesDeArqBruto = null;

    private String tipoCargaId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal eslora = null;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal manga = null;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal calado = null;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal puntal = null;

    private String lineaNaviera;
    private String nombreAgenteNaviero;
    private String numCertITC;
    private String nombreEmbarCargador;
    private String nombreAgente;
    private String numAutorizacionNavieroId;
    private String numViaje;
    private String numConocEmbarc;
    private String permisoTempNavegacion;
    private List<ContenedorMaritimo> contenedores;

    public String getPermSCTId() {
        return permSCTId;
    }

    public void setPermSCTId(String permSCTId) {
        this.permSCTId = permSCTId;
    }

    public String getNumPermisoSCT() {
        return numPermisoSCT;
    }

    public void setNumPermisoSCT(String numPermisoSCT) {
        this.numPermisoSCT = numPermisoSCT;
    }

    public String getConfigMaritimaId() {
        return configMaritimaId;
    }

    public void setConfigMaritimaId(String configMaritimaId) {
        this.configMaritimaId = configMaritimaId;
    }

    public String getNombreAseg() {
        return nombreAseg;
    }

    public void setNombreAseg(String nombreAseg) {
        this.nombreAseg = nombreAseg;
    }

    public String getNumPolizaSeguro() {
        return numPolizaSeguro;
    }

    public void setNumPolizaSeguro(String numPolizaSeguro) {
        this.numPolizaSeguro = numPolizaSeguro;
    }

    public String getTipoEmbarcacionId() {
        return tipoEmbarcacionId;
    }

    public void setTipoEmbarcacionId(String tipoEmbarcacionId) {
        this.tipoEmbarcacionId = tipoEmbarcacionId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNumeroOMI() {
        return numeroOMI;
    }

    public void setNumeroOMI(String numeroOMI) {
        this.numeroOMI = numeroOMI;
    }

    public Integer getAnioEmbarcacion() {
        return anioEmbarcacion;
    }

    public void setAnioEmbarcacion(Integer anioEmbarcacion) {
        this.anioEmbarcacion = anioEmbarcacion;
    }

    public String getNombreEmbarc() {
        return nombreEmbarc;
    }

    public void setNombreEmbarc(String nombreEmbarc) {
        this.nombreEmbarc = nombreEmbarc;
    }

    public String getNacionalidadEmbarcId() {
        return nacionalidadEmbarcId;
    }

    public void setNacionalidadEmbarcId(String nacionalidadEmbarcId) {
        this.nacionalidadEmbarcId = nacionalidadEmbarcId;
    }

    public BigDecimal getUnidadesDeArqBruto() {
        return unidadesDeArqBruto;
    }

    public void setUnidadesDeArqBruto(BigDecimal unidadesDeArqBruto) {
        this.unidadesDeArqBruto = unidadesDeArqBruto;
    }

    public String getTipoCargaId() {
        return tipoCargaId;
    }

    public void setTipoCargaId(String tipoCargaId) {
        this.tipoCargaId = tipoCargaId;
    }

    public BigDecimal getEslora() {
        return eslora;
    }

    public void setEslora(BigDecimal eslora) {
        this.eslora = eslora;
    }

    public BigDecimal getManga() {
        return manga;
    }

    public void setManga(BigDecimal manga) {
        this.manga = manga;
    }

    public BigDecimal getCalado() {
        return calado;
    }

    public void setCalado(BigDecimal calado) {
        this.calado = calado;
    }

    public BigDecimal getPuntal() {
        return puntal;
    }

    public void setPuntal(BigDecimal puntal) {
        this.puntal = puntal;
    }

    public String getLineaNaviera() {
        return lineaNaviera;
    }

    public void setLineaNaviera(String lineaNaviera) {
        this.lineaNaviera = lineaNaviera;
    }

    public String getNombreAgenteNaviero() {
        return nombreAgenteNaviero;
    }

    public void setNombreAgenteNaviero(String nombreAgenteNaviero) {
        this.nombreAgenteNaviero = nombreAgenteNaviero;
    }

    public String getNumCertITC() {
        return numCertITC;
    }

    public void setNumCertITC(String numCertITC) {
        this.numCertITC = numCertITC;
    }

    public String getNombreEmbarCargador() {
        return nombreEmbarCargador;
    }

    public void setNombreEmbarCargador(String nombreEmbarCargador) {
        this.nombreEmbarCargador = nombreEmbarCargador;
    }

    public String getNombreAgente() {
        return nombreAgente;
    }

    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    public String getNumAutorizacionNavieroId() {
        return numAutorizacionNavieroId;
    }

    public void setNumAutorizacionNavieroId(String numAutorizacionNavieroId) {
        this.numAutorizacionNavieroId = numAutorizacionNavieroId;
    }

    public String getNumViaje() {
        return numViaje;
    }

    public void setNumViaje(String numViaje) {
        this.numViaje = numViaje;
    }

    public String getNumConocEmbarc() {
        return numConocEmbarc;
    }

    public void setNumConocEmbarc(String numConocEmbarc) {
        this.numConocEmbarc = numConocEmbarc;
    }

    public String getPermisoTempNavegacion() {
        return permisoTempNavegacion;
    }

    public void setPermisoTempNavegacion(String permisoTempNavegacion) {
        this.permisoTempNavegacion = permisoTempNavegacion;
    }

    public List<ContenedorMaritimo> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<ContenedorMaritimo> contenedores) {
        this.contenedores = contenedores;
    }

    public static class ContenedorMaritimo {
        private String matriculaContenedor;
        private String tipoContenedorId;
        private String numPrecinto;

        @JsonSerialize(using = BigDecimalSerializer.class)
        private BigDecimal pesoContenedorVacio;

        @JsonSerialize(using = BigDecimalSerializer.class)
        private BigDecimal pesoNetoMercancia;

        private String idCCPRelacionado;
        private String placaVMCCP;
        private String fechaCertificacionCCP;
        private List<RemolqueCCP> remolquesCCP;

        public String getMatriculaContenedor() {
            return matriculaContenedor;
        }

        public void setMatriculaContenedor(String matriculaContenedor) {
            this.matriculaContenedor = matriculaContenedor;
        }

        public String getTipoContenedorId() {
            return tipoContenedorId;
        }

        public void setTipoContenedorId(String tipoContenedorId) {
            this.tipoContenedorId = tipoContenedorId;
        }

        public String getNumPrecinto() {
            return numPrecinto;
        }

        public void setNumPrecinto(String numPrecinto) {
            this.numPrecinto = numPrecinto;
        }

        public BigDecimal getPesoContenedorVacio() {
            return pesoContenedorVacio;
        }

        public void setPesoContenedorVacio(BigDecimal pesoContenedorVacio) {
            this.pesoContenedorVacio = pesoContenedorVacio;
        }

        public BigDecimal getPesoNetoMercancia() {
            return pesoNetoMercancia;
        }

        public void setPesoNetoMercancia(BigDecimal pesoNetoMercancia) {
            this.pesoNetoMercancia = pesoNetoMercancia;
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

        public String getFechaCertificacionCCP() {
            return fechaCertificacionCCP;
        }

        public void setFechaCertificacionCCP(String fechaCertificacionCCP) {
            this.fechaCertificacionCCP = fechaCertificacionCCP;
        }

        public List<RemolqueCCP> getRemolquesCCP() {
            return remolquesCCP;
        }

        public void setRemolquesCCP(List<RemolqueCCP> remolquesCCP) {
            this.remolquesCCP = remolquesCCP;
        }
    }

    public static class RemolqueCCP {
        private String subTipoRemCCPId;
        private String placaCCP;

        public String getSubTipoRemCCPId() {
            return subTipoRemCCPId;
        }

        public void setSubTipoRemCCPId(String subTipoRemCCPId) {
            this.subTipoRemCCPId = subTipoRemCCPId;
        }

        public String getPlacaCCP() {
            return placaCCP;
        }

        public void setPlacaCCP(String placaCCP) {
            this.placaCCP = placaCCP;
        }
    }
}
