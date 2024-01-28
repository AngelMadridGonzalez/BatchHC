//package org.hc;
//
//import org.hc.processor.CsvDataProcessor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "org.hc.service")
//@EntityScan(basePackages = "org.hc.model.entity")
//public class CsvBatchApplication implements CommandLineRunner {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CsvBatchApplication.class);
//    private final CsvDataProcessor csvDataProcessor;
//
//    public CsvBatchApplication(CsvDataProcessor csvDataProcessor) {
//        this.csvDataProcessor = csvDataProcessor;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(CsvBatchApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        // Ruta al archivo CSV
//
//        String filePath = "cuentasclientes.csv";
//
//        // Crea un objeto Resource usando ClassPathResource
//        Resource resource = new ClassPathResource(filePath);
//        java.io.File file = resource.getFile();
//        csvDataProcessor.processCsvFile(file);
//
//
//    }
//}