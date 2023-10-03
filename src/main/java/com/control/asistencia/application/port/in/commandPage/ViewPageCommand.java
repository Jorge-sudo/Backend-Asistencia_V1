package com.control.asistencia.application.port.in.commandPage;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPageCommand {
    @Min(value = 0, message = "Numero de pagina debe comenzar de 0")
    private int page;
    @Min(value = 1, message = "Tamaño de pagina debe ser mayor a 0")
    private int size;
    private String sortField;
    private int shortOrder;
    @Nullable
    private String globalFilter;

    public ViewPageCommand(int page, int size, String sortField, int shortOrder) {
        this.page = page;
        this.size = size;
        this.sortField = sortField;
        this.shortOrder = shortOrder;
    }

    public ViewPageCommand(int page, int size, String sortField) {
        this.page = page;
        this.size = size;
        this.sortField = sortField;
    }
}
