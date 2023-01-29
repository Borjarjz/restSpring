package com.example.restspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestSpringApplication {
    //. El método main ejecuta la aplicación con la clase actual (RestSpringApplication) como argumento. La aplicación se inicia con SpringApplication.run y está lista para recibir solicitudes web.

    public static void main(String[] args) {
        SpringApplication.run(RestSpringApplication.class, args);
    }

}
