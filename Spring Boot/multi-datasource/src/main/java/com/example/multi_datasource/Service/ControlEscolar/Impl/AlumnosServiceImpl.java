package com.example.multi_datasource.Service.ControlEscolar.Impl;

import com.example.multi_datasource.Entities.ControlEscolar.AlumnosEntity;
import com.example.multi_datasource.Repository.ControlEscolar.AlumnosRepository;
import com.example.multi_datasource.Service.ControlEscolar.AlumnosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    private final AlumnosRepository alumnosRepository;

    public AlumnosServiceImpl(AlumnosRepository alumnosRepository) {
        this.alumnosRepository = alumnosRepository;
    }

    @Override
    public AlumnosEntity save(AlumnosEntity nuevoAlumno) {

        nuevoAlumno.setNombres(nuevoAlumno.getNombres().toUpperCase());
        nuevoAlumno.setApellidos(nuevoAlumno.getApellidos().toUpperCase());
        nuevoAlumno.setCarrera(nuevoAlumno.getCarrera().toUpperCase());


        return alumnosRepository.save(nuevoAlumno);
    }

    @Override
    public List<AlumnosEntity> findAll() {
        return alumnosRepository.findAll();
    }

    @Override
    public AlumnosEntity update(AlumnosEntity alumno) {
        if(alumno==null || alumno.getNcontrol()==null){
            return null;
        }
        Optional<AlumnosEntity> alumnoExistente = alumnosRepository.findById(alumno.getNcontrol());

        if(alumnoExistente.isEmpty()){
            return null;
        }

        alumno.setNombres(alumno.getNombres().toUpperCase());
        alumno.setApellidos(alumno.getApellidos().toUpperCase());
        alumno.setCarrera(alumno.getCarrera().toUpperCase());

        alumnoExistente.get().setNombres(alumno.getNombres());
        alumnoExistente.get().setApellidos(alumno.getApellidos());
        alumnoExistente.get().setCarrera(alumno.getCarrera());
        alumnoExistente.get().setFecha_nacimiento(alumno.getFecha_nacimiento());

        return alumnosRepository.save(alumnoExistente.get());
    }
}
