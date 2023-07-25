package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "materia_carrera_semestre")
public class MateriaCarreraSemestreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_carrera_semestre")
    private int idMateriaCarrera;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrera", nullable = false)
    private CarreraEntity carrera;
    /* @JsonBackReference se utiliza en la entidad hija para indicar que la relacion es inversa
     * y que no debe ser serializada si no se hace esto habra un ciclo infinito y un desborde de memoria  */
    //@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sigla", nullable = false)
    private MateriaEntity materia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_semestre", nullable = false)
    private SemestreEntity semestre;
    @NotNull(message ="no puede estar vacio")
    private boolean activo;

    public MateriaCarreraSemestreEntity(){

    }
}
