package com.control.asistencia.application.port.in.asignarMateria.command;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandMateriaDocente {
    @JsonIgnore
    private int idMateriaDocente;

    @Digits(integer=12, fraction=0, message="CI no valido: No se permite decimales y maximo de digitos es 12.")
    @NotNull(message = "CI no válido: el CI es NULL")
    @Min(value = 10000, message = "CI no válido: el tamaño minimo es 5")
    private long ci;

    @Size(min=3, max=6, message="Sigla no válido: el tamaño tiene que estar entre 3 y 6")
    @NotBlank(message = "Sigla no válido: Sigla vacío")
    @NotNull(message = "Sigla no válido: el Sigla es NULL")
    private String sigla;
}
