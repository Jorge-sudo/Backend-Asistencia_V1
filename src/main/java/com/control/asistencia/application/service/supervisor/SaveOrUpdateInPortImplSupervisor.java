package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.supervisor.ISaveOrUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SaveOrUpdateInPortImplSupervisor implements ISaveOrUpdateInPortSupervisor {
    private final ISaveOrUpdateOutPortSupervisor iSaveOrUpdateOutPortSupervisor;
    private final IViewOutPortSupervisor iViewOutPortSupervisor;
    public SaveOrUpdateInPortImplSupervisor(
            ISaveOrUpdateOutPortSupervisor iSaveOrUpdateOutPortSupervisor ,
            IViewOutPortSupervisor iViewOutPortSupervisor){

        this.iSaveOrUpdateOutPortSupervisor = iSaveOrUpdateOutPortSupervisor;
        this.iViewOutPortSupervisor = iViewOutPortSupervisor;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateSupervisor(SaveCommandSupervisor command) {
        return this.iViewOutPortSupervisor.viewByCiSupervisorDTO(command.getCi()).isPresent()
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortSupervisor.saveOrUpdateSupervisor(command)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortSupervisor.saveOrUpdateSupervisor(command)
        );
    }
}
