package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "dia_semana")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaSemanaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dia")
    private int idDia;

    @Size(min=2, max=10, message="Nombre diaSemana entrada no válido: el tamaño tiene que estar entre 2 y 10")
    @NotBlank(message = "Nombre diaSemana entrada no válido: nombre diaSemana es vacío")
    @NotNull(message = "Nombre diaSemana no válido: el nombre del diaSemana es NULL")
    private String nombre;
}
