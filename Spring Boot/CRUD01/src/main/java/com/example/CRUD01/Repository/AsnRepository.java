package com.example.CRUD01.Repository;

import com.example.CRUD01.Entities.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsnRepository extends JpaRepository<Asn, Long> {
}
