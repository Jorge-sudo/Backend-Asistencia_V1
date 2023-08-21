package com.control.asistencia.application.port.in.aula;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;


public interface IViewInPortAula {
    ResponseEntity<?> viewPageAulaDTO(ViewPageCommand command);
    ResponseEntity<?> viewByIdAulaDTO(int idAula);
}
