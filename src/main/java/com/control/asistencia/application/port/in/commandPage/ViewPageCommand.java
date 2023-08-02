package com.control.asistencia.application.port.in.commandPage;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPageCommand {
    @Min(value = 0, message = "Numero de pagina debe comenzar de 0")
    private int page;
    @Min(value = 1, message = "Tamaño de pagina debe ser mayor a 0")
    private int size;
    private String sortBy;
}
