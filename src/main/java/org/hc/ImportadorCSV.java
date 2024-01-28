package org.hc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportadorCSV {
    public static void main(String[] args) throws IOException {

        // Ruta al archivo CSV
        String filePath = "cuentasclientes.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            String query = "INSERT INTO CuentasClientes (id, idCliente) VALUES (?, ?)"; // Ajusta según tus campos

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                CuentaCliente cuentaCliente = new CuentaCliente(datos[0]); // Ajusta según tus campos

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, cuentaCliente.getIdCliente());
                    preparedStatement.setString(2, cuentaCliente.getIdCliente());

                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}