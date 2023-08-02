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
public class MateriaCarreraSemestrePersistenceAdapter implements IViewOutPortMateriaCarreraSemestre,
        ISaveOrUpdateOutPortMateriaCarreraSemestre, IDeleteOutPortMateriaCarreraSemestre  {
    private final IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre;
    private final IViewMapperMateriaCarreraSemestre iViewMapperMateriaCarreraSemestre;
    private final IRepositoryMateria iRepositoryMateria;
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositorySemestre iRepositorySemestre;
    public MateriaCarreraSemestrePersistenceAdapter(IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre
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
                        this.iRepositoryMateriaCarreraSemestre.findById(id)
                                .orElseThrow(() -> new RuntimeException("No existe materiaCarreraSemestre con el ID: " + id))
                )
        );
    }


    @Override
    public Optional<ViewMateriaCarreraSemestreDTO> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre command) {
        return Optional.ofNullable(
                this.iViewMapperMateriaCarreraSemestre.entityToDto(
                        this.iRepositoryMateriaCarreraSemestre.save(
                                MateriaCarreraSemestreEntity.builder()
                                        .idMateriaCarreraSemestre(Math.max(command.getIdMateriaCarreraSemestre(), 0))
                                        .materia(this.iRepositoryMateria.findById(command.getSigla())
                                                .orElseThrow(() -> new RuntimeException("No existe la materia con la sigla: " + command.getSigla()))
                                        )
                                        .carrera(this.iRepositoryCarrera.findById(command.getIdCarrera())
                                                .orElseThrow(() -> new RuntimeException("No existe la carrera con el ID: " + command.getIdCarrera()))
                                        )
                                        .semestre(this.iRepositorySemestre.findById(command.getIdSemestre())
                                                .orElseThrow(() -> new RuntimeException("No existe el semestre con el ID: " + command.getIdSemestre()))
                                        )
                                        .activo(command.isActivo())
                                        .build()
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
        ).orElseThrow(() -> new RuntimeException("No existe la materiaCarreraSemestre con el ID: " + id));
    }

}
