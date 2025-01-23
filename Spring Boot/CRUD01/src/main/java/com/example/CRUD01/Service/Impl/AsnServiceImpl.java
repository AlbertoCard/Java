package com.example.CRUD01.Service.Impl;

import com.example.CRUD01.Entities.Asn;
import com.example.CRUD01.Repository.AsnRepository;
import com.example.CRUD01.Service.AsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Asn> findAll() {
        return asnRepository.findAll();
    }

    @Override
    public Asn actualizarAsn(Asn asn) {
        Optional<Asn> asnOptional = asnRepository.findById(asn.getAsnReference());
        if(asn.getAsnTypeCode() != null){
            asnOptional.get().setAsnTypeCode(asn.getAsnTypeCode());
        }
        if(asn.getCustomsPetition() != null){
            asnOptional.get().setCustomsPetition(asn.getCustomsPetition());
        }
        if(asn.getDataTimestamp() != null){
            asnOptional.get().setDataTimestamp(asn.getDataTimestamp());
        }
        if(asn.getDestinationBussinessUnitId() != null){
            asnOptional.get().setDestinationBussinessUnitId(asn.getDestinationBussinessUnitId());
        }
        this.asnRepository.save(asnOptional.get());

        return asnOptional.get();
    }

    @Override
    public String eliminarAsn(Long asnReference) {
        asnRepository.deleteById(asnReference);
        return "Se elimino el asn con referencia: " + asnReference;
    }


}
