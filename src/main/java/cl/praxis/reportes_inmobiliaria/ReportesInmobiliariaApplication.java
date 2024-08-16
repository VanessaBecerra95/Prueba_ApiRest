package cl.praxis.reportes_inmobiliaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReportesInmobiliariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportesInmobiliariaApplication.class, args);
    }

}
