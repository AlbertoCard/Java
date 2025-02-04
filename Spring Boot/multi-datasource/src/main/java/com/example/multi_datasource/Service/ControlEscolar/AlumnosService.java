package com.example.multi_datasource.Service.ControlEscolar;

import com.example.multi_datasource.Entities.ControlEscolar.AlumnosEntity;

import java.util.List;

public interface AlumnosService {

    AlumnosEntity save(AlumnosEntity nuevoAlumno);
    List<AlumnosEntity> findAll();
    AlumnosEntity update(AlumnosEntity alumno);
}
