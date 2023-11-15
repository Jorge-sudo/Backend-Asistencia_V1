package com.control.asistencia.application.service.supervisor;

import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.supervisor.IViewInPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class ViewInPortImplSupervisor implements IViewInPortSupervisor {
    private final IViewOutPortSupervisor iViewOutPortSupervisor;
    public ViewInPortImplSupervisor(IViewOutPortSupervisor iViewOutPortSupervisor){
        this.iViewOutPortSupervisor = iViewOutPortSupervisor;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewSetSupervisorDTO() {
        return ResponseBuilderApiRest.view(
                Optional.of(this.iViewOutPortSupervisor.viewSetSupervisorDTO())
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> viewByCiSupervisorDTO(Long ci) {
        return ResponseBuilderApiRest.view(
                Optional.of(
                        this.iViewOutPortSupervisor.viewByCiSupervisorDTO(ci)
                            .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el supervisor con el ci: " + ci))
                )
        );
    }
}
