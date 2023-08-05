package com.control.asistencia.application.service.docente;

import com.control.asistencia.application.port.in.docente.ISaveOrUpdateInPortDocente;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.application.port.out.docente.ISaveOrUpdateOutPortDocente;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplDocente implements ISaveOrUpdateInPortDocente {
    private final ISaveOrUpdateOutPortDocente iSaveOrUpdateOutPortDocente;
    public SaveOrUpdateInPortImplDocente(ISaveOrUpdateOutPortDocente iSaveOrUpdateOutPortDocente){
        this.iSaveOrUpdateOutPortDocente = iSaveOrUpdateOutPortDocente;
    }
    @Override
    @Transactional
    public Optional<DocenteViewDTO> saveOrUpdateDocente(SaveCommandDocente saveCommandDocente) {
        return this.iSaveOrUpdateOutPortDocente.saveOrUpdateDocente(saveCommandDocente);
    }
}
