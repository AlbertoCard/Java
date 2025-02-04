package com.example.multi_datasource.Service.Mydb;

import com.example.multi_datasource.Entities.Mydb.AsnEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsnService {

    AsnEntity crearAsn(AsnEntity asn);
    List<AsnEntity> findAll();
    AsnEntity actualizarAsn(AsnEntity asn);
    String eliminarAsn(Long asnReference);
}
