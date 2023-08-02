package com.control.asistencia.application.port.in.commandGeneric;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommandGeneric {
    private Integer id;

    @Size(min=3, max=50, message="Nombre no válido: el tamaño tiene que estar entre 3 y 50")
    @NotBlank(message = "Nombre no válido: nombre vacío")
    @NotNull(message = "Nombre no válido: el nombre es NULL")
    private String nombre;
}
