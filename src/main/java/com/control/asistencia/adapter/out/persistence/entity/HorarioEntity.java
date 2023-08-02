package com.control.asistencia.adapter.out.persistence.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Data
@Table(name = "horario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int idHorario;

    @NotBlank(message = "Hora Inicio no válido: Hora Inicio vacío")
    @NotNull(message = "Hora Inicio no válido: la Hora Inicio es NULL")
    @Column(name = "hora_inicio", nullable = false)
    private Time horaInicio;

    @NotBlank(message = "Hora Final no válido: Hora Final vacío")
    @NotNull(message = "Hora Final no válido: la Hora Final es NULL")
    @Column(name = "hora_fin",nullable = false)
    private Time horaFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dia",nullable = false)
    private DiaSemanaEntity diaSemana;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno", nullable = false)
    private TurnoEntity turno;
}
