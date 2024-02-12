package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.Cliente;
import org.hc.utils.Sexo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClienteService {

    public static void Clientes () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/clientes.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        //id,"nombre","apellido1","trial_apellido2_4","trial_sexo_5","dni",via,"codposta","trial_localidad_9","tlf","email","dto",fechacrea,fechaanul
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");

            String queryInsert = "INSERT INTO Clientes (id, nombre, apellido1, apellido2, sexo, dni, direccion, telefono, email, fechaAlta, fechaBaja, observacion) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

            System.out.println("INICIAMOS LECTURA ClienteService");

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                Cliente cliente = new Cliente(); // Ajusta según campos

                if(datos.length<=13){
                    cliente.setId(Integer.parseInt(datos[0]));
                    cliente.setNombre(datos[1].replaceAll("\"+", ""));
                    cliente.setApellido1(datos[2].replaceAll("\"+", ""));
                    cliente.setApellido2(datos[3].replaceAll("\"+", ""));
                    if(!StringUtils.isBlank(datos[4])){
                        cliente.setSexo(Sexo.obtainNewSex(datos[4].replaceAll("\"+", "")));
                    }
                    cliente.setDni(datos[5].replaceAll("\"+", ""));
                    cliente.setDireccion(datos[6].replaceAll("\"+", "").concat(datos[7].replaceAll("\"+", "").concat(datos[8].replaceAll("\"+", ""))));
                    cliente.setTelefono(datos[9].replaceAll("\"+", ""));
                    cliente.setEmail(datos[10].replaceAll("\"+", ""));
                    cliente.setFechaAlta(datos[12]);
                }else{
                    cliente.setId(Integer.parseInt(datos[0]));
                    cliente.setNombre(datos[1].replaceAll("\"+", ""));
                    cliente.setApellido1(datos[2].replaceAll("\"+", ""));
                    cliente.setApellido2(datos[3].replaceAll("\"+", ""));
                    if(!StringUtils.isBlank(datos[4])){
                        cliente.setSexo(Sexo.obtainNewSex(datos[4].replaceAll("\"+", "")));
                    }
                    cliente.setDni(datos[5].replaceAll("\"+", ""));
                    cliente.setDireccion(datos[6].replaceAll("\"+", "").concat(datos[7].replaceAll("\"+", "").concat(datos[8].replaceAll("\"+", "").concat(datos[9].replaceAll("\"+", "")))));
                    cliente.setTelefono(datos[10].replaceAll("\"+", ""));
                    cliente.setEmail(datos[11].replaceAll("\"+", ""));
                    cliente.setFechaAlta(datos[12]);
                    cliente.setFechaBaja(datos[13]);
                }


                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

                    preparedStatement.setString(1, String.valueOf(cliente.getId()));
                    preparedStatement.setString(2, cliente.getNombre());
                    preparedStatement.setString(3, cliente.getApellido1());
                    preparedStatement.setString(4, cliente.getApellido2());
                    preparedStatement.setString(5, String.valueOf(cliente.getSexo()));
                    preparedStatement.setString(6, cliente.getDni());
                    preparedStatement.setString(7, cliente.getDireccion());
                    preparedStatement.setString(8, String.valueOf(cliente.getTelefono()));
                    preparedStatement.setString(9, cliente.getEmail());
                    preparedStatement.setString(10, cliente.getFechaAlta());
                    preparedStatement.setString(11, cliente.getFechaBaja());
                    preparedStatement.setString(12, cliente.getObservacion());

                    //Preparar los statement
                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION ClienteService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
