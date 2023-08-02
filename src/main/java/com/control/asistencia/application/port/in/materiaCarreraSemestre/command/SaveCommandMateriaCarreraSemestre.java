package com.control.asistencia.application.port.in.materiaCarreraSemestre.command;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandMateriaCarreraSemestre {

    private int idMateriaCarreraSemestre;

    @Digits(integer=3, fraction=0, message="idCarrera no valido: No se permite decimales y maximo de digitos es 3.")
    private int idCarrera;

    @Size(min=3, max=6, message="Sigla no válido: el tamaño tiene que estar entre 3 y 6")
    @NotBlank(message = "Sigla no válido: Sigla vacío")
    @NotNull(message = "Sigla no válido: el Sigla es NULL")
    private String sigla;

    @Min(value = 1, message = "el idSemestre no puede ser menor a 1")
    @Max(value = 10, message = "el idSemestre no puede ser mayor a 10")
    private int idSemestre;

    private boolean activo;
}
