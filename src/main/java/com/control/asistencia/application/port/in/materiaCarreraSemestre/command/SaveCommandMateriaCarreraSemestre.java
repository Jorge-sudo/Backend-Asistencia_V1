package com.control.asistencia.application.port.in.materiaCarreraSemestre.command;

import lombok.Data;
import lombok.Getter;

@Data
public class SaveCommandMateriaCarreraSemestre {
    private int idCarrera;
    private String sigla;
    private int idSemestre;
    private boolean activo;
}
