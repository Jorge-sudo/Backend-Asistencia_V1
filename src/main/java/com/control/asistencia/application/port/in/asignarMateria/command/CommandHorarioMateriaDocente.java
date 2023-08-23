package com.control.asistencia.application.port.in.asignarMateria.command;

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
public class CommandHorarioMateriaDocente {

    @JsonIgnore
    private int idHorarioMateriaDocente;

    private boolean laboratorio;

    private int nroLaboratorio;

    @Digits(integer=6, fraction=0, message="idAula no valido: No se permite decimales y maximo de digitos es 6.")
    @Min(value = 1, message = "idAula no valido: Debe ser mayor a 0.")
    private int idHorario;

    @JsonIgnore
    private int idMateriaDocente;
}
