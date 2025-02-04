package com.example.multi_datasource.Entities.Mydb;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asn")
public class AsnEntity {
    @Id
    @Column(name = "asn_reference", length = 40)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asnReference;

    @Column(name = "asn_type_code", nullable = false)
    private Integer asnTypeCode;

    @Column(name = "customs_petition", nullable = false)
    private Integer customsPetition;

    @Column(name = "data_timestamp", nullable = false, columnDefinition = "TIMESTAMP(6) WITHOUT TIME ZONE")
    private LocalDateTime dataTimestamp;

    @Column(name = "destination_bussiness_unit_id", nullable = false)
    private Integer destinationBussinessUnitId;

    public Long getAsnReference() {
        return asnReference;
    }

    public void setAsnReference(Long asnReference) {
        this.asnReference = asnReference;
    }

    public Integer getAsnTypeCode() {
        return asnTypeCode;
    }

    public void setAsnTypeCode(Integer asnTypeCode) {
        this.asnTypeCode = asnTypeCode;
    }

    public Integer getCustomsPetition() {
        return customsPetition;
    }

    public void setCustomsPetition(Integer customsPetition) {
        this.customsPetition = customsPetition;
    }

    public LocalDateTime getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(LocalDateTime dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    public Integer getDestinationBussinessUnitId() {
        return destinationBussinessUnitId;
    }

    public void setDestinationBussinessUnitId(Integer destinationBussinessUnitId) {
        this.destinationBussinessUnitId = destinationBussinessUnitId;
    }

}
