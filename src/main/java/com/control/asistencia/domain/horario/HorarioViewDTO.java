package com.control.asistencia.domain.horario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioViewDTO {
    private int idHorario;
    private String horaInicio;
    private String horaFin;
    private String diaSemana;
    private String turno;
}
