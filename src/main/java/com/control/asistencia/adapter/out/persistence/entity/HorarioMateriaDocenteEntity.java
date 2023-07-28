package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "horario_materia_docente")
@AllArgsConstructor
@NoArgsConstructor
public class HorarioMateriaDocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_materia_docente")
    private int idHorarioMateriaDocente;
    @Column(name = "nro_laboratorio", nullable = true)
    private Integer nroLaboratorio;
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
