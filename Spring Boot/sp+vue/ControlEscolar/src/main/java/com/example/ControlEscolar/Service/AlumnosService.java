package com.example.ControlEscolar.Service;

import com.example.ControlEscolar.Entities.AlumnosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlumnosService {

    AlumnosEntity save(AlumnosEntity nuevoAlumno);
    List<AlumnosEntity> findAll();
    AlumnosEntity update(AlumnosEntity alumno);
}
