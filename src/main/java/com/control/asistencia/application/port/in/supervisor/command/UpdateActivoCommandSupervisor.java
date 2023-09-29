package com.control.asistencia.application.port.in.supervisor.command;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateActivoCommandSupervisor {
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @NotNull(message = "CI no válido: el CI es NULL")
    private Long ci;
    private boolean activo;
}
