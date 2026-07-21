package com.br.nandoks.catoks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CatoksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatoksApplication.class, args);
    }

}
