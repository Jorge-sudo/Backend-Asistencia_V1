package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.*;
import com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre.IViewMapperMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.SaveCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.UpdateActivoCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IDeleteOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.ISaveOrUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IUpdateOutPortMateriaCarreraSemestre;
import com.control.asistencia.application.port.out.materiaCarreraSemestre.IViewOutPortMateriaCarreraSemestre;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.materiaCarreraSemestre.MateriaCarreraSemestreViewDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;

import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@PersistenceAdapter
public class MateriaCarreraSemestrePersistenceAdapter implements
        IViewOutPortMateriaCarreraSemestre,
        ISaveOrUpdateOutPortMateriaCarreraSemestre,
        IDeleteOutPortMateriaCarreraSemestre  ,
        IUpdateOutPortMateriaCarreraSemestre {
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
    public Page<MateriaCarreraSemestreViewDTO> viewPageMateriaCarreraSemestreDTO(String globalFilter,Pageable pageable) {
        
        return this.iViewMapperMateriaCarreraSemestre.entitysToDtosPage(
                globalFilter == null
                        ? this.iRepositoryMateriaCarreraSemestre.findAll(pageable)
                        : this.iRepositoryMateriaCarreraSemestre.findAll(this.funFilterGlobal(globalFilter), pageable)
        );
    }

    @Override
    public Optional<Set<MateriaCarreraSemestreViewDTO>> viewAllMateriaCarreraSemestreDTO() {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.entitysToDtosSet(
                        new HashSet<>(this.iRepositoryMateriaCarreraSemestre.findAll())
                )
        );
    }

    @Override
    public Optional<MateriaCarreraSemestreViewDTO> viewByIdMateriaCarreraSemestreDTO(int id) {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.entityToDto(
                        this.iRepositoryMateriaCarreraSemestre.findById(id)
                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe materiaCarreraSemestre con el ID: " + id))
                )
        );
    }

    @Override
    public Optional<Set<MateriaCarreraSemestreViewDTO>> viewBySiglaMateriaCarreraSemestreDTO(String sigla) {
        return Optional.of(
                this.iViewMapperMateriaCarreraSemestre.entitysToDtosSet(
                        this.iRepositoryMateriaCarreraSemestre.findBySigla(sigla)
                )
        );
    }


    @Override
    public Optional<MateriaCarreraSemestreViewDTO> saveOrUpdateMateriaCarreraSemestre(
            SaveCommandMateriaCarreraSemestre command) {
        return Optional.ofNullable(
                this.iViewMapperMateriaCarreraSemestre.entityToDto(
                        this.iRepositoryMateriaCarreraSemestre.save(
                                MateriaCarreraSemestreEntity.builder()
                                        .idMateriaCarreraSemestre(Math.max(command.getIdMateriaCarreraSemestre(), 0))
                                        .materia(this.iRepositoryMateria.findById(command.getSigla())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materia con la sigla: " + command.getSigla()))
                                        )
                                        .carrera(this.iRepositoryCarrera.findById(command.getIdCarrera())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la carrera con el ID: " + command.getIdCarrera()))
                                        )
                                        .semestre(this.iRepositorySemestre.findById(command.getIdSemestre())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el semestre con el ID: " + command.getIdSemestre()))
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
        ).orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materiaCarreraSemestre con el ID: " + id));
    }

    @Override
    public boolean updateMateriaCarreraSemestreActivo(UpdateActivoCommandMateriaCarreraSemestre command) {
        return this.iRepositoryMateriaCarreraSemestre.findById(command.getIdMateriaCarreraSemestre()).map(
                materiaCarreraSemestreEntity -> {
                    materiaCarreraSemestreEntity.setActivo(command.isActivo());
                    this.iRepositoryMateriaCarreraSemestre.save(materiaCarreraSemestreEntity);
                    return true;
                }
        ).orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materiaCarreraSemestre con el ID: " + command.getIdMateriaCarreraSemestre()));
    }

    private Example<MateriaCarreraSemestreEntity> funFilterGlobal(String globalFilter) {
        return Example.of(
                MateriaCarreraSemestreEntity.builder()
                        .carrera(
                                CarreraEntity.builder()
                                        .nombre(globalFilter)
                                        .build()
                        )
                        .materia(
                                MateriaEntity.builder()
                                        .sigla(globalFilter)
                                        .nombre(globalFilter)
                                        .build()
                        )
                        .semestre(
                                SemestreEntity.builder()
                                        .nombre(globalFilter)
                                        .build()
                        )
                        .build(),

                ExampleMatcher.matchingAny() // Cambiar  por matching()
                        .withMatcher("carrera.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("materia.sigla", match -> match.contains().ignoreCase())
                        .withMatcher("materia.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("semestre.nombre", match -> match.contains().ignoreCase())

                        .withIgnorePaths(
                                "idMateriaCarreraSemestre", "carrera.idCarrera",
                                "semestre.idSemestre",  "activo")
        );
    }
}
