package com.control.asistencia.application.port.in.docenteLicencia;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortDocenteLicencia {
    ResponseEntity<?> viewPageActiveDocenteLicenciaDTO(ViewPageCommand command);
    ResponseEntity<?> viewPageInactiveDocenteLicenciaDTO(ViewPageCommand command);
    ResponseEntity<?> viewPageFilterGlobalDocenteLicenciaDTO(ViewPageCommand command);
}
