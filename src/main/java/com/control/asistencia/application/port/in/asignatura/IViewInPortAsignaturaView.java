package com.control.asistencia.application.port.in.asignatura;

import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import org.springframework.http.ResponseEntity;

public interface IViewInPortAsignaturaView {
    ResponseEntity<?> viewPageMateriaAssignView(CommandPageAssignMateria command);
}
