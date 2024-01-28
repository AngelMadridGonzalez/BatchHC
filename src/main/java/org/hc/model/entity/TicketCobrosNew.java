package org.hc.model.entity;

import java.math.BigDecimal;

public class TicketCobrosNew {

	private int id;
	
	private String idTipoCobro;
	
	private String numeroTicket;
	
	private String idOcupacion;

	private BigDecimal importe;

	private String cobrado;
	
	private String fechaPago;
	
	private String observacion;

	public TicketCobrosNew() {
		super();

	}
	
	public TicketCobrosNew(int id, String idTipoCobro, String numeroTicket, String idOcupacion, BigDecimal importe,
			String cobrado, String fechaPago, String observacion) {
		super();
		this.id = id;
		this.idTipoCobro = idTipoCobro;
		this.numeroTicket = numeroTicket;
		this.idOcupacion = idOcupacion;
		this.importe = importe;
		this.cobrado = cobrado;
		this.fechaPago = fechaPago;
		this.observacion = observacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdTipoCobro() {
		return idTipoCobro;
	}

	public void setIdTipoCobro(String idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}

	public String getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public String getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(String idOcupacion) {
		this.idOcupacion = idOcupacion;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
