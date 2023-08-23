package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGenericSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import com.control.asistencia.application.port.out.semestre.IDeleteOutPortSemestre;
import com.control.asistencia.application.port.out.semestre.ISaveOrUpdateOutPortSemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class SemestrePersistenceAdapter implements
                IViewOutPortSemestre ,
                ISaveOrUpdateOutPortSemestre,
                IDeleteOutPortSemestre {
    private final IRepositorySemestre iRepositorySemestre;
    private final IMapperGenericSemestre iMapperGenericSemestre;

    public SemestrePersistenceAdapter(IRepositorySemestre iRepositorySemestre
                , IMapperGenericSemestre iMapperGenericSemestre){

        this.iRepositorySemestre = iRepositorySemestre;
        this.iMapperGenericSemestre = iMapperGenericSemestre;

    }

    @Override
    public Optional<Set<SaveOrViewCommandGeneric>> viewAllSemestreDTO() {
        return Optional.of(
                this.iMapperGenericSemestre.entitysToCommandsSet(
                        new HashSet<>(this.iRepositorySemestre.findAll())
                )
        );
    }

    @Override
    public Optional<SaveOrViewCommandGeneric> saveOrUpdateSemestre(SaveOrViewCommandGeneric saveOrViewCommandGeneric) {
        return Optional.of(
                this.iMapperGenericSemestre.entityToCommand(
                        this.iRepositorySemestre.save(
                                this.iMapperGenericSemestre.commandToEntity(saveOrViewCommandGeneric)
                        )
                )
        );
    }


    @Override
    public boolean deleteSemestre(int id) {
        return this.iRepositorySemestre.findById(id).map(
                semestre -> {
                    this.iRepositorySemestre.delete(semestre);
                    return true;
                }
        ).orElseThrow(() -> new DataNotFoundException("No existe el semestre con el ID: " + id));
    }
}
