package org.hc.v2;

import org.hc.model.entity.CuentasClientes;
import org.hc.service.CuentasClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
@Component
public class BatchProgram implements CommandLineRunner {

    private final CsvReader csvReader;
    private final CuentasClientesService cuentasClientesService;

    @Autowired
    public BatchProgram(CsvReader csvReader, CuentasClientesService cuentasClientesService) {
        this.csvReader = csvReader;
        this.cuentasClientesService = cuentasClientesService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Ruta al archivo CSV
        String filePath = "cuentasclientes.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        // Lee el archivo CSV
        List<String[]> registros = csvReader.leerArchivo(file);

        // Procesa los registros y los inserta en la base de datos
        for (String[] registroDatos : registros) {
            // Crea una instancia de Registro y asigna valores
            CuentasClientes registro = new CuentasClientes();
            registro.setId(Integer.parseInt(registroDatos[0]));
            registro.setIdCliente(registroDatos[0]);
            // Inserta el registro en la base de datos
            cuentasClientesService.insertarRegistro(registro);
        }
    }
}