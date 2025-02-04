package com.example.multi_datasource.Repository.Mydb;

import com.example.multi_datasource.Entities.Mydb.AsnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsnRepository extends JpaRepository<AsnEntity, Long> {
}
