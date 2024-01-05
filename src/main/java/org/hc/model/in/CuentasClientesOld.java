package org.hc.model.in;

public class CuentasClientesOld {

	private String idCliente;
	
	private String direccion;
	
	private String fecha;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
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

	public CuentasClientesOld(String idCliente, String direccion, String fecha) {
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.fecha = fecha;
	}

	public CuentasClientesOld() {
		super();
	}
}
