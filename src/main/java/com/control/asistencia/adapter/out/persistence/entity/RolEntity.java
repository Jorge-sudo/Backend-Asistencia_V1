package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Size(min=2, max=15, message="Nombre Rol no válido: el tamaño tiene que estar entre 2 y 15")
    @NotBlank(message = "Nombre Rol no válido: Nombre Rol vacío")
    @NotNull(message = "Nombre Rol no válido: el Nombre Rol es NULL")
    private String nombre;
}
