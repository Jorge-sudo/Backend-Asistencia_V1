package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "dia_semana")
public class DiaSemanaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dia")
    private int idDia;
    @Size(min=2, max=10, message="el tamaño tiene que estar entre 2 y 10")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String nombre;
}
