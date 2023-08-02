package com.control.asistencia.adapter.in.web.docente;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.docente.ISaveOrUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.IViewInPortDocente;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.docente.DocenteViewDTO;
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
public class SaveOrUpdateControllerDocente {
    private final ISaveOrUpdateInPortDocente iSaveOrUpdateInPortDocente;
    private final IViewInPortDocente iViewInPortDocente;
    public SaveOrUpdateControllerDocente(
            ISaveOrUpdateInPortDocente iSaveOrUpdateInPortDocente ,
            IViewInPortDocente iViewInPortDocente){

        this.iSaveOrUpdateInPortDocente = iSaveOrUpdateInPortDocente;
        this.iViewInPortDocente = iViewInPortDocente;
    }
    @PostMapping("/docentes")
    ResponseEntity<?> saveOrUpdateDocente(@RequestBody @Valid SaveCommandDocente data){
        Optional<DocenteViewDTO> response = this.iViewInPortDocente
                .viewByCiDocenteDTO(data.getCi());

        return response.isEmpty()
                ?  ResponseBuilderApiRest.save(
                        this.iSaveOrUpdateInPortDocente.saveOrUpdateDocente(data)
                )
                : ResponseBuilderApiRest.update(
                        this.iSaveOrUpdateInPortDocente.saveOrUpdateDocente(data)
                );
    }
}
