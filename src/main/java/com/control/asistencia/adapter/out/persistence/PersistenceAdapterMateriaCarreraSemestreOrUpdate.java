package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre.IViewMapperMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IDeleteOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOrUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewOutPortMateriaCarreraSemestre;
import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.springframework.data.domain.Page;

import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@PersistenceAdapter
public class PersistenceAdapterMateriaCarreraSemestreOrUpdate implements IViewOutPortMateriaCarreraSemestre,
        ISaveOrUpdateOutPortMateriaCarreraSemestre, IDeleteOutPortMateriaCarreraSemestre  {
    private final IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre;
    private final IViewMapperMateriaCarreraSemestre iViewMapperMateriaCarreraSemestre;
    private final IRepositoryMateria iRepositoryMateria;
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositorySemestre iRepositorySemestre;
    public PersistenceAdapterMateriaCarreraSemestreOrUpdate(IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre
                        , IViewMapperMateriaCarreraSemestre iViewMapperMateriaCarreraSemestre
                        , IRepositoryMateria iRepositoryMateria
                        , IRepositoryCarrera iRepositoryCarrera
                        , IRepositorySemestre iRepositorySemestre){

        this.iRepositoryMateriaCarreraSemestre = iRepositoryMateriaCarreraSemestre;
        this.iViewMapperMateriaCarreraSemestre = iViewMapperMateriaCarreraSemestre;
        this.iRepositoryMateria = iRepositoryMateria;
        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iRepositorySemestre = iRepositorySemestre;
    }

    @Override
    public Optional<Page<ViewMateriaCarreraSemestreDTO>> viewPagePageMateriaCarreraSemestreDTO(Pageable pageable) {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.pageEntitysToDtos(
                        this.iRepositoryMateriaCarreraSemestre.findAll(pageable)
                )
        );
    }

    @Override
    public Optional<Set<ViewMateriaCarreraSemestreDTO>> viewAllMateriaCarreraSemestreDTO() {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.entitysToDtos(
                        new HashSet<>(this.iRepositoryMateriaCarreraSemestre.findAll())
                )
        );
    }

    @Override
    public Optional<ViewMateriaCarreraSemestreDTO> viewByIdMateriaCarreraSemestreDTO(int id) {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.entityToDto(
                        this.iRepositoryMateriaCarreraSemestre.findById(id).orElse(null)
                )
        );
    }

    @Override
    public Optional<ViewMateriaCarreraSemestreDTO> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre command) {
        return Optional.ofNullable(
                this.iViewMapperMateriaCarreraSemestre.entityToDto(
                        this.iRepositoryMateriaCarreraSemestre.save(
                                new MateriaCarreraSemestreEntity(
                                        //se utiliza para obtener el valor máximo entre el
                                        // valor actual de idMateriaCarreraSemestre y cero (0)
                                        Math.max(command.getIdMateriaCarreraSemestre(), 0)
                                        , this.iRepositoryCarrera.findById(command.getIdCarrera())
                                        , this.iRepositoryMateria.findById(command.getSigla())
                                        , this.iRepositorySemestre.findById(command.getIdSemestre())
                                        , command.isActivo()
                                )
                        )
                )
        );

    }

    @Override
    public boolean deleteMateriaCarreraSemestre(int id) {
        return this.iRepositoryMateriaCarreraSemestre.findById(id).map(
                materiaCarreraSemestreEntity -> {
                    this.iRepositoryMateriaCarreraSemestre.delete(materiaCarreraSemestreEntity);
                    return true;
                }
        ).orElse(false);
    }

}
