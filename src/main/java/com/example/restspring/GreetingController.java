package com.example.restspring;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)  {
        return new Greeting(counter.incrementAndGet(),template);
   }



    @GetMapping("/pelicula/{id}")
    public ResponseEntity<String> pelicula(@PathVariable int id) throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/datos.json")));
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray peliculasArray = jsonObject.getJSONArray("peliculas");
        JSONObject movie = peliculasArray.getJSONObject(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(movie.toString(), headers, HttpStatus.OK);

    }






}