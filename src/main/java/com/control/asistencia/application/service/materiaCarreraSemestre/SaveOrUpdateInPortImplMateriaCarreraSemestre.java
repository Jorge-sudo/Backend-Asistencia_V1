package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveOrUpdateInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOrUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SaveOrUpdateInPortImplMateriaCarreraSemestre implements ISaveOrUpdateInPortMateriaCarreraSemestre {
    private final ISaveOrUpdateOutPortMateriaCarreraSemestre iSaveOrUpdateOutPortMateriaCarreraSemestre;
    public SaveOrUpdateInPortImplMateriaCarreraSemestre(ISaveOrUpdateOutPortMateriaCarreraSemestre iSaveOrUpdateOutPortMateriaCarreraSemestre){
        this.iSaveOrUpdateOutPortMateriaCarreraSemestre = iSaveOrUpdateOutPortMateriaCarreraSemestre;
    }
    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre command) {

        return command.getIdMateriaCarreraSemestre() > 0
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortMateriaCarreraSemestre.saveOrUpdateMateriaCarreraSemestre(command)
        )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortMateriaCarreraSemestre.saveOrUpdateMateriaCarreraSemestre(command)
        );
    }
}
