package com.control.asistencia.application.port.in.supervisor.command;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandSupervisor {
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    @NotNull(message = "CI no válido: el CI es NULL")
    private long ci;

    @Size(min=3, max=30, message="Nombre no válido: el tamaño tiene que estar entre 3 y 30")
    @NotBlank(message = "Nombre no válido: nombre vacío")
    @NotNull(message = "Nombre no válido: el nombre es NULL")
    private String nombre;

    @Size(min=3, max=30, message="Apellido no valido: el tamaño tiene que estar entre 3 y 30")
    @NotBlank(message = "Apellido no válido: apellido vacío")
    @NotNull(message = "Apellido no válido: el apellido es NULL")
    private String apellido;

    private String fotografia;

    @Email(message = "Email no válido: El formato no es valido")
    @NotBlank(message = "Email no válido: Email vacío")
    @NotNull(message = "Email no válido: el Email es NULL")
    private String email;

    @Size(min=1, max=1, message="Genero no válido: el tamaño tiene que estar entre 1 y 1")
    @NotBlank(message = "Genero no válido: genero vacío")
    @NotNull(message = "Genero no válido: el genero es NULL")
    private String genero;

    @Email(message = "Correo institucional no valido: El formato no es valido")
    @NotBlank(message = "Correo Institucional no válido: Correo Institucional vacío")
    @NotNull(message = "Correo Institucional no válido: el Correo Institucional es NULL")
    private String correoInstitucional;

    @Size(min=2, max=200, message="Contrasenia no valida: el tamaño tiene que estar entre 2 y 200")
    @NotBlank(message = "Contrasenia no válido: Contrasenia vacío")
    @NotNull(message = "Contrasenia no válido: la Contrasenia es NULL")
    private String contrasenia;

    private boolean activo;

    @Min(value = 1, message = "el rol no puede ser menor a 1")
    @Max(value = 3, message = "el rol no puede ser mayor a 3")
    private int  rol;
    private boolean reporteEmail;
    private boolean reporteInstitucional;
}
