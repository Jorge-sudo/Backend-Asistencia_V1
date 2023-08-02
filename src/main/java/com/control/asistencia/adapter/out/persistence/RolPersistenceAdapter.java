package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.generic.IMapperGeneric;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.application.port.out.rol.IViewOutPortRol;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.application.port.in.commandGeneric.SaveCommandGeneric;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class RolPersistenceAdapter implements
        IViewOutPortRol {
    private final IRepositoryRol iRepositoryRol;
    private final IMapperGeneric iMapperGeneric;
    public RolPersistenceAdapter(IRepositoryRol iRepositoryRol,
                                 IMapperGeneric iMapperGeneric){
        this.iRepositoryRol = iRepositoryRol;
        this.iMapperGeneric = iMapperGeneric;
    }
    @Override
    public Optional<Set<SaveCommandGeneric>> viewAllRol() {
        return Optional.of(
                this.iMapperGeneric.entitysToDtosRol(
                        new HashSet<>(this.iRepositoryRol.findAll())
                )
        );
    }
}
