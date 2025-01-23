package com.example.CRUD01.Controller;

import com.example.CRUD01.Entities.Asn;
import com.example.CRUD01.Service.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrudController {

    @Autowired
    AsnService asnService;

    @GetMapping("/")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @GetMapping("/listar")
    public List<Asn> listar(){
        return asnService.findAll();
    }

    @PostMapping("/crear")
    public Asn crearAsn(@RequestBody Asn asn){
        return asnService.crearAsn(asn);
    }

    


}
