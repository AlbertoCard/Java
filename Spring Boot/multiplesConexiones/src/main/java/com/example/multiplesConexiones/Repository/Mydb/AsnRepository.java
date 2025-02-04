package com.example.multiplesConexiones.Repository.Mydb;

import com.example.multiplesConexiones.Entities.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsnRepository extends JpaRepository<Asn, Long> {
}
