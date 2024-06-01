package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.TicketCobro;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Map;

public class TicketCobroService {

    public static void TicketCobros () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/ticketcobros.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";
        int iterator = 12;
        //FIXME
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            //Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/dogodb.db");
            String queryInsert = "INSERT INTO Ticket_Cobros (id, idTipoCobro, numeroTicket, importe, fechaPago, cobrado, idOcupacion) VALUES ( ?, ?, ?, ?, ?, ?, ?)"; // Ajustamos la query

            System.out.println("INICIAMOS LECTURA TicketCobroService");

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);

                TicketCobro ticketCobros = new TicketCobro(); // Ajusta según tus campos
                ticketCobros.setIdTipoCobro(Integer.parseInt(datos[1]));
                ticketCobros.setNumeroTicket(Integer.parseInt(datos[2]));
                if(!StringUtils.isBlank(datos[3])){
                    ticketCobros.setImporte(new BigDecimal(datos[3]));
                }
                ticketCobros.setFechaPago(datos[4]);

                ticketCobros.setCobrado("1");

                //FIXME SI QUEREMOS EL ID_OCUPACION (EN ANTIGUO ES RESERVAS_SERVICIO)
                // TENDREMOS QUE HACER UNA QUERY MEDIANTE EL ID_RESERVA EN RESERVAS_SERVICIO
                // PARA OBTENER EL ID_OCUPACION (ID RESERVAS_SERVICIO)

                if(!datos[0].equals("-1")){
                    ticketCobros.setIdOcupacion(obtainIdOcupacion(Integer.parseInt(datos[0])));
                }
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {


                    //FIXME TENEMOS QUE REVISAR COMO OBTENER EL ID PORQUE EN TICKET_COBRO ANTIGUO NO TIENE
                    // ID POR SER TABLA INTERMEDIA, ASI QUE AUTOGENERAREMOS ID
                    // DE MOMENTO LO PONEMOS CON UN ITERADOR
                    preparedStatement.setString(1, String.valueOf(iterator));
                    iterator ++;
                    preparedStatement.setString(2, String.valueOf(ticketCobros.getIdTipoCobro()));
                    preparedStatement.setString(3, String.valueOf(ticketCobros.getNumeroTicket()));
                    preparedStatement.setString(4, String.valueOf(ticketCobros.getImporte()));
                    preparedStatement.setString(5, ticketCobros.getFechaPago());
                    preparedStatement.setString(6, ticketCobros.getCobrado());
                    preparedStatement.setString(7, String.valueOf(ticketCobros.getIdOcupacion()));

                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION TicketCobroService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int obtainIdOcupacion(int idReserva) throws SQLException {

        int idOcupacion = 0;

        //try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/dogodb.db")) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db")) {
            System.out.println("Conexión exitosa a la base de datos");

            String sql = "SELECT * FROM Reserva_Servicios WHERE idReserva = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer el valor del parámetro
            preparedStatement.setInt(1, idReserva);

            // Ejecutar la consulta y obtener los resultados
            ResultSet resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                idOcupacion = resultSet.getInt("id");

                System.out.println("ID: " + idOcupacion);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idOcupacion;
    }
}
