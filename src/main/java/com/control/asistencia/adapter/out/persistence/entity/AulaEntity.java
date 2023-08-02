package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "aula")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int idAula;

    @Size(min=2, max=5, message="Aula entrada no válido: el tamaño tiene que estar entre 2 y 5")
    @NotBlank(message = "Aula entrada no válido: aula vacío")
    @NotNull(message = "Aula entrada no válido: la aula es NULL")
    private String aula;

    @Size(min=2, max=10, message="Paralelo entrada no válido: el tamaño tiene que estar entre 2 y 10")
    @NotBlank(message = "Paralelo entrada no válido: paralelo vacío")
    @NotNull(message = "Paralelo entrada no válido: la paralelo es NULL")
    private String paralelo;

    @Size(min=2, max=5, message="Piso entrada no válido: el tamaño tiene que estar entre 2 y 5")
    @NotBlank(message = "Piso entrada no válido: piso vacío")
    @NotNull(message = "Piso entrada no válido: la piso es NULL")
    private String piso;

    @Size( max=2, message="Bloque entrada no válido: el tamaño maximo es 2")
    @NotBlank(message = "Bloque entrada no válido: bloque vacío")
    @NotNull(message = "Bloque entrada no válido: la bloque es NULL")
    private String bloque;

}
