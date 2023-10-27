package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.HorarioEntity;
import com.control.asistencia.adapter.out.persistence.mapper.horario.IMapperHorarioCommand;
import com.control.asistencia.adapter.out.persistence.mapper.horario.IMapperHorarioDTO;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDiaSemana;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorario;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryTurno;
import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;
import com.control.asistencia.application.port.out.horario.IDeleteOutPortHorario;
import com.control.asistencia.application.port.out.horario.ISaveOrUpdateOutPortHorario;
import com.control.asistencia.application.port.out.horario.IViewOutPortHorario;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.horario.HorarioViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class HorarioPersistenceAdapter implements
        IViewOutPortHorario,
        ISaveOrUpdateOutPortHorario,
        IDeleteOutPortHorario {
    private final IRepositoryHorario iRepositoryHorario;
    private final IMapperHorarioDTO iMapperHorarioDTO;
    private final IMapperHorarioCommand iMapperHorarioCommand;
    private final IRepositoryDiaSemana iRepositoryDiaSemana;
    private final IRepositoryTurno iRepositoryTurno;
    public HorarioPersistenceAdapter (
            IRepositoryHorario repositoryHorario ,
            IMapperHorarioDTO mapperHorarioDTO ,
            IMapperHorarioCommand mapperHorarioCommand ,
            IRepositoryDiaSemana repositoryDiaSemana ,
            IRepositoryTurno repositoryTurno){

        this.iRepositoryHorario = repositoryHorario;
        this.iMapperHorarioDTO = mapperHorarioDTO;
        this.iMapperHorarioCommand = mapperHorarioCommand;
        this.iRepositoryDiaSemana = repositoryDiaSemana;
        this.iRepositoryTurno = repositoryTurno;
    }

    @Override
    public boolean deleteHorario(int idHorario) {
        return this.iRepositoryHorario.findById(idHorario)
                .map(horarioEntity -> {
                    this.iRepositoryHorario.delete(horarioEntity);
                    return true;
                }).orElse(false);
    }

    @Override
    public Optional<SaveCommandHorario> saveOrUpdateHorario(SaveCommandHorario saveCommandHorario) {
        return Optional.of(
                this.iMapperHorarioCommand.entityToCommand(
                        this.iRepositoryHorario.save(
                                HorarioEntity.builder()
                                        .idHorario(saveCommandHorario.getIdHorario())
                                        .horaInicio(saveCommandHorario.getHoraInicio())
                                        .horaFin(saveCommandHorario.getHoraFin())
                                        .diaSemana(
                                                this.iRepositoryDiaSemana.findById(saveCommandHorario.getIdDia())
                                                        .orElseThrow(() ->
                                                                new DataNotFoundExceptionMessage(
                                                                        "No existe el diaSemana con el id: "+saveCommandHorario.getIdDia()))
                                        )
                                        .turno(
                                                this.iRepositoryTurno.findById(saveCommandHorario.getIdTurno())
                                                        .orElseThrow(() ->
                                                                new DataNotFoundExceptionMessage(
                                                                        "No existe el turno con el id: "+saveCommandHorario.getIdTurno()))
                                        )
                                        .build()
                        )
                )
        );
    }

    @Override
    public Page<HorarioViewDTO> viewPageHorario(Pageable pageable) {
        return this.iMapperHorarioDTO.entitysToDtosPage(
                this.iRepositoryHorario.findAll(pageable)
        );
    }

    @Override
    public Optional<Set<HorarioViewDTO>> viewAllHorario() {
        return Optional.of(
                this.iMapperHorarioDTO.entitysToDtosSet(
                        this.iRepositoryHorario.findAll()
                )
        );
    }
}
