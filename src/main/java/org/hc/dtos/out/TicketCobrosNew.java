package org.hc.dtos.out;

import java.math.BigDecimal;

public class TicketCobrosNew {

	private int idTipoCobro;
	
	private int numeroTicket;
	
	private int idOcupación;

	private BigDecimal importe;

	private String cobrado;
	
	private String fechaPago;
	
	private String observación;

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

	public int getIdOcupación() {
		return idOcupación;
	}

	public void setIdOcupación(int idOcupación) {
		this.idOcupación = idOcupación;
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

	public String getObservación() {
		return observación;
	}

	public void setObservación(String observación) {
		this.observación = observación;
	}

	public TicketCobrosNew(int idTipoCobro, int numeroTicket, int idOcupación, BigDecimal importe, String cobrado,
			String fechaPago, String observación) {
		super();
		this.idTipoCobro = idTipoCobro;
		this.numeroTicket = numeroTicket;
		this.idOcupación = idOcupación;
		this.importe = importe;
		this.cobrado = cobrado;
		this.fechaPago = fechaPago;
		this.observación = observación;
	}

	public TicketCobrosNew() {
		super();
	}
}
