package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGeneric;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;
import com.control.asistencia.application.port.out.carrera.IDeleteOutPortCarrera;
import com.control.asistencia.application.port.out.carrera.ISaveOrUpdateOutPortCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class CarreraPersistenceAdapter implements
        IViewOutPortCarrera ,
        ISaveOrUpdateOutPortCarrera,
        IDeleteOutPortCarrera {

    private final IRepositoryCarrera iRepositoryCarrera;
    private final IMapperGeneric iMapperGeneric;
    public CarreraPersistenceAdapter(
            IRepositoryCarrera iRepositoryCarrera,
            IMapperGeneric iMapperGeneric ){

        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iMapperGeneric = iMapperGeneric;

    }


    @Override
    public Optional<Set<SaveCommandGeneric>> viewAllCarreraDTO() {
        return Optional.of(
                this.iMapperGeneric.entitysToDtosCarrera(
                        new HashSet<>(this.iRepositoryCarrera.findAll())
                )
        );
    }


    @Override
    public Optional<SaveCommandGeneric> saveOrUpdateCarrera(SaveCommandGeneric saveCommandGeneric) {
        return Optional.of(
                this.iMapperGeneric.entityToDtoCarrera(
                        this.iRepositoryCarrera.save(
                                this.iMapperGeneric.dtoToEntityCarrera(saveCommandGeneric)
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
        ).orElseThrow(() -> new DataNotFoundException("No existe la carrera con el ID: " + id));
    }
}
