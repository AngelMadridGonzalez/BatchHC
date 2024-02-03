package org.hc.model;

import java.math.BigDecimal;

public class CuentaCliente {

    private String idCliente;
    private int idTicketCobro;
    private String tarjeta;
    private BigDecimal importe;
    private int estado;

    public CuentaCliente() {
        super();
    }

    public CuentaCliente(String idCliente, int idTicketCobro, String tarjeta, BigDecimal importe, int estado) {
        this.idCliente = idCliente;
        this.idTicketCobro = idTicketCobro;
        this.tarjeta = tarjeta;
        this.importe = importe;
        this.estado = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTicketCobro() {
        return idTicketCobro;
    }

    public void setIdTicketCobro(int idTicketCobro) {
        this.idTicketCobro = idTicketCobro;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
