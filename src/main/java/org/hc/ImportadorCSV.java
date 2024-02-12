package org.hc;

import java.io.IOException;

import static org.hc.service.AnimalService.Animales;
import static org.hc.service.ClienteService.Clientes;
import static org.hc.service.CuentaClienteService.CuentasClientes;
import static org.hc.service.CuentaClienteService.CuentasClientesLineas;
import static org.hc.service.ReservaServiciosService.ReservasServiciosTxt;
import static org.hc.service.TicketCobroService.TicketCobros;
import static org.hc.service.ReservaServiciosService.ReservasServiciosSQL;
public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        System.out.println("INI");
//        CuentasClientes();
//        CuentasClientesLineas();
//        TicketCobros();
//        Animales();
        Clientes();
//        ReservasServiciosSQL();
//        ReservasServiciosTxt();
        System.out.println("FIN");
    }
}