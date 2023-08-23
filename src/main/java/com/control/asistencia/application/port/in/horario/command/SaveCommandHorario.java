package com.control.asistencia.application.port.in.horario.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandHorario {
    private int idHorario;

    @NotBlank(message = "Hora Inicio no válido: Hora Inicio vacío")
    @NotNull(message = "Hora Inicio no válido: la Hora Inicio es NULL")
    private String horaInicio;

    @NotBlank(message = "Hora Final no válido: Hora Final vacío")
    @NotNull(message = "Hora Final no válido: la Hora Final es NULL")
    private String horaFin;

    @Min(value = 1, message = "IdDia no valido: idDia debe ser mayor a 0")
    private int idDia;

    @Min(value = 1, message = "IdTurno no valido: idTurno debe ser mayor a 0")
    private int idTurno;
}
