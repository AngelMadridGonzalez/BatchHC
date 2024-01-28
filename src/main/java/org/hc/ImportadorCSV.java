package org.hc;

import java.io.IOException;

import static org.hc.service.CuentaClienteService.cuentasClientes;

public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        cuentasClientes();
    }
}