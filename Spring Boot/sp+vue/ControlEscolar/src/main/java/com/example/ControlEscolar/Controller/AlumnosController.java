package com.example.ControlEscolar.Controller;

import com.example.ControlEscolar.Entities.AlumnosEntity;
import com.example.ControlEscolar.Service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin("http://localhost:8082/")
public class AlumnosController {

    @Autowired
    AlumnosService alumnosService;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola Mundo";
    }

    @GetMapping("/listarAlumnos")
    public List<AlumnosEntity> listarAlumnos() {
        return alumnosService.findAll();
    }

    @PostMapping("/crearAlumno")
    public AlumnosEntity crearAlumno(@RequestBody AlumnosEntity nuevoAlumno) {
        return alumnosService.save(nuevoAlumno);
    }

    @PutMapping("/actualizarAlumno")
    public AlumnosEntity actualizarAlumno(@RequestBody AlumnosEntity alumno) {
        return alumnosService.update(alumno);
    }


}
