package com.control.asistencia.application.port.in.asistencia.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandPageAsistencia {
    @Min(value = 1, message = "idCarrera no válido: el tamaño minimo es 1")
    private int idCarrera;
    @Min(value = 1, message = "idSemestre no válido: el tamaño minimo es 1")
    private int idSemestre;
    private String globalFilter;
    @NotNull(message = "dateSearch no válido: el dateSearch es NULL")
    @NotBlank(message = "dateSearch no válido: dateSearch vacío")
    @NotEmpty(message = "dateSearch no válido: dateSearch vacío")
    private String dateSearch;
}
