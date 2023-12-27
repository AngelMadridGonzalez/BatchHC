package org.hc.dtos.in;

public class CuentasClientesOld {

	private int idCliente;
	
	private String direccion;
	
	private String fecha;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public CuentasClientesOld(int idCliente, String direccion, String fecha) {
		super();
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.fecha = fecha;
	}
}
