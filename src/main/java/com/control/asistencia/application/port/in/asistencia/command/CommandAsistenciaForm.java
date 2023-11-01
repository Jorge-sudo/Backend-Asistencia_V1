package com.control.asistencia.application.port.in.asistencia.command;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandAsistenciaForm {
    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @NotNull(message = "CI no válido: el CI es NULL")
    @Min(value = 1, message = "CI no válido: el CI es menor a 1")
    private long ci;
    @Min(value = 1, message = "ID Aula no válido: el ID Aula es menor a 1")
    private int idAula;
    private int cantidadEstudiantes;
}
