package org.hc.dtos.out;

public class CuentasClientesNew {

	private int idCliente;
	
	private int idTicketCobro;
	
	private String tarjeta;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
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

	public CuentasClientesNew(int idCliente, int idTicketCobro, String tarjeta) {
		super();
		this.idCliente = idCliente;
		this.idTicketCobro = idTicketCobro;
		this.tarjeta = tarjeta;
	}

	public CuentasClientesNew() {
		super();
	}
}
