package com.control.asistencia.adapter.out.persistence.entity;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Data
@Table(name = "materia_carrera_semestre")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MateriaCarreraSemestreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_carrera_semestre")
    private int idMateriaCarreraSemestre;

    @ManyToOne
    @JoinColumn(name = "id_carrera", nullable = false)
    private CarreraEntity carrera;
    /* @JsonBackReference se utiliza en la entidad hija para indicar que la relacion es inversa
     * y que no debe ser serializada si no se hace esto habra un ciclo infinito y un desborde de memoria  */
    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sigla", nullable = false)
    private MateriaEntity materia;

    @ManyToOne
    @JoinColumn(name = "id_semestre", nullable = false)
    private SemestreEntity semestre;

    private boolean activo;

}
