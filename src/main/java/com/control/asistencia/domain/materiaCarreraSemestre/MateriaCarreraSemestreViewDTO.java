package com.control.asistencia.domain.materiaCarreraSemestre;

import lombok.Data;

@Data
public class MateriaCarreraSemestreViewDTO {
    private int idMateriaCarreraSemestre;
    private String sigla;
    private String materia;
    private String carrera;
    private String semestre;
    private boolean activo;
}
