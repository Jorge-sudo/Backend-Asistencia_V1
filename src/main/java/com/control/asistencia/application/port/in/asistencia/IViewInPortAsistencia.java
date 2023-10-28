package com.control.asistencia.application.port.in.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandPageAsistencia;
import com.control.asistencia.application.port.in.command.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortAsistencia {
    ResponseEntity<?> viewPageByFechaAndGlobalFilterAsistencia(ViewPageCommand command, CommandPageAsistencia commandAsistencia);
}
