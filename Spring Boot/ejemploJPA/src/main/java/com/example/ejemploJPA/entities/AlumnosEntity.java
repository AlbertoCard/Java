package com.example.ejemploJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos_entity")
public class AlumnosEntity {
    @Id
    private Integer id;

    @Column(name = "nombre" , nullable = false)
    private String nombre;
}
