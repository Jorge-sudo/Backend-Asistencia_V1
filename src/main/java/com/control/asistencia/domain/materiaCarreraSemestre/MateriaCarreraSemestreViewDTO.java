package com.control.asistencia.domain.materiaCarreraSemestre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaCarreraSemestreViewDTO {
    private int idMateriaCarreraSemestre;
    private String sigla;
    private String materia;
    private String carrera;
    private String semestre;
    private boolean activo;
}
