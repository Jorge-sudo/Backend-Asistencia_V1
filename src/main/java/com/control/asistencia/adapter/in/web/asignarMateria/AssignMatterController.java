package com.control.asistencia.adapter.in.web.asignarMateria;

import com.control.asistencia.application.port.in.asignarMateria.IAssignMatterInPort;
import com.control.asistencia.application.port.in.asignarMateria.command.CommandAssignMatter;
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
public class AssignMatterController {
    private final IAssignMatterInPort iAssignMatterInPort;
    public AssignMatterController(IAssignMatterInPort iAssignMatterInPort) {
        this.iAssignMatterInPort = iAssignMatterInPort;
    }
    @PostMapping("/asignarMateria")
    ResponseEntity<?> saveOrUpdateAsignarMateria(@RequestBody @Valid CommandAssignMatter data){
        return this.iAssignMatterInPort.assignMatter(data);
    }
}
