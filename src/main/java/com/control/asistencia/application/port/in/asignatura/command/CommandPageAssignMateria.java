package com.control.asistencia.application.port.in.asignatura.command;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandPageAssignMateria extends ViewPageCommand {
    private int idCarrera;
    private int idSemestre;
    private int idDia;
    private int idTurno;

    public CommandPageAssignMateria(@Min(value = 0, message = "Numero de pagina debe comenzar de 0") int page,
                                    @Min(value = 1, message = "Tamaño de pagina debe ser mayor a 0") int size,
                                    @NotNull(message = "El shortField no debe ser nulo")
                                    @NotEmpty(message = "El shortField no debe ser vació")
                                    @NotBlank(message = "El shortField no debe ser vació")
                                    String sortField,
                                    int shortOrder,
                                    String globalFilter,
                                    @Min(value = 1, message = "Tamaño de idCarrera debe ser mayor a 0") int idCarrera,
                                    @Min(value = 1, message = "Tamaño de idSemestre debe ser mayor a 0") int idSemestre,
                                    @Min(value = 1, message = "Tamaño de idDia debe ser mayor a 0") int idDia,
                                    @Min(value = 1, message = "Tamaño de idTurno debe ser mayor a 0") int idTurno) {

        super(page, size, sortField, shortOrder, globalFilter);
        this.idCarrera = idCarrera;
        this.idSemestre = idSemestre;
        this.idDia = idDia;
        this.idTurno = idTurno;
    }
}
