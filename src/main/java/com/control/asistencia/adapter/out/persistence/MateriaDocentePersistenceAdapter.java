package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.MateriaDocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.materiaDocente.IMapperMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaCarreraSemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaDocente;
import com.control.asistencia.application.port.in.asignatura.command.CommandMateriaDocente;
import com.control.asistencia.application.port.out.materiaDocente.ISaveOrUpdateOutPortMateriaDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;

import java.util.Optional;

@PersistenceAdapter
public class MateriaDocentePersistenceAdapter implements
        ISaveOrUpdateOutPortMateriaDocente {

    private final IRepositoryMateriaDocente iRepositoryMateriaDocente;
    private final IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre;
    private final IRepositoryDocente iRepositoryDocente;
    private final IMapperMateriaDocente iMapperMateriaDocente;
    public MateriaDocentePersistenceAdapter(
            IRepositoryMateriaDocente iRepositoryMateriaDocente ,
            IRepositoryDocente iRepositoryDocente ,
            IMapperMateriaDocente iMapperMateriaDocente ,
            IRepositoryMateriaCarreraSemestre iRepositoryMateriaCarreraSemestre) {

        this.iRepositoryMateriaDocente = iRepositoryMateriaDocente;
        this.iRepositoryDocente = iRepositoryDocente;
        this.iMapperMateriaDocente = iMapperMateriaDocente;
        this.iRepositoryMateriaCarreraSemestre = iRepositoryMateriaCarreraSemestre;
    }

    @Override
    public Optional<CommandMateriaDocente> saveOrUpdateMateriaDocente(
            CommandMateriaDocente command) {

        return Optional.of(
                this.iMapperMateriaDocente.entityToCommand(
                        this.iRepositoryMateriaDocente.save(
                                MateriaDocenteEntity.builder()
                                        .idMateriaDocente(command.getIdMateriaDocente())
                                        .materiaCarreraSemestre(
                                                this.iRepositoryMateriaCarreraSemestre.findById(command.getIdMateriaCarreraSemestre())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe materiaCarreraSemestre con el ID: " + command.getIdMateriaCarreraSemestre()))
                                        )
                                        .docente(
                                                this.iRepositoryDocente.findById(command.getCi())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la docente con el CI: " + command.getCi()))
                                        )
                                        .build()
                        )
                )
        );
    }
}
