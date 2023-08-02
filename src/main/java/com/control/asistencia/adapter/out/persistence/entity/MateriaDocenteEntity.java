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

}
