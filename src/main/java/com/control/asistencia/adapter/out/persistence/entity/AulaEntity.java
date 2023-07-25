package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "aula")
public class AulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int idAula;
    @Size(min=2, max=5, message="el tamaño tiene que estar entre 2 y 5")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String aula;
    @Size(min=2, max=10, message="el tamaño tiene que estar entre 2 y 10")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String paralelo;
    @Size(min=2, max=5, message="el tamaño tiene que estar entre 2 y 5")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String piso;
    @Size( max=2, message="el tamaño maximo es 2")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String bloque;

    public AulaEntity(){

    }

    public AulaEntity(int idAula, String aula, String paralelo, String piso, String bloque) {
        this.idAula = idAula;
        this.aula = aula;
        this.paralelo = paralelo;
        this.piso = piso;
        this.bloque = bloque;
    }
}
