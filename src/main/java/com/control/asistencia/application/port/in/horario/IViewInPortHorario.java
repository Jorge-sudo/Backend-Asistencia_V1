package com.control.asistencia.application.port.in.horario;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortHorario {
    ResponseEntity<?> viewPageHorarioDTO(ViewPageCommand command);
}
