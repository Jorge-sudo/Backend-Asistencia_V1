package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "carrera")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarreraEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;

    @Size(min=2, max=50, message="Nombre Carrera entrada no válido: el tamaño tiene que estar entre 2 y 50")
    @NotBlank(message = "Nombre Carrera entrada no válido: nombre carrera es vacío")
    @NotNull(message = "Nombre Carrera no válido: el nombre de la carrera es NULL")
    private String nombre;
}
