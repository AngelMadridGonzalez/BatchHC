package org.hc;

import java.io.IOException;

import static org.hc.service.AnimalService.Animales;
import static org.hc.service.ClienteService.Clientes;
import static org.hc.service.CuentaClienteService.CuentasClientes;
import static org.hc.service.CuentaClienteService.CuentasClientesLineas;
import static org.hc.service.TicketCobroService.TicketCobros;
import static org.hc.service.ReservaServiciosService.ReservasServicios;
public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        System.out.println("INI");
    //    Clientes();
    //    Animales();
    //    CuentasClientes();
    //    CuentasClientesLineas();
    //    TicketCobros();
        ReservasServicios();
        System.out.println("FIN");
    }
}