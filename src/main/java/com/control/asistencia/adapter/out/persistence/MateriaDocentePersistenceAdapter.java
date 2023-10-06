package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.MateriaDocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.materiaDocente.IMapperMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
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
    private final IRepositoryMateria iRepositoryMateria;
    private final IRepositoryDocente iRepositoryDocente;
    private final IMapperMateriaDocente iMapperMateriaDocente;
    public MateriaDocentePersistenceAdapter(
            IRepositoryMateriaDocente iRepositoryMateriaDocente ,
            IRepositoryMateria iRepositoryMateria ,
            IRepositoryDocente iRepositoryDocente ,
            IMapperMateriaDocente iMapperMateriaDocente) {

        this.iRepositoryMateriaDocente = iRepositoryMateriaDocente;
        this.iRepositoryMateria = iRepositoryMateria;
        this.iRepositoryDocente = iRepositoryDocente;
        this.iMapperMateriaDocente = iMapperMateriaDocente;
    }

    @Override
    public Optional<CommandMateriaDocente> saveOrUpdateMateriaDocente(
            CommandMateriaDocente command) {

        return Optional.of(
                this.iMapperMateriaDocente.entityToCommand(
                        this.iRepositoryMateriaDocente.save(
                                MateriaDocenteEntity.builder()
                                        .idMateriaDocente(command.getIdMateriaDocente())
                                        .materia(this.iRepositoryMateria.findById(command.getSigla())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materia con el ID: " + command.getSigla()))
                                        )
                                        .docente(this.iRepositoryDocente.findById(command.getCi())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la docente con el ID: " + command.getCi()))
                                        )
                                        .build()
                        )
                )
        );
    }
}
