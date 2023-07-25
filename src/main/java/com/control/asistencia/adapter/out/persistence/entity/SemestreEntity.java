package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "semestre")
public class SemestreEntity {
    @Id
    @Column(name = "id_semestre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSemestre;
    @Size(min=2, max=10, message="el tamaño tiene que estar entre 2 y 10")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String semestre;

    public SemestreEntity (){

    }
}
