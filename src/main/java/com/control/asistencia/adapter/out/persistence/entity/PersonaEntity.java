package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PersonaEntity {

    @Id
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @Column(unique = true)
    private Long ci ;

    @Size(min=3, max=30, message="Nombre no válido: el tamaño tiene que estar entre 3 y 30")
    @NotBlank(message = "Nombre no válido: nombre vacío")
    @NotNull(message = "Nombre no válido: el nombre es NULL")
    private String nombre;

    @Size(min=3, max=30, message="Apellido no valido: el tamaño tiene que estar entre 3 y 30")
    @NotBlank(message = "Apellido no válido: apellido vacío")
    @NotNull(message = "Apellido no válido: el apellido es NULL")
    private String apellido;

    @Nullable
    private String fotografia;

    @Email(message = "Email no válido: El formato no es valido")
    @NotBlank(message = "Email no válido: Email vacío")
    @NotNull(message = "Email no válido: el Email es NULL")
    @Column(unique = true)
    private String email;

    @Size(min=1, max=1, message="Genero no válido: el tamaño tiene que estar entre 1 y 1")
    @NotBlank(message = "Genero no válido: genero vacío")
    @NotNull(message = "Genero no válido: el genero es NULL")
    private String genero;

    @Email(message = "Correo institucional no valido: El formato no es valido")
    @NotBlank(message = "Correo Institucional no válido: Correo Institucional vacío")
    @NotNull(message = "Correo Institucional no válido: el Correo Institucional es NULL")
    @Column(name = "correo_institucional")
    private String correoInstitucional;

    @Size(min=2, max=200, message="Contrasenia no valida: el tamaño tiene que estar entre 2 y 200")
    @NotBlank(message = "Contrasenia no válido: Contrasenia vacío")
    @NotNull(message = "Contrasenia no válido: la Contrasenia es NULL")
    private String contrasenia;

    private boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;
}
