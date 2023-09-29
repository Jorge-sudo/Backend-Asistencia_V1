package com.control.asistencia.application.port.in.asistencia.command;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandAsistencia {

    private int idAsistencia;

    @NotNull(message = "Hora entrada no válido: la Hora entrada es NULL")
    private Time horaEntrada;

    private Integer cantidadEstudiantes;

    @NotNull(message = "Fecha entrada no válido: la Fecha es NULL")
    private Date fecha;

    @Size(min=2, max=20, message="Estado entrada no válido: el tamaño tiene que estar entre 2 y 20")
    @NotBlank(message = "Estado entrada no válido: estado vacío")
    @NotNull(message = "Estado entrada no válido: la estado es NULL")
    private String estado;

    @NotNull(message = "idAula no válido: el idAula es NULL")
    @Min(value = 1, message = "idAula no válido: el tamaño minimo es 1")
    private int idAula;

    @NotNull(message = "idHorarioMateriaDocente no válido: el idHorarioMateriaDocente es NULL")
    @Min(value = 1, message = "idHorarioMateriaDocente no válido: el tamaño minimo es 1")
    private int idHorarioMateriaDocente;
}
