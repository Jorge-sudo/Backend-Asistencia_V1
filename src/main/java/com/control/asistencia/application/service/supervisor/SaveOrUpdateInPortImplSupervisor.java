package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.supervisor.ISaveOrUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        Optional<SupervisorViewDTO> response = this.iViewOutPortSupervisor
                .viewByCiSupervisorDTO(command.getCi());

        return response.isEmpty()
                ? ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortSupervisor.saveOrUpdateSupervisor(command)
        )
                : ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortSupervisor.saveOrUpdateSupervisor(command)
        );
    }
}
