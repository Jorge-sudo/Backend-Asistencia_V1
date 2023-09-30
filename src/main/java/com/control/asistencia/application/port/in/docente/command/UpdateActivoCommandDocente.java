package com.control.asistencia.application.port.in.docente.command;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateActivoCommandDocente {
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    @NotNull(message = "CI no válido: el CI es NULL")
    private Long ci;
    private boolean activo;
}
