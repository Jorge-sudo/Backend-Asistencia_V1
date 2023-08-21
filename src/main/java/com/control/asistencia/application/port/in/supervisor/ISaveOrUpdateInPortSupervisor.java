package com.control.asistencia.application.port.in.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortSupervisor {
    ResponseEntity<?> saveOrUpdateSupervisor(SaveCommandSupervisor saveCommandSupervisor);
}
