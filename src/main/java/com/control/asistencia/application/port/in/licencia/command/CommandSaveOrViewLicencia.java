package com.control.asistencia.application.port.in.licencia.command;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandSaveOrViewLicencia {

    private int id;

    @Future(message = "La fecha de inicio debe ser futura")
    @NotBlank(message = "Fecha Inicio  no válido: Fecha Inicio vacío")
    @NotNull(message = "Fecha Inicio  no válido: la Fecha Inicio es NULL")
    private Date fechaInicio;

    @Future(message = "La fecha de inicio debe ser futura")
    @NotBlank(message = "Fecha Inicio  no válido: Fecha Inicio vacío")
    @NotNull(message = "Fecha Inicio  no válido: la Fecha Inicio es NULL")
    private Date fechaFinal;

    @Size(min=2, max=1000, message="Descripción no válido: el tamaño tiene que estar entre 2 y 1000")
    @NotBlank(message = "Descripción no válido: Descripción vacío")
    @NotNull(message = "Descripción no válido: la Descripción es NULL")
    private String descripcion;
}
