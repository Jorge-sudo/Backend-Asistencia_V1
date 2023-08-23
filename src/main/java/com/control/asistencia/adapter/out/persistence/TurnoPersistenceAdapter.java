package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGenericTurno;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryTurno;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import com.control.asistencia.application.port.out.turno.IViewOutPortTurno;
import com.control.asistencia.common.PersistenceAdapter;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
public class TurnoPersistenceAdapter implements IViewOutPortTurno {

    private final IRepositoryTurno iRepositoryTurno;
    private final IMapperGenericTurno iMapperGenericTurno;
    public TurnoPersistenceAdapter(
            IRepositoryTurno repositoryTurno ,
            IMapperGenericTurno mapperGenericTurno){

        this.iRepositoryTurno = repositoryTurno;
        this.iMapperGenericTurno = mapperGenericTurno;
    }
    @Override
    public Optional<List<SaveOrViewCommandGeneric>> viewAllTurno() {
        return Optional.of(
                this.iMapperGenericTurno.entitysToCommandsList(
                    this.iRepositoryTurno.findAll()
                )
        );
    }
}
