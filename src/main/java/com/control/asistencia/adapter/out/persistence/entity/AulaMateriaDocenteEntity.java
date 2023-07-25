package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "aula_materia_docente")
public class AulaMateriaDocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula_materia_docente")
    private int idAulaMateriaDocente;
    //@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_materia_docente", nullable = false)
    private MateriaDocenteEntity materiaDocente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aula", nullable = false)
    private AulaEntity aula;

    public AulaMateriaDocenteEntity(){
    }
}
