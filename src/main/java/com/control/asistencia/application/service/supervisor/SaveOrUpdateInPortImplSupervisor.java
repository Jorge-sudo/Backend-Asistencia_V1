package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.application.port.in.supervisor.ISaveOrUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplSupervisor implements ISaveOrUpdateInPortSupervisor {
    private final ISaveOrUpdateOutPortSupervisor iSaveOrUpdateOutPortSupervisor;
    public SaveOrUpdateInPortImplSupervisor(ISaveOrUpdateOutPortSupervisor iSaveOrUpdateOutPortSupervisor){
        this.iSaveOrUpdateOutPortSupervisor = iSaveOrUpdateOutPortSupervisor;
    }

    @Override
    public Optional<SupervisorViewDTO> saveOrUpdateSupervisor(SaveCommandSupervisor saveCommandSupervisor) {
        return this.iSaveOrUpdateOutPortSupervisor.saveOrUpdateSupervisor(saveCommandSupervisor);
    }
}
