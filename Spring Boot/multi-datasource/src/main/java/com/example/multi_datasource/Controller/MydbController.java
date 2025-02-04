package com.example.multi_datasource.Controller;

import com.example.multi_datasource.Entities.Mydb.AsnEntity;
import com.example.multi_datasource.Service.Mydb.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Asn/")
public class MydbController {

    @Autowired
    AsnService asnService;

    @GetMapping("/hola")
    public String hola(){
        return "Hola Mundo";
    }

    @GetMapping("/listar")
    public List<AsnEntity> listar(){
        return asnService.findAll();
    }

    @PostMapping("/crear")
    public AsnEntity crearAsn(@RequestBody AsnEntity asn){
        return asnService.crearAsn(asn);
    }

    @PutMapping("/actualizar")
    public AsnEntity actualizarAsn(@RequestBody AsnEntity asn){
        return asnService.actualizarAsn(asn);
    }

    @DeleteMapping("/eliminar/{asnReference}")
    public String eliminarAsn(@PathVariable Long asnReference){
        return asnService.eliminarAsn(asnReference);
    }


}
