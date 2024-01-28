package org.hc;

import org.hc.v2.BatchProgram;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.hc", "org.hc.service"})
public class BatchApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BatchApplication.class, args);

        // Ejecuta la lógica de BatchProgram después de arrancar la aplicación
        BatchProgram batchProgram = SpringApplication.run(BatchApplication.class, args)
                .getBean(BatchProgram.class);
        batchProgram.run(args);
    }
}