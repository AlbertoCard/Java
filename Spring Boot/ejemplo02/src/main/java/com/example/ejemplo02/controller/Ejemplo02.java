package com.example.ejemplo02.controller;

import com.example.ejemplo02.Service.SumaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ejemplo02 {

    @Autowired
    SumaService sumaService;

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }

    @GetMapping("saludo/{nombre}")
    public String saludo(@PathVariable("nombre") String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("/suma/{num1}/{num2}")
    public int suma(@PathVariable("num1") int num1, @PathVariable("num2") int num2){
        return sumaService.suma(num1, num2);
    }
}
