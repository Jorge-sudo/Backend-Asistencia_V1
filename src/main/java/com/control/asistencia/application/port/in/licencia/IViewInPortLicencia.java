package com.control.asistencia.application.port.in.licencia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortLicencia {
    ResponseEntity<?> viewPageLicenciaDTO(ViewPageCommand command);
}
