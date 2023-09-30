package com.control.asistencia.application.port.in.materiaCarreraSemestre.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateActivoCommandMateriaCarreraSemestre {

    @NotNull(message = "IdMateriaCarreraSemestre no válido: el idMateriaCarreraSemestre es NULL")
    @Min(value = 1, message = "IdMateriaCarreraSemestre no válido: el idMateriaCarreraSemestre es menor a 1")
    private int idMateriaCarreraSemestre;
    private boolean activo;
}
