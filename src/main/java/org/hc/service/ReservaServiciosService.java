package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.Cliente;
import org.hc.model.ReservaServicios;
import org.hc.utils.TiposServicios;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReservaServiciosService {

    public static void ReservasServicios () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/reservasservicios.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        //{"id","lnk_idreservas","lnk_idreservascelanim","tipo","fecha","dias","cantidad","trial_lnk_idtipservicios_8","observaci","precio","fechaserv"}
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/dogodb.db");
            String queryInsert = "INSERT INTO Reserva_Servicios (id, idTarifa, dias, cantidad, importe, fecha, fechaServicio,observacion) VALUES (?, ?, ?, ?, ?, ?, ?,?)"; // Ajustamos la query

            System.out.println("INICIAMOS LECTURA ReservaServiciosService");

            while ((line = br.readLine()) != null) {

                String[] datos = line.split(cvsSplitBy);

                ReservaServicios reservaServicios = new ReservaServicios(); // Ajusta según campos
                reservaServicios.setId(Integer.parseInt(datos[0]));
                //FIXME trial_lnk_idtipservicios_8 tenemos que revisar para cuadrar con Tarifas
                if(!StringUtils.isBlank(datos[7])){
                    String idTarifa = datos[7].replaceAll("\"+", "");
                    reservaServicios.setIdTarifas(TiposServicios.obtainTarifa(idTarifa.replaceAll("\"+", "")));
                }
                reservaServicios.setTipo(datos[3].replaceAll("\"+", ""));
                if(!StringUtils.isBlank(datos[5])){
                    reservaServicios.setDias(Integer.parseInt(datos[5]));
                }
                if(!StringUtils.isBlank(datos[6])){
                    reservaServicios.setCantidad(Integer.parseInt(datos[6]));
                }
                reservaServicios.setImporte(new BigDecimal(datos[9]));
                reservaServicios.setFecha(datos[4]);
                if(datos.length>10){
                    reservaServicios.setFecha_servicio(datos[10]);
                }
                reservaServicios.setObservacion(datos[8].replaceAll("\"+", ""));
                //FIXME No metermos idReservas
                //reservaServicios.setIdReserva(datos[1]);
                //lnk_idreservascelanim datos[2]
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

                    preparedStatement.setString(1, String.valueOf(reservaServicios.getId()));
                    preparedStatement.setString(2, String.valueOf(reservaServicios.getIdTarifas()));
                    //preparedStatement.setString(3, reservaServicios.getTipo());
                    //preparedStatement.setString(4, String.valueOf(reservaServicios.getIdReserva()));
                    preparedStatement.setString(3, String.valueOf(reservaServicios.getDias()));
                    preparedStatement.setString(4, String.valueOf(reservaServicios.getCantidad()));
                    preparedStatement.setString(5, String.valueOf(reservaServicios.getImporte()));
                    preparedStatement.setString(6, reservaServicios.getFecha());
                    preparedStatement.setString(7, reservaServicios.getFecha_servicio());
                    preparedStatement.setString(8, reservaServicios.getObservacion());

                    //Preparar los statement
                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION ReservaServiciosService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
