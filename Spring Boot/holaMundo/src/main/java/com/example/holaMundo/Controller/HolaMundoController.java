package com.example.holaMundo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/saludo")
    public String miPrimerHolaMundo() {
        return "Hola Mundo";
    }


    @GetMapping("/saludo/{miNombre}")
    public String saludoPersonalizado(@PathVariable("miNombre") String nombre) {
        return "Hola " + nombre;
    }


    @GetMapping("/suma/{num1}+{num2}")
    public String suma(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        num1 += num2;
        return "La suma es: " + num1;
    }
}
