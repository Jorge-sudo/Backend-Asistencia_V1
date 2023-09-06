package com.control.asistencia.application.port.in.assignMateria;

import com.control.asistencia.application.port.in.assignMateria.command.CommandAssignMatter;
import org.springframework.http.ResponseEntity;

public interface IAssignMatterInPort {
    ResponseEntity<?> assignMatter(CommandAssignMatter command);
}
