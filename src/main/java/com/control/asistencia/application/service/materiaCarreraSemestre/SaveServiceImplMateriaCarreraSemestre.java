package com.control.asistencia.application.service.materiaCarreraSemestre;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ISaveServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class SaveServiceImplMateriaCarreraSemestre implements ISaveServiceMateriaCarreraSemestre {
    private final ISaveOutPortMateriaCarreraSemestre iSaveOutPortMateriaCarreraSemestre;
    public SaveServiceImplMateriaCarreraSemestre(ISaveOutPortMateriaCarreraSemestre iSaveOutPortMateriaCarreraSemestre){
        this.iSaveOutPortMateriaCarreraSemestre = iSaveOutPortMateriaCarreraSemestre;
    }

    @Override
    @Transactional
    public ViewMateriaCarreraSemestreDTO saveMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre saveCommandMateriaCarreraSemestre) {
        return this.iSaveOutPortMateriaCarreraSemestre
                .saveSaveMateriaCarreraSemestre(saveCommandMateriaCarreraSemestre);
    }
}
