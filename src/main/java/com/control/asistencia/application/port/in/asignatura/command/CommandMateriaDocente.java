package com.control.asistencia.application.port.in.asignatura.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandMateriaDocente {
    @JsonIgnore
    private int idMateriaDocente;

    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @Min(value = 10000, message = "CI no válido: el tamaño minimo es 5")
    private long ci;

    @Min(value = 1, message = "El id de la materia no puede ser menor a 1")
    private int idMateriaCarreraSemestre;
}
