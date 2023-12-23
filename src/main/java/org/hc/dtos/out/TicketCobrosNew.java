package org.hc.dtos.out;

import java.math.BigDecimal;

public class TicketCobrosNew {

	private int idTipoCobro;
	
	private int numeroTicket;
	
	private int idOcupaci�n;

	private BigDecimal importe;

	private String cobrado;
	
	private String fechaPago;
	
	private String observaci�n;

	public int getIdTipoCobro() {
		return idTipoCobro;
	}

	public void setIdTipoCobro(int idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public int getIdOcupaci�n() {
		return idOcupaci�n;
	}

	public void setIdOcupaci�n(int idOcupaci�n) {
		this.idOcupaci�n = idOcupaci�n;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getCobrado() {
		return cobrado;
	}

	public void setCobrado(String cobrado) {
		this.cobrado = cobrado;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getObservaci�n() {
		return observaci�n;
	}

	public void setObservaci�n(String observaci�n) {
		this.observaci�n = observaci�n;
	}

	public TicketCobrosNew(int idTipoCobro, int numeroTicket, int idOcupaci�n, BigDecimal importe, String cobrado,
			String fechaPago, String observaci�n) {
		super();
		this.idTipoCobro = idTipoCobro;
		this.numeroTicket = numeroTicket;
		this.idOcupaci�n = idOcupaci�n;
		this.importe = importe;
		this.cobrado = cobrado;
		this.fechaPago = fechaPago;
		this.observaci�n = observaci�n;
	}

	public TicketCobrosNew() {
		super();
	}
}
