package com.control.asistencia.application.port.in.supervisor;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import org.springframework.http.ResponseEntity;

public interface IViewInPortSupervisor {
    ResponseEntity<?> viewPageSupervisorDTO(ViewPageCommand command);
    ResponseEntity<?> viewByCiSupervisorDTO(Long ci);
}
