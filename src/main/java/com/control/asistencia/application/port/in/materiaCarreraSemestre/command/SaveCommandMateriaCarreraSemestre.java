package com.control.asistencia.application.port.in.materiaCarreraSemestre.command;

import lombok.Data;

@Data
public class SaveCommandMateriaCarreraSemestre {
    private int idMateriaCarreraSemestre;
    private int idCarrera;
    private String sigla;
    private int idSemestre;
    private boolean activo;
}
