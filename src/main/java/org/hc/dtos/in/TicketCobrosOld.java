package org.hc.dtos.in;

import java.math.BigDecimal;

public class TicketCobrosOld {

	private int idReserva;

	private int idTipoCobros;
	
	private int numTicket;
	
	private BigDecimal importe;
	
	private String fecha;
	
	private String fechaPago;
	
	private String idTipoCobrosPago;

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdTipoCobros() {
		return idTipoCobros;
	}

	public void setIdTipoCobros(int idTipoCobros) {
		this.idTipoCobros = idTipoCobros;
	}

	public int getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(int numTicket) {
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

	public TicketCobrosOld(int idReserva, int idTipoCobros, int numTicket, BigDecimal importe, String fecha,
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
}
