package com.example.ControlEscolar.Repository;

import com.example.ControlEscolar.Entities.AlumnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnosEntity, String> {
}
