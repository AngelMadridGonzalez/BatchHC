package org.hc;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.List;
@Component
public class CsvReader {

    public List<String[]> leerArchivo(File file) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            return reader.readAll();
        }
    }
}