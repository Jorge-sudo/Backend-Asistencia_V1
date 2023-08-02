package com.control.asistencia.adapter.out.persistence.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "turno")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private int idTurno;

    @Size(min=2, max=8, message="Nombre Turno no válido: el tamaño tiene que estar entre 2 y 8")
    @NotBlank(message = "Nombre Turno no válido: Nombre Turno vacío")
    @NotNull(message = "Nombre Turno no válido: el Nombre Turno es NULL")
    @Column(nullable = false)
    private String nombre;
}
