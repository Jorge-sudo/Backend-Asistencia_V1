package com.control.asistencia.application.port.in.licencia.command;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandSaveOrViewLicencia {

    private int id;

    @Temporal(TemporalType.DATE)
    @FutureOrPresent(message = "Fecha Solicitud no válido: la Fecha Solicitud es menor a la fecha actual")
    @NotNull(message = "Fecha Inicio no válido: la Fecha Inicio es NULL")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Future(message = "Fecha Solicitud no válido: la Fecha Solicitud es menor a la fecha actual")
    @NotNull(message = "Fecha Final no válido: la Fecha Final es NULL")
    private Date fechaFinal;

    @Size(min=2, max=1000, message="Descripción no válido: el tamaño tiene que estar entre 2 y 1000")
    @NotBlank(message = "Descripción no válido: Descripción vacío")
    @NotNull(message = "Descripción no válido: la Descripción es NULL")
    private String descripcion;
}
