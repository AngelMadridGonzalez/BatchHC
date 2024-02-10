package org.hc;

import java.io.IOException;

import static org.hc.service.AnimalService.Animales;
import static org.hc.service.ClienteService.Clientes;
import static org.hc.service.CuentaClienteService.CuentasClientes;
import static org.hc.service.CuentaClienteService.CuentasClientesLineas;
import static org.hc.service.TicketCobroService.TicketCobros;
public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        CuentasClientes();
        CuentasClientesLineas();
        TicketCobros();
        Animales();
        Clientes();
        //FIXME Reserva Servicios migrar a nueva BBDD
    }
}