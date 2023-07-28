package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre.IViewMapperMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewOutPortMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;

import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Set;


@PersistenceAdapter
public class PersistenceAdapterMateriaCarreraSemestre implements IViewOutPortMateriaCarreraSemestre,
        ISaveOutPortMateriaCarreraSemestre {
    private final IRepositoryMateriaCarreraSemestre repositoryMateriaCarreraSemestre;
    private final IViewMapperMateriaCarreraSemestre iViewMapperMateriaCarreraSemestre;
    private final IRepositoryMateria iRepositoryMateria;
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositorySemestre iRepositorySemestre;
    public PersistenceAdapterMateriaCarreraSemestre(IRepositoryMateriaCarreraSemestre repositoryMateriaCarreraSemestre
                        , IViewMapperMateriaCarreraSemestre iViewMapperMateriaCarreraSemestre
                        , IRepositoryMateria iRepositoryMateria
                        , IRepositoryCarrera iRepositoryCarrera
                        , IRepositorySemestre iRepositorySemestre){

        this.repositoryMateriaCarreraSemestre = repositoryMateriaCarreraSemestre;
        this.iViewMapperMateriaCarreraSemestre = iViewMapperMateriaCarreraSemestre;
        this.iRepositoryMateria = iRepositoryMateria;
        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iRepositorySemestre = iRepositorySemestre;
    }
    @Override
    public Page<ViewMateriaCarreraSemestreDTO> viewPagePageMateriaCarreraSemestreDTO(Pageable pageable) {
        return this.iViewMapperMateriaCarreraSemestre.pageEntityToDto(
                this.repositoryMateriaCarreraSemestre.findAll(pageable)
        );
    }
    @Override
    public Set<ViewMateriaCarreraSemestreDTO> viewAllMateriaCarreraSemestreDTO() {
        return this.iViewMapperMateriaCarreraSemestre.entitysToDtos(
                new HashSet<>(this.repositoryMateriaCarreraSemestre.findAll())
        );
    }
    @Override
    public ViewMateriaCarreraSemestreDTO saveSaveMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre command) {
        return this.iViewMapperMateriaCarreraSemestre.entityToDto(
                this.repositoryMateriaCarreraSemestre.save(
                        new MateriaCarreraSemestreEntity(
                                  this.iRepositoryCarrera.findById(command.getIdCarrera())
                                , this.iRepositoryMateria.findById(command.getSigla())
                                , this.iRepositorySemestre.findById(command.getIdSemestre())
                                , command.isActivo()
                        )
                )
        );
    }
}
