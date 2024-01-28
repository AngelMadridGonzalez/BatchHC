package org.hc.processor;

import com.opencsv.CSVReader;
import org.hc.model.entity.CuentasClientes;
import org.hc.service.CuentasClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileReader;
import java.util.List;
@Component
public class CsvDataProcessor {

    private final CuentasClientesService cuentasClientesService;
    @Autowired
    public CsvDataProcessor(CuentasClientesService cuentasClientesService) {
        this.cuentasClientesService = cuentasClientesService;
    }

    public void processCsvFile(File file) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> lines = reader.readAll();
            for (String[] line : lines) {
                CuentasClientes cuentasClientes = new CuentasClientes();
                cuentasClientes.setId(Integer.parseInt(line[0]));
                cuentasClientes.setIdCliente(line[0]);
                cuentasClientesService.insertarRegistro(cuentasClientes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // También puedes utilizar un logger para registrar el error
            // logger.error("Error al leer el archivo CSV", e);
        }
    }
}
