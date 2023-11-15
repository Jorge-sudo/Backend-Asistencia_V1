package com.control.asistencia.application.port.in.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdatePerfilCommandSupervisor;
import org.springframework.http.ResponseEntity;

public interface IUpdateInPortSupervisor {
    ResponseEntity<?> updateSupervisorActivo(UpdateActivoCommandSupervisor command);

    ResponseEntity<?> updatePerfilSupervisor(UpdatePerfilCommandSupervisor command);
}
