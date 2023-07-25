package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "carrera")
public class CarreraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;
    @Size(min=2, max=50, message="el tamaño tiene que estar entre 2 y 50")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false, unique = true)
    private String nombre;

    public CarreraEntity(){

    }


}
