package org.hc.model.in;

import java.math.BigDecimal;

public class CuentasClientesLineasOld {

	private String idCliente;
	
	private String fecha;
	
	private String idTipoCobros;
	
	private BigDecimal importe;
	
	private String descripcion;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdTipoCobros() {
		return idTipoCobros;
	}

	public void setIdTipoCobros(String idTipoCobros) {
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

	public CuentasClientesLineasOld(String idCliente, String fecha, String idTipoCobros, BigDecimal importe,
			String descripcion) {
		super();
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.idTipoCobros = idTipoCobros;
		this.importe = importe;
		this.descripcion = descripcion;
	}
}
