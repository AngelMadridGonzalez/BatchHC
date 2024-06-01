package org.hc.model;

import java.math.BigDecimal;
public class TicketCobro {

    int idOcupacion;
    int idTipoCobro;
    int numeroTicket;
    BigDecimal importe;
    String cobrado;
    String fechaPago;
    String observacion;

    public TicketCobro() {
        super();
    }

    public TicketCobro(int idOcupacion, int idTipoCobro, int numeroTicket, BigDecimal importe, String cobrado, String fechaPago, String observacion) {
        this.idOcupacion = idOcupacion;
        this.idTipoCobro = idTipoCobro;
        this.numeroTicket = numeroTicket;
        this.importe = importe;
        this.cobrado = cobrado;
        this.fechaPago = fechaPago;
        this.observacion = observacion;
    }

    public int getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    public int getIdTipoCobro() {
        return idTipoCobro;
    }

    public void setIdTipoCobro(int idTipoCobro) {
        this.idTipoCobro = idTipoCobro;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getCobrado() {
        return cobrado;
    }

    public void setCobrado(String cobrado) {
        this.cobrado = cobrado;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}