package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "materia_docente")
public class MateriaDocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_docente")
    private int idMateriaDocente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sigla", nullable = false)
    private MateriaEntity materia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci", nullable = false)
    private DocenteEntity docente;

    /*
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaDocente")
    private List<AulaMateriaDocente> aulaMateriaDocentes;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaDocente")
    private List<HorarioMateriaDocente> horarioMateriaDocentes; */

    public MateriaDocenteEntity(){

    }

}
