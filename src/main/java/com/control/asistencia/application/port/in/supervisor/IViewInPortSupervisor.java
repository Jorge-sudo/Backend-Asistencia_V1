package com.control.asistencia.application.port.in.supervisor;

import org.springframework.http.ResponseEntity;

public interface IViewInPortSupervisor {
    ResponseEntity<?> viewSetSupervisorDTO();
    ResponseEntity<?> viewByCiSupervisorDTO(Long ci);
}
