package com.control.asistencia.application.port.in.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;

import java.util.Optional;

public interface ISaveOrUpdateInPortSupervisor {
    Optional<SupervisorViewDTO> saveOrUpdateSupervisor(SaveCommandSupervisor saveCommandSupervisor);
}
