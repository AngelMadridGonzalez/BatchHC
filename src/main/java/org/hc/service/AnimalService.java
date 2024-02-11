package org.hc.service;

import org.hc.model.Animal;
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

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/db/migration.db");
            String queryInsert = ""; // Ajustar la query

            System.out.println("INICIAMOS LECTURA AnimalService");

            while ((line = br.readLine()) != null) {

                String[] datos = line.split(cvsSplitBy);

                Animal animal = new Animal(); // Ajusta según campos

                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {

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