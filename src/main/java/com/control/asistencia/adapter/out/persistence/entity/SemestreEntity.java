package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "semestre")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemestreEntity {
    @Id
    @Column(name = "id_semestre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSemestre;

    @Size(min=2, max=10, message="Nombre Semestre no válido: el tamaño tiene que estar entre 2 y 10")
    @NotBlank(message = "Nombre Semestre no válido: Nombre Semestre vacío")
    @NotNull(message = "Nombre Semestre no válido: el Nombre Semestre es NULL")
    private String nombre;
}
