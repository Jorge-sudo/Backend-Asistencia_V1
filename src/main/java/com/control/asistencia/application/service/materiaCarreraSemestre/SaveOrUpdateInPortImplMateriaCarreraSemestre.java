package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveOrUpdateInPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOrUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class SaveOrUpdateInPortImplMateriaCarreraSemestre implements ISaveOrUpdateInPortMateriaCarreraSemestre {
    private final ISaveOrUpdateOutPortMateriaCarreraSemestre iSaveOrUpdateOutPortMateriaCarreraSemestre;
    public SaveOrUpdateInPortImplMateriaCarreraSemestre(ISaveOrUpdateOutPortMateriaCarreraSemestre iSaveOrUpdateOutPortMateriaCarreraSemestre){
        this.iSaveOrUpdateOutPortMateriaCarreraSemestre = iSaveOrUpdateOutPortMateriaCarreraSemestre;
    }
    @Override
    @Transactional
    public Optional<ViewMateriaCarreraSemestreDTO> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre) {

        return this.iSaveOrUpdateOutPortMateriaCarreraSemestre
                .saveOrUpdateMateriaCarreraSemestre(saveCommandMateriaCarreraSemestre);
    }
}
