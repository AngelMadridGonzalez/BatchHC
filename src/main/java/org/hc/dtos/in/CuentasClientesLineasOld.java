package org.hc.dtos.in;

import java.math.BigDecimal;

public class CuentasClientesLineasOld {

	private int idCliente;
	
	private String fecha;
	
	private int idTipoCobros;
	
	private BigDecimal importe;
	
	private String descripci�n;

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

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}

	public CuentasClientesLineasOld(int idCliente, String fecha, int idTipoCobros, BigDecimal importe,
			String descripci�n) {
		super();
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.idTipoCobros = idTipoCobros;
		this.importe = importe;
		this.descripci�n = descripci�n;
	}
}
