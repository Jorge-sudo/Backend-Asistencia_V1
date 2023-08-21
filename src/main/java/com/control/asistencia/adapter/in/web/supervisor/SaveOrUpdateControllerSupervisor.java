package com.control.asistencia.adapter.in.web.supervisor;

import com.control.asistencia.application.port.in.supervisor.ISaveOrUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
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
public class SaveOrUpdateControllerSupervisor {
    private final ISaveOrUpdateInPortSupervisor iSaveOrUpdateInPortSupervisor;
    public SaveOrUpdateControllerSupervisor(
            ISaveOrUpdateInPortSupervisor iSaveOrUpdateInPortSupervisor ){

        this.iSaveOrUpdateInPortSupervisor = iSaveOrUpdateInPortSupervisor;
    }
    @PostMapping("/supervisores")
    ResponseEntity<?> saveOrUpdateSupervisor(@RequestBody @Valid SaveCommandSupervisor data){
        return this.iSaveOrUpdateInPortSupervisor.saveOrUpdateSupervisor(data);
    }
}
