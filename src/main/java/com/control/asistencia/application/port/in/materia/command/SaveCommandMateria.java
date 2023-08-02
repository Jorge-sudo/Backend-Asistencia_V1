package com.control.asistencia.application.port.in.materia.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandMateria {

    @Size(min=3, max=10, message="Sigla no válido: el tamaño tiene que estar entre 3 y 10")
    @NotBlank(message = "Sigla no válido: Sigla vacío")
    @NotNull(message = "Sigla no válido: el Sigla es NULL")
    private String sigla;

    @Size(min=3, max=50, message="Nombre no válido: el tamaño tiene que estar entre 3 y 50")
    @NotBlank(message = "Nombre no válido: nombre vacío")
    @NotNull(message = "Nombre no válido: el nombre es NULL")
    private String nombre;
}
