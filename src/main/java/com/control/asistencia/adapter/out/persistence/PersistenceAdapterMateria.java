package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.PersistenceAdapter;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@PersistenceAdapter
public class PersistenceAdapterMateria implements IViewOutPortMateria {
    private final IRepositoryMateria iRepositoryMateria;
    public PersistenceAdapterMateria(IRepositoryMateria repositoryMateria){
        this.iRepositoryMateria = repositoryMateria;
    }

    @Override
    public Optional<MateriaEntity> viewByIdMateriaEntity(String sigla) {
        return this.iRepositoryMateria.findById(sigla);
    }
}
