package com.example.multi_datasource.Service.Mydb.Impl;

import com.example.multi_datasource.Entities.Mydb.AsnEntity;
import com.example.multi_datasource.Repository.Mydb.AsnRepository;
import com.example.multi_datasource.Service.Mydb.AsnService;
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
    public AsnEntity crearAsn(AsnEntity asn) {
        return asnRepository.save(asn);
    }

    @Override
    public List<AsnEntity> findAll() {
        return asnRepository.findAll();
    }

    @Override
    public AsnEntity actualizarAsn(AsnEntity asn) {
        Optional<AsnEntity> asnOptional = asnRepository.findById(asn.getAsnReference());
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
