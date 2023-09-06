package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.AulaMateriaDocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.aulaMateriaDocente.IMapperAulaMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.*;
import com.control.asistencia.application.port.in.assignMateria.command.CommandAulaMateriaDocente;
import com.control.asistencia.application.port.out.aulaMateriaDocente.ISaveOrUpdateOutPortAulaMateriaDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;

import java.util.Optional;

@PersistenceAdapter
public class AulaMateriaDocentePersistenceAdapter implements
        ISaveOrUpdateOutPortAulaMateriaDocente {

    private final IRepositoryAulaMateriaDocente iRepositoryAulaMateriaDocente;
    private final IRepositoryAula iRepositoryAula;
    private final IRepositoryMateriaDocente iRepositoryMateriaDocente;
    private final IMapperAulaMateriaDocente iMapperAulaMateriaDocente;
    public AulaMateriaDocentePersistenceAdapter(
            IRepositoryAulaMateriaDocente iRepositoryAulaMateriaDocente ,
            IRepositoryAula iRepositoryAula ,
            IRepositoryMateriaDocente iRepositoryMateriaDocente ,
            IMapperAulaMateriaDocente iMapperAulaMateriaDocente) {

        this.iRepositoryAulaMateriaDocente = iRepositoryAulaMateriaDocente;
        this.iRepositoryAula = iRepositoryAula;
        this.iRepositoryMateriaDocente = iRepositoryMateriaDocente;
        this.iMapperAulaMateriaDocente = iMapperAulaMateriaDocente;
    }
    @Override
    public Optional<CommandAulaMateriaDocente> saveOrUpdateAulaMateriaDocente(
            CommandAulaMateriaDocente command) {
        return Optional.of(
                this.iMapperAulaMateriaDocente.entityToCommand(
                        this.iRepositoryAulaMateriaDocente.save(
                                AulaMateriaDocenteEntity.builder()
                                        .idAulaMateriaDocente(command.getIdAulaMateriaDocente())
                                        .materiaDocente(this.iRepositoryMateriaDocente.findById(command.getIdMateriaDocente())
                                                        .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materiaDocente con el ID: " + command.getIdMateriaDocente()))
                                        )
                                        .aula(this.iRepositoryAula.findById(command.getIdAula())
                                                        .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la aula con el ID: " + command.getIdAula()))
                                        )
                                        .build()
                        )
                )
        );
    }
}
