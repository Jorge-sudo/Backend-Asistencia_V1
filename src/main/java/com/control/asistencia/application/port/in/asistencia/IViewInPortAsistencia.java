package com.control.asistencia.application.port.in.asistencia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortAsistencia {
    ResponseEntity<?> viewPageAsistencia(ViewPageCommand command);
}
