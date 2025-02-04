package com.example.multi_datasource.Controller;

import com.example.multi_datasource.Entities.ControlEscolar.AlumnosEntity;
import com.example.multi_datasource.Service.ControlEscolar.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ControlEscolar")
public class ControlEscolarController {

    @Autowired
    AlumnosService alumnosService;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola Mundo";
    }

    @GetMapping("/alumnos/listarAlumnos")
    public List<AlumnosEntity> listarAlumnos() {
        return alumnosService.findAll();
    }

    @PostMapping("/alumnos/crearAlumno")
    public AlumnosEntity crearAlumno(@RequestBody AlumnosEntity nuevoAlumno) {
        return alumnosService.save(nuevoAlumno);
    }

    @PutMapping("/alumnos/actualizarAlumno")
    public AlumnosEntity actualizarAlumno(@RequestBody AlumnosEntity alumno) {
        return alumnosService.update(alumno);
    }

}
