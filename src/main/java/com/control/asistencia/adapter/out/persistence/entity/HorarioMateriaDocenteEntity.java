package com.control.asistencia.adapter.out.persistence.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "horario_materia_docente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioMateriaDocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_materia_docente")
    private int idHorarioMateriaDocente;

    @Column(name = "nro_laboratorio", nullable = true)
    private Integer nroLaboratorio;

    @NotBlank(message = "Laboratorio entrada no válido: Laboratorio vacío")
    @NotNull(message = "Laboratorio entrada no válido: la Laboratorio es NULL")
    @Column(name = "laboratorio", nullable = false)
    private boolean laboratorio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_horario", nullable = false)
    private HorarioEntity horario;

    //@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_materia_docente", nullable = false)
    private MateriaDocenteEntity materiaDocente;
}
