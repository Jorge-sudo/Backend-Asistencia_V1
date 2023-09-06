package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaAssignView;
import com.control.asistencia.application.port.out.assignMateria.IViewOutPortMateriaAssignView;
import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class MateriaAssignViewPersistenceAdapter implements IViewOutPortMateriaAssignView {
    private final IRepositoryMateriaAssignView iRepositoryMateriaAssignView;
    public MateriaAssignViewPersistenceAdapter(IRepositoryMateriaAssignView iRepositoryMateriaAssignView) {
        this.iRepositoryMateriaAssignView = iRepositoryMateriaAssignView;
    }

    @Override
    public Page<MateriaAssignView> viewPageMateriaAssignView(Pageable pageable) {
        return this.iRepositoryMateriaAssignView.findAll(pageable);
    }
}
