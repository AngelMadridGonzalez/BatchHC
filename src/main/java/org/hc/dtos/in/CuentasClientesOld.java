package org.hc.dtos.in;

public class CuentasClientesOld {

	private int idCliente;
	
	private String direcci�n;
	
	private String fecha;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDirecci�n() {
		return direcci�n;
	}

	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public CuentasClientesOld(int idCliente, String direcci�n, String fecha) {
		super();
		this.idCliente = idCliente;
		this.direcci�n = direcci�n;
		this.fecha = fecha;
	}
}
