package org.hc.dtos.in;

public class CuentasClientesOld {

	private int idCliente;
	
	private String dirección;
	
	private String fecha;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public CuentasClientesOld(int idCliente, String dirección, String fecha) {
		super();
		this.idCliente = idCliente;
		this.dirección = dirección;
		this.fecha = fecha;
	}
}
