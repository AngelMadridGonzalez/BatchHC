package org.hc;

import java.io.IOException;

import static org.hc.service.AnimalService.Animales;
import static org.hc.service.ClienteService.Clientes;

public class ImportadorCSV {
    public static void main(String[] args) throws IOException {
        System.out.println("INI");
        Clientes();
        Animales();
        System.out.println("FIN");
    }
}