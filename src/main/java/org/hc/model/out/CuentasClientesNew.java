package org.hc.model.out;

public class CuentasClientesNew {

	private int id;
	
	private int idCliente;
	
	private int idTicketCobro;
	
	private String tarjeta;

	private int importe;
	
	private int estado;

	public CuentasClientesNew() {
		super();
	}
	
	public CuentasClientesNew(int id, int idCliente, int idTicketCobro, String tarjeta, int importe, int estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idTicketCobro = idTicketCobro;
		this.tarjeta = tarjeta;
		this.importe = importe;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
