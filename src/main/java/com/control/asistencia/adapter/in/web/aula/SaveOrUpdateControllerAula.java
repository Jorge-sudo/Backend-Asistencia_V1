package com.control.asistencia.adapter.in.web.aula;

import com.control.asistencia.application.port.in.aula.ISaveOrUpdateInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
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
public class SaveOrUpdateControllerAula {
    private final ISaveOrUpdateInPortAula iSaveOrUpdateInPortAula;
    public SaveOrUpdateControllerAula(
            ISaveOrUpdateInPortAula iSaveOrUpdateInPortAula){

        this.iSaveOrUpdateInPortAula = iSaveOrUpdateInPortAula;
    }
    @PostMapping("/aulas")
    ResponseEntity<?> saveOrUpdateAula(@RequestBody @Valid CommandAula data){
        return this.iSaveOrUpdateInPortAula.saveOrUpdateAula(data);
    }

}
