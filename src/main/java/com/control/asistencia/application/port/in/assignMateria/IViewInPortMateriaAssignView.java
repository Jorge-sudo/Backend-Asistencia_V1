package com.control.asistencia.application.port.in.assignMateria;

import com.control.asistencia.application.port.in.assignMateria.command.CommandPageAssignMateria;
import org.springframework.http.ResponseEntity;

public interface IViewInPortMateriaAssignView {
    ResponseEntity<?> viewPageMateriaAssignView(CommandPageAssignMateria command);
}
