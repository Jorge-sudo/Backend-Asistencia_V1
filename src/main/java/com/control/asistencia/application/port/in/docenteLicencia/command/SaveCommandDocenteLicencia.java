package com.control.asistencia.application.port.in.docenteLicencia.command;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandDocenteLicencia {
    private int idDocenteLicencia;
    @NotNull(message = "CI no válido: el CI es NULL")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    private int idLicencia;
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @NotNull(message = "CI no válido: el CI es NULL")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    private Long ci;
}
