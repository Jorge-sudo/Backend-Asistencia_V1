package com.control.asistencia.application.port.in.asistencia.command;

import com.control.asistencia.application.port.in.assignMateria.command.CommandHorarioMateriaDocente;
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

    @NotBlank(message = "Hora entrada no válido: Hora entrada vacío")
    @NotNull(message = "Hora entrada no válido: la Hora entrada es NULL")
    private Time horaEntrada;

    //@Digits(integer=3, fraction=0, message="No se permite decimales y maximo de digitos es 3.")
    private Integer cantidadEstudiantes;

    @NotBlank(message = "Fecha entrada no válido: Fecha vacío")
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
