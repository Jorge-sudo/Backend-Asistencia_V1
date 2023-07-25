package com.control.asistencia.domain;

import lombok.Data;

@Data
public class MateriaCarreraSemestreDTO {
    private String sigla;
    private String materia;
    private String carrera;
    private String semestre;
    private boolean activo;
}
