package com.control.asistencia.adapter.out.persistence;


import org.springframework.data.domain.Page;

import com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre.ViewAllMapperMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.materiaCarreraSemestre.IViewAllRepositoryMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewAllOutPortMateriaCarreraSemestre;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.domain.MateriaCarreraSemestreDTO;


@PersistenceAdapter
public class PersistenceAdapterMateriaCarreraSemestre implements IViewAllOutPortMateriaCarreraSemestre{
    private final IViewAllRepositoryMateriaCarreraSemestre allRepositoryMateriaCarreraSemestre;
    private final ViewAllMapperMateriaCarreraSemestre viewAllMapperMateriaCarreraSemestre;
    public PersistenceAdapterMateriaCarreraSemestre(IViewAllRepositoryMateriaCarreraSemestre allRepositoryMateriaCarreraSemestre
                        , ViewAllMapperMateriaCarreraSemestre viewAllMapperMateriaCarreraSemestre){
        this.allRepositoryMateriaCarreraSemestre = allRepositoryMateriaCarreraSemestre;
        this.viewAllMapperMateriaCarreraSemestre = viewAllMapperMateriaCarreraSemestre;
    }
    @Override
    public Page<MateriaCarreraSemestreDTO> getAllMateriaCarreraSemestreDTO(ViewAllCommandMateriaCarreraSemestre viewAllCommandMateriaCarreraSemestre) {
        return this.viewAllMapperMateriaCarreraSemestre.pageEntityToDto(
            this.allRepositoryMateriaCarreraSemestre.getMateriaCarreraSemestreEntitys(viewAllCommandMateriaCarreraSemestre)
            );
    }

}
