package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGeneric;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
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
    private final IMapperGeneric iMapperGeneric;

    public SemestrePersistenceAdapter(IRepositorySemestre iRepositorySemestre
                , IMapperGeneric iMapperGeneric){

        this.iRepositorySemestre = iRepositorySemestre;
        this.iMapperGeneric = iMapperGeneric;

    }

    @Override
    public Optional<Set<SaveCommandGeneric>> viewAllSemestreDTO() {
        return Optional.of(
                this.iMapperGeneric.entitysToDtosSemestre(
                        new HashSet<>(this.iRepositorySemestre.findAll())
                )
        );
    }

    @Override
    public Optional<SaveCommandGeneric> saveOrUpdateSemestre(SaveCommandGeneric saveCommandGeneric) {
        return Optional.of(
                this.iMapperGeneric.entityToDtoSemestre(
                        this.iRepositorySemestre.save(
                                this.iMapperGeneric.dtoToEntitySemestre(saveCommandGeneric)
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
