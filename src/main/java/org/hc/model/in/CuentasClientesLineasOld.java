package org.hc.model.in;

import java.math.BigDecimal;

public class CuentasClientesLineasOld {

	private int idCliente;
	
	private String fecha;
	
	private int idTipoCobros;
	
	private BigDecimal importe;
	
	private String descripcion;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdTipoCobros() {
		return idTipoCobros;
	}

	public void setIdTipoCobros(int idTipoCobros) {
		this.idTipoCobros = idTipoCobros;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CuentasClientesLineasOld(int idCliente, String fecha, int idTipoCobros, BigDecimal importe,
			String descripcion) {
		super();
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.idTipoCobros = idTipoCobros;
		this.importe = importe;
		this.descripcion = descripcion;
	}
}
