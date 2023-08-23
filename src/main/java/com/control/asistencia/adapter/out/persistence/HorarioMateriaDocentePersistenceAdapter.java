package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.horarioMateriaDocente.IMapperHorarioMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorario;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorarioMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaDocente;
import com.control.asistencia.application.port.in.asignarMateria.command.CommandHorarioMateriaDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.ISaveOrUpdateOutPortHorarioMateriaDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundException;

import java.util.HashSet;
import java.util.Set;

@PersistenceAdapter
public class HorarioMateriaDocentePersistenceAdapter implements
        ISaveOrUpdateOutPortHorarioMateriaDocente {
    private final IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente;
    private final IMapperHorarioMateriaDocente iMapperHorarioMateriaDocente;
    private final IRepositoryHorario iRepositoryHorario;
    private final IRepositoryMateriaDocente iRepositoryMateriaDocente;

    public HorarioMateriaDocentePersistenceAdapter(
            IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente ,
            IMapperHorarioMateriaDocente iMapperHorarioMateriaDocente ,
            IRepositoryHorario iRepositoryHorario ,
            IRepositoryMateriaDocente iRepositoryMateriaDocente) {

        this.iRepositoryHorarioMateriaDocente = iRepositoryHorarioMateriaDocente;
        this.iMapperHorarioMateriaDocente = iMapperHorarioMateriaDocente;
        this.iRepositoryHorario = iRepositoryHorario;
        this.iRepositoryMateriaDocente = iRepositoryMateriaDocente;
    }

    @Override
    public Set<CommandHorarioMateriaDocente> saveOrUpdateHorarioMateriaDocente(
            Set<CommandHorarioMateriaDocente> commands) {

        Set<CommandHorarioMateriaDocente> result = new HashSet<>();
        for (CommandHorarioMateriaDocente command : commands) {
            result.add(
                    this.iMapperHorarioMateriaDocente.entityToDto(
                            this.iRepositoryHorarioMateriaDocente.save(
                                    HorarioMateriaDocenteEntity.builder()
                                            .idHorarioMateriaDocente(command.getIdHorarioMateriaDocente())
                                            .materiaDocente(this.iRepositoryMateriaDocente.findById(command.getIdMateriaDocente())
                                                    .orElseThrow(() -> new DataNotFoundException("No existe la materiaDocente con el ID: " + command.getIdMateriaDocente()))
                                            )
                                            .horario(this.iRepositoryHorario.findById(command.getIdHorario())
                                                    .orElseThrow(() -> new DataNotFoundException("No existe la horario con el ID: " + command.getIdHorario()))
                                            )
                                            .build()
                            )
                    )
            );
        }
        return result;
    }
}
