package com.example.CRUD01.Service;

import com.example.CRUD01.Entities.Asn;
import com.example.CRUD01.Repository.AsnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AsnService {

    Asn crearAsn(Asn asn);
}
