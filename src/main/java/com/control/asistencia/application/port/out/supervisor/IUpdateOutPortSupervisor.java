package com.control.asistencia.application.port.out.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdatePerfilCommandSupervisor;

public interface IUpdateOutPortSupervisor {
    boolean updateSupervisorActivo(UpdateActivoCommandSupervisor command);
    boolean updateSupervisorPerfil(UpdatePerfilCommandSupervisor command);
}
