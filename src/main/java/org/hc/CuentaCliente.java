package org.hc;

public class CuentaCliente {

    private String idCliente;

    public CuentaCliente() {
        super();
    }

    public CuentaCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
