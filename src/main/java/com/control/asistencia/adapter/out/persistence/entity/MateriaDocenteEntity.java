package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "materia_docente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriaDocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_docente")
    private int idMateriaDocente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_materia_carrera_semestre", nullable = false)
    private MateriaCarreraSemestreEntity materiaCarreraSemestre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci", nullable = false)
    private DocenteEntity docente;

}
