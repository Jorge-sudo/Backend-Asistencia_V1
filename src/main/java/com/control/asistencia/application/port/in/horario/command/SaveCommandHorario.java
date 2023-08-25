package com.control.asistencia.application.port.in.horario.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandHorario {
    private int idHorario;

    @NotNull(message = "Hora Inicio no válido: la Hora Inicio es NULL")
    private Time horaInicio;

    @NotNull(message = "Hora Final no válido: la Hora Final es NULL")
    private Time horaFin;

    @Min(value = 1, message = "IdDia no valido: idDia debe ser mayor a 0")
    private int idDia;

    @Min(value = 1, message = "IdTurno no valido: idTurno debe ser mayor a 0")
    private int idTurno;
}
