package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "asistencia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private int idAsistencia;

    @NotNull(message = "Hora entrada no válido: la Hora entrada es NULL")
    @Column(name = "hora_entrada", nullable = false)
    private Time horaEntrada;

    private Integer cantidadEstudiantes;

    @NotNull(message = "Fecha entrada no válido: la Fecha es NULL")
    private Date fecha;

    @Size(min=2, max=20, message="Estado entrada no válido: el tamaño tiene que estar entre 2 y 20")
    @NotBlank(message = "Estado entrada no válido: estado vacío")
    @NotNull(message = "Estado entrada no válido: la estado es NULL")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idAula",nullable = false)
    private AulaEntity aula;

    @ManyToOne
    @JoinColumn(name = "id_horario_materia_docente", nullable = false)
    private HorarioMateriaDocenteEntity horarioMateriaDocente;

}
