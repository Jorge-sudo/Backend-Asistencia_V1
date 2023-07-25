package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewAllCommandMateriaCarreraSemestre {
    private int page;
    private int size;
    private String sortBy;
}
