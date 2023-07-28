package com.control.asistencia.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {
    @Id
    @Digits(integer=11, fraction=0, message="No se permite decimales y maximo de digitos es 10.")
    @Column(name = "ci", nullable = false)
    private long ci ;
    @Size(min=2, max=25, message="el tamaño tiene que estar entre 2 y 25")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String nombre;
    @Size(min=2, max=25, message="el tamaño tiene que estar entre 2 y 25")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String apellido;

    @Nullable
    private String fotografia;
    @Email(message = "el correo no es valido")
    @Size(min=2, max=50, message="el tamaño tiene que estar entre 2 y 50")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String email;
    @Size(min=1, max=1, message="el tamaño tiene que estar entre 1 y 1")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String genero;
    @Size(min=2, max=50, message="el tamaño tiene que estar entre 2 y 50")
    @NotEmpty(message ="no puede estar vacio")
    @Column(name = "correo_institucional", nullable = false)
    private String correoInstitucional;
    @Size(min=2, max=200, message="el tamaño tiene que estar entre 2 y 200")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String contrasenia;
    @NotNull(message ="no puede estar vacio")
    private boolean activo;

    /*@JsonManagedReference  se utiliza en la entidad padre para indicar que la relacion es administrada
     o manejada por esa entidad si no se hace esto habra un ciclo infinito y un desborde de memoria*/

    @JsonManagedReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PersonaRolEntity> personaRoles;
}
