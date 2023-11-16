package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.application.port.in.supervisor.IUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdatePerfilCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.IUpdateOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class UpdateInPortImplSupervisor implements IUpdateInPortSupervisor {
    private final IUpdateOutPortSupervisor iUpdateOutPortSupervisor;

    public UpdateInPortImplSupervisor(
            IUpdateOutPortSupervisor iUpdateOutPortSupervisor) {
        this.iUpdateOutPortSupervisor = iUpdateOutPortSupervisor;
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateSupervisorActivo(UpdateActivoCommandSupervisor command) {
        return ResponseBuilderApiRest.updateActivo(
                this.iUpdateOutPortSupervisor.updateSupervisorActivo(command));
    }

    @Override
    @Transactional
    public ResponseEntity<?> updatePerfilSupervisor(UpdatePerfilCommandSupervisor command) {
        return ResponseBuilderApiRest.updatePerfil(
                this.iUpdateOutPortSupervisor.updateSupervisorPerfil(command)
        );
    }
}
