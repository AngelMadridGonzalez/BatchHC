package org.hc.model.out;

import java.math.BigDecimal;

public class TicketCobrosNew {

	private int id;
	
	private int idTipoCobro;
	
	private int numeroTicket;
	
	private int idOcupacion;

	private BigDecimal importe;

	private String cobrado;
	
	private String fechaPago;
	
	private String observacion;

	public TicketCobrosNew() {
		super();

	}
	
	public TicketCobrosNew(int id, int idTipoCobro, int numeroTicket, int idOcupacion, BigDecimal importe,
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

	public int getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(int idOcupacion) {
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
