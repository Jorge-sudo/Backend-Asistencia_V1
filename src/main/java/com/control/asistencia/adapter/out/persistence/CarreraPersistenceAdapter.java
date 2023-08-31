package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGenericCarrera;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;
import com.control.asistencia.application.port.out.carrera.IDeleteOutPortCarrera;
import com.control.asistencia.application.port.out.carrera.ISaveOrUpdateOutPortCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class CarreraPersistenceAdapter implements
        IViewOutPortCarrera ,
        ISaveOrUpdateOutPortCarrera,
        IDeleteOutPortCarrera {

    private final IRepositoryCarrera iRepositoryCarrera;
    private final IMapperGenericCarrera iMapperGenericCarrera;
    public CarreraPersistenceAdapter(
            IRepositoryCarrera iRepositoryCarrera,
            IMapperGenericCarrera iMapperGenericCarrera ){

        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iMapperGenericCarrera = iMapperGenericCarrera;

    }


    @Override
    public Optional<Set<SaveOrViewCommandGeneric>> viewAllCarreraDTO() {
        return Optional.of(
                this.iMapperGenericCarrera.entitysToCommandsSet(
                        new HashSet<>(this.iRepositoryCarrera.findAll())
                )
        );
    }


    @Override
    public Optional<SaveOrViewCommandGeneric> saveOrUpdateCarrera(SaveOrViewCommandGeneric saveOrViewCommandGeneric) {
        return Optional.of(
                this.iMapperGenericCarrera.entityToCommand(
                        this.iRepositoryCarrera.save(
                                this.iMapperGenericCarrera.commandToEntity(saveOrViewCommandGeneric)
                        )
                )
        );
    }

    @Override
    public boolean deleteCarrera(int id) {
        return this.iRepositoryCarrera.findById(id).map(
                carrera -> {
                    this.iRepositoryCarrera.delete(carrera);
                    return true;
                }
        ).orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la carrera con el ID: " + id));
    }
}
