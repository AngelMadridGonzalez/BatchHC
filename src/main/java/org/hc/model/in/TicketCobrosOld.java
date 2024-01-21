package org.hc.model.in;

import java.math.BigDecimal;

public class TicketCobrosOld {

	private String idReserva;

	private String idTipoCobros;
	
	private String numTicket;
	
	private BigDecimal importe;
	
	private String fecha;
	
	private String fechaPago;
	
	private String idTipoCobrosPago;

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public String getIdTipoCobros() {
		return idTipoCobros;
	}

	public void setIdTipoCobros(String idTipoCobros) {
		this.idTipoCobros = idTipoCobros;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdTipoCobrosPago() {
		return idTipoCobrosPago;
	}

	public void setIdTipoCobrosPago(String idTipoCobrosPago) {
		this.idTipoCobrosPago = idTipoCobrosPago;
	}

	public TicketCobrosOld(String idReserva, String idTipoCobros, String numTicket, BigDecimal importe, String fecha,
			String fechaPago, String idTipoCobrosPago) {
		super();
		this.idReserva = idReserva;
		this.idTipoCobros = idTipoCobros;
		this.numTicket = numTicket;
		this.importe = importe;
		this.fecha = fecha;
		this.fechaPago = fechaPago;
		this.idTipoCobrosPago = idTipoCobrosPago;
	}

	public TicketCobrosOld() {
		super();
	}
}
