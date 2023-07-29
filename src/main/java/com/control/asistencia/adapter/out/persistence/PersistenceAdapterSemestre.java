package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.out.semestre.IViewOutPortSemestre;
import com.control.asistencia.common.PersistenceAdapter;

import java.util.Optional;

@PersistenceAdapter
public class PersistenceAdapterSemestre implements IViewOutPortSemestre {
    private final IRepositorySemestre iRepositorySemestre;

    public PersistenceAdapterSemestre(IRepositorySemestre iRepositorySemestre){
        this.iRepositorySemestre = iRepositorySemestre;
    }

    @Override
    public Optional<SemestreEntity> viewByIdSemestreEntity(int id) {
        return this.iRepositorySemestre.findById(id);
    }
}
