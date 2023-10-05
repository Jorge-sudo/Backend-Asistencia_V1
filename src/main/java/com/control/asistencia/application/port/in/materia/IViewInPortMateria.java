package com.control.asistencia.application.port.in.materia;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortMateria {
    ResponseEntity<?> viewPageMateriaDTO(ViewPageCommand command);
    ResponseEntity<?> viewByIdMateriaDTO(String sigla);
}
