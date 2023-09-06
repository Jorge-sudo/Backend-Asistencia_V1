package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaCommand;
import com.control.asistencia.adapter.out.persistence.mapper.asistencia.IMapperAsistenciaDTO;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryAsistencia;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryAula;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryHorarioMateriaDocente;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.application.port.out.asistencia.IViewOutPortAsistencia;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.asistencia.AsistenciaViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class AsistenciaPersistenceAdapter implements
        IViewOutPortAsistencia,
        ISaveOrUpdateOutPortAsistencia {

    private final IRepositoryAsistencia iRepositoryAsistencia;
    private final IRepositoryAula  iRepositoryAula;
    private final IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente;
    private final IMapperAsistenciaDTO iMapperAsistenciaDTO;
    private final IMapperAsistenciaCommand iMapperAsistenciaCommand;
    public AsistenciaPersistenceAdapter(
            IRepositoryAsistencia iRepositoryAsistencia ,
            IMapperAsistenciaDTO iMapperAsistenciaDTO ,
            IRepositoryAula iRepositoryAula ,
            IRepositoryHorarioMateriaDocente iRepositoryHorarioMateriaDocente ,
            IMapperAsistenciaCommand iMapperAsistenciaCommand){

        this.iRepositoryAsistencia = iRepositoryAsistencia;
        this.iRepositoryAula = iRepositoryAula;
        this.iRepositoryHorarioMateriaDocente = iRepositoryHorarioMateriaDocente;
        this.iMapperAsistenciaDTO = iMapperAsistenciaDTO;
        this.iMapperAsistenciaCommand = iMapperAsistenciaCommand;
    }

    @Override
    public Optional<CommandAsistencia> saveOrUpdateAsistencia(CommandAsistencia commandAsistencia) {
        return Optional.of(
                this.iMapperAsistenciaCommand.entityToCommand(
                        this.iRepositoryAsistencia.save(
                                AsistenciaEntity.builder()
                                        .idAsistencia(commandAsistencia.getIdAsistencia())
                                        .horaEntrada(commandAsistencia.getHoraEntrada())
                                        .cantidadEstudiantes(commandAsistencia.getCantidadEstudiantes())
                                        .fecha(commandAsistencia.getFecha())
                                        .estado(commandAsistencia.getEstado())
                                        .aulaEntity(
                                                this.iRepositoryAula.findById(commandAsistencia.getIdAula()).orElseThrow(
                                                        () -> new DataNotFoundExceptionMessage(
                                                                "No existe la aula con el ID: " + commandAsistencia.getIdAula()
                                                        )
                                                )
                                        )
                                        .horarioMateriaDocenteEntity(
                                                this.iRepositoryHorarioMateriaDocente.findById(commandAsistencia.getIdHorarioMateriaDocente()).orElseThrow(
                                                        () -> new DataNotFoundExceptionMessage(
                                                                "No existe el horarioMateriaDocente con el ID: " + commandAsistencia.getIdHorarioMateriaDocente()
                                                        )
                                                )
                                        )
                                        .build()
                        )
                )
        );
    }

    @Override
    public Page<AsistenciaViewDTO> viewPageAsistencia(Pageable pageable) {
        return this.iMapperAsistenciaDTO.entitysToDtosPage(
                this.iRepositoryAsistencia.findAll(pageable)
        );
    }
}
