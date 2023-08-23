package com.control.asistencia.application.service.materia;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materia.ISaveOrUpdateInPortMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


@UseCase
public class SaveOrUpdateInPortImplMateria implements ISaveOrUpdateInPortMateria {
    private final ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria;
    private final IViewOutPortMateria iViewOutPortMateria;
    public SaveOrUpdateInPortImplMateria(
            ISaveOrUpdateOutPortMateria iSaveOrUpdateOutPortMateria ,
            IViewOutPortMateria iViewOutPortMateria){

        this.iSaveOrUpdateOutPortMateria = iSaveOrUpdateOutPortMateria;
        this.iViewOutPortMateria = iViewOutPortMateria;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateMateria(CommandMateria commandMateria) {
        return this.iViewOutPortMateria.viewByIdMateriaDTO(commandMateria.getSigla()).isPresent()
                ? ResponseBuilderApiRest.update(
                this.iSaveOrUpdateOutPortMateria.saveOrUpdateMateria(commandMateria)
                )
                : ResponseBuilderApiRest.save(
                this.iSaveOrUpdateOutPortMateria.saveOrUpdateMateria(commandMateria)
        );
    }
}
