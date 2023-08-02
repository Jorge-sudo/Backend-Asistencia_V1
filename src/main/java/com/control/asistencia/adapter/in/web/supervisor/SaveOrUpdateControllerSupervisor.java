package com.control.asistencia.adapter.in.web.supervisor;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.supervisor.ISaveOrUpdateInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.IViewInPortSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerSupervisor {
    private final ISaveOrUpdateInPortSupervisor iSaveOrUpdateInPortSupervisor;
    private final IViewInPortSupervisor iViewInPortSupervisor;
    public SaveOrUpdateControllerSupervisor(
            ISaveOrUpdateInPortSupervisor iSaveOrUpdateInPortSupervisor ,
            IViewInPortSupervisor iViewInPortSupervisor){

        this.iSaveOrUpdateInPortSupervisor = iSaveOrUpdateInPortSupervisor;
        this.iViewInPortSupervisor = iViewInPortSupervisor;
    }
    @PostMapping("/supervisores")
    ResponseEntity<?> saveOrUpdateSupervisor(@RequestBody @Valid SaveCommandSupervisor data){
        Optional<SupervisorViewDTO> response = this.iViewInPortSupervisor
                .viewByCiSupervisorDTO(data.getCi());

        return response.isEmpty()
                ? ResponseBuilderApiRest.save(
                        this.iSaveOrUpdateInPortSupervisor.saveOrUpdateSupervisor(data)
                )
                : ResponseBuilderApiRest.update(
                        this.iSaveOrUpdateInPortSupervisor.saveOrUpdateSupervisor(data)
                );
    }
}
