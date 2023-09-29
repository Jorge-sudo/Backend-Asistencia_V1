package com.control.asistencia.adapter.in.web.supervisor;

import com.control.asistencia.application.port.in.supervisor.IUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class UpdateControllerSupervisor {
    private final IUpdateInPortSupervisor iUpdateInPortSupervisor;
    public UpdateControllerSupervisor(IUpdateInPortSupervisor iUpdateInPortSupervisor) {
        this.iUpdateInPortSupervisor = iUpdateInPortSupervisor;
    }
    @PostMapping("/supervisores/activo")
    ResponseEntity<?> updateSupervisorActivo(
            @RequestBody @Valid UpdateActivoCommandSupervisor command){
        return this.iUpdateInPortSupervisor.updateSupervisorActivo(command);
    }
}
