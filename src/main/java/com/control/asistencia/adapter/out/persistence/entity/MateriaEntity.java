package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "materia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriaEntity {
    @Id
    @Size(min=2, max=10, message="Sigla no válido: el tamaño tiene que estar entre 2 y 10")
    @NotBlank(message = "Sigla no válido: sigla vacío")
    @NotNull(message = "Sigla no válido: el sigla es NULL")
    @Column(unique = true, nullable = false)
    private String sigla;

    @Size(min=2, max=100, message="Nombre Materia no válido: el tamaño tiene que estar entre 2 y 100")
    @NotBlank(message = "Nombre Materia no válido: nombre materia vacío")
    @NotNull(message = "Nombre Materia no válido: el nombre materia es NULL")
    @Column(nullable = false)
    private String nombre;

    /*@JsonManagedReference  se utiliza en la entidad padre para indicar que la relacion es administrada
     o manejada por esa entidad si no se hace esto habra un ciclo infinito y un desborde de memoria
    @JsonManagedReference
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<MateriaCarrera> materiaCarreras;*/

}
