package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
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
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private int idTurno;
    @NotEmpty(message ="no puede estar vacio")
    @Size(min=2, max=8, message="el tamaño tiene que estar entre 2 y 8")
    @Column(nullable = false)
    private String nombre;
}
