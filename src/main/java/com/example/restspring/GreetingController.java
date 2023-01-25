package com.example.restspring;



import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        JSONArray peliculasArray = new JSONArray();
        JSONObject jsonPeliculas = new JSONObject();

        JSONObject pelicula1 = new JSONObject();
        pelicula1.put("id", 1);
        pelicula1.put("nombre", "El sexto sentido");
        pelicula1.put("director", "M. Night Shyamalan");
        pelicula1.put("clasificacion", "Drama");
        peliculasArray.put(pelicula1);

        JSONObject pelicula2 = new JSONObject();
        pelicula2.put("id", 2);
        pelicula2.put("nombre", "Pulp Fiction");
        pelicula2.put("director", "Tarantino");
        pelicula2.put("clasificacion", "Acción");
        peliculasArray.put(pelicula2);

        JSONObject pelicula3 = new JSONObject();
        pelicula3.put("id", 3);
        pelicula3.put("nombre", "Todo Sobre Mi Madre");
        pelicula3.put("director", "Almodobar");
        pelicula3.put("clasificacion", "Drama");
        peliculasArray.put(pelicula3);

        jsonPeliculas.put("peliculas",peliculasArray);
        Greeting greting=new Greeting(1,jsonPeliculas.toString());

        return greting;
    }
}