package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Data
@Table(name = "horario")
public class HorarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int idHorario;
    @Column(name = "hora_inicio", nullable = false)
    private Time horaInicio;

    @Column(name = "hora_fin",nullable = false)
    private Time horaFin;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dia",nullable = false)
    private DiaSemanaEntity diaSemana;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_turno", nullable = false)
    private TurnoEntity turno;


    public HorarioEntity(){
    }

}
