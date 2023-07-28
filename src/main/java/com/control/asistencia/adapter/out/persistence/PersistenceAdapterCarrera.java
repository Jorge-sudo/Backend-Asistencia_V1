package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.application.port.out.carrera.IViewOutPortCarrera;
import com.control.asistencia.common.PersistenceAdapter;
import jakarta.persistence.EntityNotFoundException;

@PersistenceAdapter
public class PersistenceAdapterCarrera implements
        IViewOutPortCarrera {
    private final IRepositoryCarrera repositoryCarrera;
    public PersistenceAdapterCarrera(IRepositoryCarrera repositoryCarrera){
        this.repositoryCarrera = repositoryCarrera;
    }

    @Override
    public CarreraEntity viewByIdCarreraEntity(int id) {
        return this.repositoryCarrera.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carrera not found"));
    }
}
