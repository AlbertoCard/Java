package com.example.multiplesConexiones.Repository.ControlEscolar;

import com.example.multiplesConexiones.Entities.ControlEscolar.AlumnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnosEntity, String> {
}
