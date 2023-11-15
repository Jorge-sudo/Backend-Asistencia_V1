package com.control.asistencia.application.port.in.supervisor.command;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePerfilCommandSupervisor {

    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @NotNull(message = "CI no válido: el CI es NULL")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    private long ci;

    @Email(message = "Email no válido: El formato no es valido")
    @NotBlank(message = "Email no válido: Email vacío")
    @NotNull(message = "Email no válido: el Email es NULL")
    private String email;
    private boolean activo;
    private boolean reporteEmail;
    private boolean reporteInstitucional;
}
