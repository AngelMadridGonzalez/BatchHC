package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.TicketCobro;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TicketCobroService {

    public static void TicketCobros () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/ticketcobros.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        //FIXME
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/dogodb.db");
            String queryInsert = "INSERT INTO Ticket_Cobros (id, idTipoCobro, numeroTicket, importe, fechaPago, cobrado) VALUES ( ?, ?, ?, ?, ?, ?)"; // Ajustamos la query

            System.out.println("INICIAMOS LECTURA TicketCobroService");

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);

                TicketCobro ticketCobros = new TicketCobro(); // Ajusta según tus campos
                ticketCobros.setIdReserva(Integer.parseInt(datos[0]));
                ticketCobros.setIdTipoCobro(Integer.parseInt(datos[1]));
                ticketCobros.setNumeroTicket(Integer.parseInt(datos[2]));
                if(!StringUtils.isBlank(datos[3])){
                    ticketCobros.setImporte(new BigDecimal(datos[3]));
                }
                ticketCobros.setFechaPago(datos[4]);

                //FIXME Pongo SI a lo cobrado
                ticketCobros.setCobrado("SI");
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

                    preparedStatement.setString(1, String.valueOf(ticketCobros.getIdReserva()));
                    preparedStatement.setString(2, String.valueOf(ticketCobros.getIdTipoCobro()));
                    preparedStatement.setString(3, String.valueOf(ticketCobros.getNumeroTicket()));
                    preparedStatement.setString(4, String.valueOf(ticketCobros.getImporte()));
                    preparedStatement.setString(5, ticketCobros.getFechaPago());
                    preparedStatement.setString(6, ticketCobros.getCobrado());

                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION TicketCobroService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //FIXME
    // Hay que quitar el id como PK

}
