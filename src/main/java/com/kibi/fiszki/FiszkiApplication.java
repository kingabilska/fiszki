package com.kibi.fiszki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FiszkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiszkiApplication.class, args);
    }

}
