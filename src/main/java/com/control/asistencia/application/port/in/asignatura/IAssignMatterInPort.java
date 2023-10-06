package com.control.asistencia.application.port.in.asignatura;

import com.control.asistencia.application.port.in.asignatura.command.CommandAssignMatter;
import org.springframework.http.ResponseEntity;

public interface IAssignMatterInPort {
    ResponseEntity<?> assignMatter(CommandAssignMatter command);
}
