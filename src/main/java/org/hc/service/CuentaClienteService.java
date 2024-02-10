package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.CuentaCliente;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CuentaClienteService {

    public static void CuentasClientes () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/cuentasclientes.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            String queryInsert = "INSERT INTO CuentasClientes (id, idCliente) VALUES (?, ?)"; // Ajustamos la query

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);

                // Rellenamos el objeto en funcion del csv
                CuentaCliente cuentaCliente = new CuentaCliente();
                cuentaCliente.setIdCliente(datos[0]);

                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
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


    public static void CuentasClientesLineas () throws IOException {

        // Ruta al archivo CSV
        String filePath = "csv/cuentasclienteslineas.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            //String query = "INSERT INTO CuentasClientes (id, idCliente) VALUES (?, ?)"; // Ajusta según tus campos
            String queryUpdate = "UPDATE CuentasClientes SET id = ?, idCliente = ?, idTicketCobro = ?, importe = ? WHERE id = ?";

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);

                CuentaCliente cuentaCliente = new CuentaCliente(); // Ajusta según tus campos
                cuentaCliente.setIdCliente(datos[0]);
                cuentaCliente.setIdTicketCobro(Integer.parseInt(datos[2]));
                if(!StringUtils.isBlank(datos[3])){
                    cuentaCliente.setImporte(new BigDecimal(datos[3]));
                }

                try (PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {

                    preparedStatement.setString(1, cuentaCliente.getIdCliente());
                    preparedStatement.setString(2, cuentaCliente.getIdCliente());
                    preparedStatement.setString(3, String.valueOf(cuentaCliente.getIdTicketCobro()));
                    preparedStatement.setString(4, String.valueOf(cuentaCliente.getImporte()));
                    preparedStatement.setString(5, cuentaCliente.getIdCliente());

                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
