package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGeneric;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.out.semestre.IDeleteOutPortSemestre;
import com.control.asistencia.application.port.out.semestre.ISaveOrUpdateOutPortSemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.domain.generic.GenericDTO;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class PersistenceAdapterSemestreOrUpdate implements
                IViewOutPortSemestre ,
        ISaveOrUpdateOutPortSemestre,
                IDeleteOutPortSemestre {
    private final IRepositorySemestre iRepositorySemestre;
    private final IMapperGeneric iMapperGeneric;

    public PersistenceAdapterSemestreOrUpdate(IRepositorySemestre iRepositorySemestre
                , IMapperGeneric iMapperGeneric){

        this.iRepositorySemestre = iRepositorySemestre;
        this.iMapperGeneric = iMapperGeneric;

    }

    @Override
    public Optional<Set<GenericDTO>> viewAllSemestreDTO() {
        return Optional.of(
                this.iMapperGeneric.entitysToDtosSemestre(
                        new HashSet<>(this.iRepositorySemestre.findAll())
                )
        );
    }

    @Override
    public Optional<GenericDTO> saveOrUpdateSemestre(GenericDTO genericDTO) {
        return Optional.of(
                this.iMapperGeneric.entityToDtoSemestre(
                        this.iRepositorySemestre.save(
                                this.iMapperGeneric.dtoToEntitySemestre(genericDTO)
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
        ).orElse(false);
    }
}
