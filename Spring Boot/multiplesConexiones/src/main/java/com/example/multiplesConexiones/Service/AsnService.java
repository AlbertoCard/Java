package com.example.multiplesConexiones.Service;

import com.example.multiplesConexiones.Entities.Asn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsnService {
    Asn crearAsn(Asn asn);

    List<Asn> findAll();

    Asn actualizarAsn(Asn asn);

    String eliminarAsn(Long asnReference);
}
