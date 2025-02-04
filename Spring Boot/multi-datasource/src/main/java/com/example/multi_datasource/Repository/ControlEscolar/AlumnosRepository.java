package com.example.multi_datasource.Repository.ControlEscolar;

import com.example.multi_datasource.Entities.ControlEscolar.AlumnosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnosEntity, String> {
}
