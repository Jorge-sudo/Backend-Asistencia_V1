package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGenericDiaSemana;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDiaSemana;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import com.control.asistencia.application.port.out.diaSemana.IViewOutPortDiaSemana;
import com.control.asistencia.common.PersistenceAdapter;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
public class DiaSemanaPersistenceAdapter implements
        IViewOutPortDiaSemana {
    private final IMapperGenericDiaSemana iMapperGenericDiaSemana;
    private final IRepositoryDiaSemana iRepositoryDiaSemana;
    public DiaSemanaPersistenceAdapter(
            IMapperGenericDiaSemana iMapperGenericDiaSemana ,
            IRepositoryDiaSemana iRepositoryDiaSemana){

        this.iMapperGenericDiaSemana = iMapperGenericDiaSemana;
        this.iRepositoryDiaSemana = iRepositoryDiaSemana;
    }
    @Override
    public Optional<List<SaveOrViewCommandGeneric>> viewAllDiaSemanaDTO() {
        return Optional.of(
                this.iMapperGenericDiaSemana.entitysToCommandsList(
                        this.iRepositoryDiaSemana.findAll()
                )
        );
    }
}
