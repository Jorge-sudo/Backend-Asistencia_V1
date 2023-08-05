package com.control.asistencia.adapter.in.web.aula;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.aula.ISaveOrUpdateInPortAula;
import com.control.asistencia.application.port.in.aula.IViewInPortAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.common.WebAdapter;
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
public class SaveOrUpdateControllerAula {
    private final ISaveOrUpdateInPortAula iSaveOrUpdateInPortAula;
    private final IViewInPortAula iViewInPortAula;
    public SaveOrUpdateControllerAula(
            ISaveOrUpdateInPortAula iSaveOrUpdateInPortAula ,
            IViewInPortAula iViewInPortAula){

        this.iSaveOrUpdateInPortAula = iSaveOrUpdateInPortAula;
        this.iViewInPortAula = iViewInPortAula;
    }
    @PostMapping("/aulas")
    ResponseEntity<?> saveOrUpdateAula(@RequestBody @Valid CommandAula data){
        Optional<CommandAula> response = this.iViewInPortAula
                .viewByIdAulaDTO(data.getId());
        return response.isEmpty()
                ? ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateInPortAula.saveOrUpdateAula(data)
                )
                : ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateInPortAula.saveOrUpdateAula(data)
                );
    }

}
