package com.control.asistencia.application.port.out.supervisor;

import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;

import java.util.Optional;

public interface ISaveOrUpdateOutPortSupervisor {
    Optional<SupervisorViewDTO> saveOrUpdateSupervisor(SaveCommandSupervisor saveCommandSupervisor);
}
