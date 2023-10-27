package com.control.asistencia.application.port.in.horario;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortHorario {
    ResponseEntity<?> viewPageHorarioDTO(ViewPageCommand command);
    ResponseEntity<?> viewAllHorarioDTO();
}
