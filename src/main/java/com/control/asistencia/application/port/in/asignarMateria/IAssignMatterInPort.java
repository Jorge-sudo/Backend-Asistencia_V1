package com.control.asistencia.application.port.in.asignarMateria;

import com.control.asistencia.application.port.in.asignarMateria.command.CommandAssignMatter;
import org.springframework.http.ResponseEntity;

public interface IAssignMatterInPort {
    ResponseEntity<?> assignMatter(CommandAssignMatter command);
}
