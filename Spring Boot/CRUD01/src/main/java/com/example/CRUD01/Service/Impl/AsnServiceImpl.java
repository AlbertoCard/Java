package com.example.CRUD01.Service.Impl;

import com.example.CRUD01.Entities.Asn;
import com.example.CRUD01.Repository.AsnRepository;
import com.example.CRUD01.Service.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsnServiceImpl implements AsnService {


    private final AsnRepository asnRepository;

    public AsnServiceImpl(AsnRepository asnRepository) {
        this.asnRepository = asnRepository;
    }

    @Override
    public Asn crearAsn(Asn asn) {
        return asnRepository.save(asn);
    }

}
