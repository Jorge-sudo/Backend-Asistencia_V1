package com.control.asistencia.application.port.in.docente;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortDocente {
    ResponseEntity<?> viewPageDocenteDTO(ViewPageCommand command);
    ResponseEntity<?> viewByCiDocenteDTO(Long ci);
}
