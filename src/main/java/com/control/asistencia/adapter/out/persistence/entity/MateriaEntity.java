package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "materia")
public class MateriaEntity {
    @Id
    @Size(min=2, max=10, message="el tamaño tiene que estar entre 2 y 10")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String sigla;

    @Size(min=2, max=100, message="el tamaño tiene que estar entre 2 y 100")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    /*@JsonManagedReference  se utiliza en la entidad padre para indicar que la relacion es administrada
     o manejada por esa entidad si no se hace esto habra un ciclo infinito y un desborde de memoria
    @JsonManagedReference
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<MateriaCarrera> materiaCarreras;*/

    public MateriaEntity() {
    }

}
