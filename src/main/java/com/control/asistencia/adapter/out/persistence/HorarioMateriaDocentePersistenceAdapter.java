package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.horarioMateriaDocente.IMapperHorarioMateriaDocenteCommand;
import com.control.asistencia.adapter.out.persistence.mapper.horarioMateriaDocente.IMapperHorarioMateriaDocenteDTO;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorario;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorarioMateriaDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateriaDocente;
import com.control.asistencia.application.port.in.assignMateria.command.CommandHorarioMateriaDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.ISaveOrUpdateOutPortHorarioMateriaDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.IViewOutPortHorarioMateriaDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Set;

@PersistenceAdapter
public class HorarioMateriaDocentePersistenceAdapter implements
        ISaveOrUpdateOutPortHorarioMateriaDocente,
        IViewOutPortHorarioMateriaDocente {
    private final IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente;
    private final IMapperHorarioMateriaDocenteCommand iMapperHorarioMateriaDocenteCommand;
    private final IMapperHorarioMateriaDocenteDTO iMapperHorarioMateriaDocenteDTO;
    private final IRepositoryHorario iRepositoryHorario;
    private final IRepositoryMateriaDocente iRepositoryMateriaDocente;

    public HorarioMateriaDocentePersistenceAdapter(
            IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente ,
            IMapperHorarioMateriaDocenteCommand iMapperHorarioMateriaDocenteCommand,
            IRepositoryHorario iRepositoryHorario ,
            IRepositoryMateriaDocente iRepositoryMateriaDocente ,
            IMapperHorarioMateriaDocenteDTO iMapperHorarioMateriaDocenteDTO) {

        this.iRepositoryHorarioMateriaDocente = iRepositoryHorarioMateriaDocente;
        this.iMapperHorarioMateriaDocenteCommand = iMapperHorarioMateriaDocenteCommand;
        this.iRepositoryHorario = iRepositoryHorario;
        this.iRepositoryMateriaDocente = iRepositoryMateriaDocente;
        this.iMapperHorarioMateriaDocenteDTO = iMapperHorarioMateriaDocenteDTO;
    }

    @Override
    public Set<CommandHorarioMateriaDocente> saveOrUpdateHorarioMateriaDocente(
            Set<CommandHorarioMateriaDocente> commands) {

        Set<CommandHorarioMateriaDocente> result = new HashSet<>();
        for (CommandHorarioMateriaDocente command : commands) {
            result.add(
                    this.iMapperHorarioMateriaDocenteCommand.entityToCommand(
                            this.iRepositoryHorarioMateriaDocente.save(
                                    HorarioMateriaDocenteEntity.builder()
                                            .idHorarioMateriaDocente(command.getIdHorarioMateriaDocente())
                                            .materiaDocenteEntity(this.iRepositoryMateriaDocente.findById(command.getIdMateriaDocente())
                                                    .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la materiaDocente con el ID: " + command.getIdMateriaDocente()))
                                            )
                                            .horarioEntity(this.iRepositoryHorario.findById(command.getIdHorario())
                                                    .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la horario con el ID: " + command.getIdHorario()))
                                            )
                                            .build()
                            )
                    )
            );
        }
        return result;
    }

    @Override
    public Page<HorarioMateriaDocenteDTO> viewPageHorarioMateriaDocenteDTO(Pageable pageable) {
        return this.iMapperHorarioMateriaDocenteDTO.entitysToDtosPage(
                this.iRepositoryHorarioMateriaDocente.findAll(pageable)
        );
    }

    @Override
    public Set<HorarioMateriaDocenteDTO> viewByDocenteAndDiaDTO(Long ci, String dia) {
        return this.iMapperHorarioMateriaDocenteDTO.entitysToDtosSet(
                this.iRepositoryHorarioMateriaDocente.findByDocenteAndDia(ci, dia)
        );
    }
}
