package com.control.asistencia.application.port.in.persona.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePasswordPersona {
    private long ci;
    @Size(min=2, max=200, message="Contrasenia no valida: el tamaño tiene que estar entre 2 y 200")
    @NotBlank(message = "Contrasenia no válido: Contrasenia vacío")
    @NotNull(message = "Contrasenia no válido: la Contrasenia es NULL")
    private String contrasenia;
    @Size(min=2, max=200, message="Contrasenia no valida: el tamaño tiene que estar entre 2 y 200")
    @NotBlank(message = "Contrasenia no válido: Contrasenia vacío")
    @NotNull(message = "Contrasenia no válido: la Contrasenia es NULL")
    private String contraseniaNueva;
}
