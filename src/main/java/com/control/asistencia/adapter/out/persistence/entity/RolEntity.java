package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;
    @Size(min=2, max=15, message="el tamaño tiene que estar entre 2 y 15")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    public RolEntity() {
    }

}
