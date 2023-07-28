package com.control.asistencia.application.port.in.materiaCarreraSemestre.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPageCommandMateriaCarreraSemestre {
    private int page;
    private int size;
    private String sortBy;
}
