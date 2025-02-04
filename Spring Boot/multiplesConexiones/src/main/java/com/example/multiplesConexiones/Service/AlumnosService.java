package com.example.multiplesConexiones.Service;

import com.example.multiplesConexiones.Entities.ControlEscolar.AlumnosEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlumnosService {

    AlumnosEntity save(AlumnosEntity nuevoAlumno);
    List<AlumnosEntity> findAll();
    AlumnosEntity update(AlumnosEntity alumno);
}
