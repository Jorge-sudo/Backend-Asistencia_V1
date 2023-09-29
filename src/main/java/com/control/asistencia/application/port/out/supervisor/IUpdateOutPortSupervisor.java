package com.control.asistencia.application.port.out.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;

public interface IUpdateOutPortSupervisor {
    boolean updateSupervisorActivo(UpdateActivoCommandSupervisor command);
}
