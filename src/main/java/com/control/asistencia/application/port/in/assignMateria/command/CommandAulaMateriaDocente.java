package com.control.asistencia.application.port.in.assignMateria.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandAulaMateriaDocente {

    @JsonIgnore
    private int idAulaMateriaDocente;

    @JsonIgnore
    @Digits(integer=6, fraction=0, message="idMateriaDocente no valido: No se permite decimales y maximo de digitos es 6.")
    @Min(value = 1, message = "idMateriaDocente no valido: Debe ser mayor a 0.")
    private int idMateriaDocente;

    @Digits(integer=6, fraction=0, message="idAula no valido: No se permite decimales y maximo de digitos es 6.")
    @Min(value = 1, message = "idAula no valido: Debe ser mayor a 0.")
    private int idAula;
}
