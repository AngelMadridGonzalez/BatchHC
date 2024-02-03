package org.hc;

import java.io.IOException;

import static org.hc.service.CuentaClienteService.cuentasClientes;
import static org.hc.service.CuentaClienteService.cuentasClientesLineas;
import static org.hc.service.CuentaClienteService.ticketCobros;
public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        //cuentasClientes();
        //cuentasClientesLineas();
        ticketCobros();
    }
}