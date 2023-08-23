package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGenericRol;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.application.port.out.rol.IViewOutPortRol;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.application.port.in.commandGeneric.SaveOrViewCommandGeneric;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class RolPersistenceAdapter implements
        IViewOutPortRol {
    private final IRepositoryRol iRepositoryRol;
    private final IMapperGenericRol iMapperGenericRol;
    public RolPersistenceAdapter(
            IRepositoryRol iRepositoryRol,
            IMapperGenericRol iMapperGenericRol){

        this.iRepositoryRol = iRepositoryRol;
        this.iMapperGenericRol = iMapperGenericRol;
    }
    @Override
    public Optional<Set<SaveOrViewCommandGeneric>> viewAllRol() {
        return Optional.of(
                this.iMapperGenericRol.entitysToCommandsSet(
                        new HashSet<>(this.iRepositoryRol.findAll())
                )
        );
    }
}
