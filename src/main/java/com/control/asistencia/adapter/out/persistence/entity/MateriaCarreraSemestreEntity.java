package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@Entity
@Data
@Table(name = "materia_carrera_semestre")
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @NotNull(message ="no puede estar vacio")
    private boolean activo;

    public MateriaCarreraSemestreEntity(
              Optional<CarreraEntity> carreraEntity
            , Optional<MateriaEntity> materiaEntity
            , Optional<SemestreEntity> semestreEntity
            , boolean activo) {

        this.carrera = carreraEntity.orElse(null);
        this.materia = materiaEntity.orElse(null);
        this.semestre = semestreEntity.orElse(null);
        this.activo = activo;

    }

    public MateriaCarreraSemestreEntity(
                int idMateriaCarreraSemestre,
            Optional<CarreraEntity> carreraEntity
            , Optional<MateriaEntity> materiaEntity
            , Optional<SemestreEntity> semestreEntity
            , boolean activo) {

        this.idMateriaCarreraSemestre = idMateriaCarreraSemestre;
        this.carrera = carreraEntity.orElse(null);
        this.materia = materiaEntity.orElse(null);
        this.semestre = semestreEntity.orElse(null);
        this.activo = activo;

    }
}
