package com.control.asistencia.domain.horarioMateriaDocente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioMateriaDocenteDTO {
    private int idHorarioMateriaDocente;
    private Integer nroLaboratorio;
    private boolean laboratorio;
    private Time horaInicio;
    private Time horaFin;
    private String dia;
    private String turno;
    private String sigla;
    private String materia;
    private String nombreDocente;
    private String apellidoDocente;
}
