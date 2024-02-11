package org.hc.model;

import java.math.BigDecimal;

public class ReservaServicios {
   int id;
   Integer idTarifas;
   String tipo;
   int idReserva;
   int dias;
   int cantidad;
   BigDecimal importe;
   String fecha;
   String fecha_servicio;
   String observacion;

   public ReservaServicios() {
      super();
   }

   public ReservaServicios(int id, Integer idTarifas, String tipo, int idReserva, int dias, int cantidad, BigDecimal importe, String fecha, String fecha_servicio, String observacion) {
      this.id = id;
      this.idTarifas = idTarifas;
      this.tipo = tipo;
      this.idReserva = idReserva;
      this.dias = dias;
      this.cantidad = cantidad;
      this.importe = importe;
      this.fecha = fecha;
      this.fecha_servicio = fecha_servicio;
      this.observacion = observacion;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Integer getIdTarifas() {
      return idTarifas;
   }

   public void setIdTarifas(Integer idTarifas) {
      this.idTarifas = idTarifas;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public int getIdReserva() {
      return idReserva;
   }

   public void setIdReserva(int idReserva) {
      this.idReserva = idReserva;
   }

   public int getDias() {
      return dias;
   }

   public void setDias(int dias) {
      this.dias = dias;
   }

   public int getCantidad() {
      return cantidad;
   }

   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
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

   public String getFecha_servicio() {
      return fecha_servicio;
   }

   public void setFecha_servicio(String fecha_servicio) {
      this.fecha_servicio = fecha_servicio;
   }

   public String getObservacion() {
      return observacion;
   }

   public void setObservacion(String observacion) {
      this.observacion = observacion;
   }
}
