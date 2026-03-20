package com.fiscalapi.models.invoicing.billOfLading;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

public class CartaPorte {
    private String transpInternacId;
    private String entradaSalidaMercId;
    private String paisOrigenDestinoId;
    private String viaEntradaSalidaId;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal totalDistRec;

    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal pesoNetoTotal;

    private String registroISTMOId;
    private String ubicacionPoloOrigenId;
    private String ubicacionPoloDestinoId;
    private String unidadPesoId;
    private String logisticaInversaRecoleccionDevolucionId;
    private List<RegimenAduanero> regimenAduaneros;
    private List<Ubicacion> ubicaciones;
    private List<Mercancia> mercancias;
    private Autotransporte autotransporte;
    private TransporteMaritimo transporteMaritimo;
    private TransporteAereo transporteAereo;
    private TransporteFerroviario transporteFerroviario;
    private List<TipoFigura> tiposFigura;

    public String getTranspInternacId() {
        return transpInternacId;
    }

    public void setTranspInternacId(String transpInternacId) {
        this.transpInternacId = transpInternacId;
    }

    public String getEntradaSalidaMercId() {
        return entradaSalidaMercId;
    }

    public void setEntradaSalidaMercId(String entradaSalidaMercId) {
        this.entradaSalidaMercId = entradaSalidaMercId;
    }

    public String getPaisOrigenDestinoId() {
        return paisOrigenDestinoId;
    }

    public void setPaisOrigenDestinoId(String paisOrigenDestinoId) {
        this.paisOrigenDestinoId = paisOrigenDestinoId;
    }

    public String getViaEntradaSalidaId() {
        return viaEntradaSalidaId;
    }

    public void setViaEntradaSalidaId(String viaEntradaSalidaId) {
        this.viaEntradaSalidaId = viaEntradaSalidaId;
    }

    public BigDecimal getTotalDistRec() {
        return totalDistRec;
    }

    public void setTotalDistRec(BigDecimal totalDistRec) {
        this.totalDistRec = totalDistRec;
    }

    public BigDecimal getPesoNetoTotal() {
        return pesoNetoTotal;
    }

    public void setPesoNetoTotal(BigDecimal pesoNetoTotal) {
        this.pesoNetoTotal = pesoNetoTotal;
    }

    public String getRegistroISTMOId() {
        return registroISTMOId;
    }

    public void setRegistroISTMOId(String registroISTMOId) {
        this.registroISTMOId = registroISTMOId;
    }

    public String getUbicacionPoloOrigenId() {
        return ubicacionPoloOrigenId;
    }

    public void setUbicacionPoloOrigenId(String ubicacionPoloOrigenId) {
        this.ubicacionPoloOrigenId = ubicacionPoloOrigenId;
    }

    public String getUbicacionPoloDestinoId() {
        return ubicacionPoloDestinoId;
    }

    public void setUbicacionPoloDestinoId(String ubicacionPoloDestinoId) {
        this.ubicacionPoloDestinoId = ubicacionPoloDestinoId;
    }

    public String getUnidadPesoId() {
        return unidadPesoId;
    }

    public void setUnidadPesoId(String unidadPesoId) {
        this.unidadPesoId = unidadPesoId;
    }

    public String getLogisticaInversaRecoleccionDevolucionId() {
        return logisticaInversaRecoleccionDevolucionId;
    }

    public void setLogisticaInversaRecoleccionDevolucionId(String logisticaInversaRecoleccionDevolucionId) {
        this.logisticaInversaRecoleccionDevolucionId = logisticaInversaRecoleccionDevolucionId;
    }

    public List<RegimenAduanero> getRegimenAduaneros() {
        return regimenAduaneros;
    }

    public void setRegimenAduaneros(List<RegimenAduanero> regimenAduaneros) {
        this.regimenAduaneros = regimenAduaneros;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public void setMercancias(List<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }

    public Autotransporte getAutotransporte() {
        return autotransporte;
    }

    public void setAutotransporte(Autotransporte autotransporte) {
        this.autotransporte = autotransporte;
    }

    public TransporteMaritimo getTransporteMaritimo() {
        return transporteMaritimo;
    }

    public void setTransporteMaritimo(TransporteMaritimo transporteMaritimo) {
        this.transporteMaritimo = transporteMaritimo;
    }

    public TransporteAereo getTransporteAereo() {
        return transporteAereo;
    }

    public void setTransporteAereo(TransporteAereo transporteAereo) {
        this.transporteAereo = transporteAereo;
    }

    public TransporteFerroviario getTransporteFerroviario() {
        return transporteFerroviario;
    }

    public void setTransporteFerroviario(TransporteFerroviario transporteFerroviario) {
        this.transporteFerroviario = transporteFerroviario;
    }

    public List<TipoFigura> getTiposFigura() {
        return tiposFigura;
    }

    public void setTiposFigura(List<TipoFigura> tiposFigura) {
        this.tiposFigura = tiposFigura;
    }
}
