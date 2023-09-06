package com.control.asistencia.domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaViewDTO {
    private int idAsistencia;
    private Time horaEntrada;
    private Integer cantidadEstudiantes;
    private Date fecha;
    private String estadoAsistencia;
    private String aula;
    private String paralelo;
    private String piso;
    private String bloque;
    private Integer nroLaboratorio;
    private boolean laboratorio;
    private Time horaInicio;
    private Time horaFin;
    private String diaSemana;
    private String turno;
    private String sigla;
    private String nombreMateria;
    private String nombreDocente;
    private String apellidoDocente;
    private String base64ImagenDocente;
}
