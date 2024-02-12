package org.hc.service;

import org.apache.commons.lang3.StringUtils;
import org.hc.model.Animal;
import org.hc.utils.Sexo;
import org.hc.utils.TipoAnimal;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AnimalService {
    public static void Animales () throws IOException {
        // Ruta al archivo CSV
        String filePath = "csv/animales.csv";

        // Crea un objeto Resource usando ClassPathResource
        Resource resource = new ClassPathResource(filePath);
        java.io.File file = resource.getFile();

        String line;
        String cvsSplitBy = ",";

        //"id","lnk_idcliente","trial_lnk_idtipanimal_3","nombre","numtarsani","fechanaci","raza","observaci","sexo","historico","color"
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            String queryInsert = "INSERT INTO Animales (id, idCliente, idTipoAnimal, nombre, nMicrochip, fNacimiento, raza, observacion, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("INICIAMOS LECTURA AnimalService");

            while ((line = br.readLine()) != null) {

                String[] datos = line.split(cvsSplitBy);

                Animal animal = new Animal(); // Ajusta según campos
                animal.setId(Integer.parseInt(datos[0]));
                animal.setIdCliente(Integer.parseInt(datos[1]));
                animal.setIdTipoAnimal(TipoAnimal.obtainTipoAnimal((datos[2])));
                animal.setNombre(datos[3]);
                if(!StringUtils.isBlank(datos[4])){
                    animal.setnMicrochip(datos[4]);
                }else{
                    animal.setnMicrochip(datos[0]);
                }
                animal.setfNacimiento(datos[5]);
                animal.setRaza(datos[6]);
                animal.setObservacion(datos[7].concat(datos[9]).concat(" color : ".concat(datos[10])));
                if(!StringUtils.isBlank(datos[8])){
                    animal.setSexo(Sexo.obtainNewSex(datos[8]));
                }
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

                    preparedStatement.setString(1, String.valueOf(animal.getId()));
                    preparedStatement.setString(2, String.valueOf(animal.getIdCliente()));
                    preparedStatement.setString(3, String.valueOf(animal.getIdTipoAnimal()));
                    preparedStatement.setString(4, animal.getNombre());
                    preparedStatement.setString(5, animal.getnMicrochip());
                    preparedStatement.setString(6, animal.getfNacimiento());
                    preparedStatement.setString(7, animal.getRaza());
                    preparedStatement.setString(8, animal.getObservacion());
                    preparedStatement.setString(9, String.valueOf(animal.getSexo()));
                    //Preparar los statement
                    preparedStatement.executeUpdate();
                }
            }
            connection.close();
            System.out.println("CERRAMOS CONEXION AnimalService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}