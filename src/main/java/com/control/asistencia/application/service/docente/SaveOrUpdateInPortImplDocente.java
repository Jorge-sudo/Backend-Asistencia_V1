package com.control.asistencia.application.service.docente;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.docente.ISaveOrUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.application.port.out.docente.ISaveOrUpdateOutPortDocente;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplDocente implements ISaveOrUpdateInPortDocente {
    private final ISaveOrUpdateOutPortDocente iSaveOrUpdateOutPortDocente;
    private final IViewOutPortDocente iViewOutPortDocente;
    public SaveOrUpdateInPortImplDocente(
            ISaveOrUpdateOutPortDocente iSaveOrUpdateOutPortDocente ,
            IViewOutPortDocente iViewInPortDocente){

        this.iSaveOrUpdateOutPortDocente = iSaveOrUpdateOutPortDocente;
        this.iViewOutPortDocente = iViewInPortDocente;
    }
    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateDocente(SaveCommandDocente saveCommandDocente) {
        return this.iViewOutPortDocente.viewByCiDocenteDTO(saveCommandDocente.getCi()).isPresent()
                ?  ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortDocente.saveOrUpdateDocente(saveCommandDocente)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortDocente.saveOrUpdateDocente(saveCommandDocente)
        );
    }
}
