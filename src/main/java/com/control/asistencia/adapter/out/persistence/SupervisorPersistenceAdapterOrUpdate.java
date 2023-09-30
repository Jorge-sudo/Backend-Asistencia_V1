package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import com.control.asistencia.adapter.out.persistence.mapper.supervisor.IMapperSupervisor;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;

import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class SupervisorPersistenceAdapterOrUpdate implements
        IViewOutPortSupervisor ,
        ISaveOrUpdateOutPortSupervisor ,
        IUpdateOutPortSupervisor {

    private final IRepositorySupervisor iRepositorySupervisor;
    private final IMapperSupervisor iMapperSupervisor;
    private final IRepositoryRol iRepositoryRol;
    public SupervisorPersistenceAdapterOrUpdate(
            IRepositorySupervisor iRepositorySupervisor ,
            IMapperSupervisor iMapperSupervisor ,
            IRepositoryRol iRepositoryRol) {

        this.iMapperSupervisor = iMapperSupervisor;
        this.iRepositorySupervisor = iRepositorySupervisor;
        this.iRepositoryRol = iRepositoryRol;
    }

    @Override
    public Set<SupervisorViewDTO> viewSetSupervisorDTO() {
        return this.iMapperSupervisor.entitysToDtosSet(
                this.iRepositorySupervisor.findAll()
        );
    }

    @Override
    public Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci) {
        return Optional.ofNullable(
                this.iMapperSupervisor.entityToDto(
                        this.iRepositorySupervisor.findById(ci)
                                .orElse(null)
                )
        );
    }

    @Override
    public Optional<SupervisorViewDTO> saveOrUpdateSupervisor(SaveCommandSupervisor command) {
        return Optional.of(
                this.iMapperSupervisor.entityToDto(
                        this.iRepositorySupervisor.save(
                                SupervisorEntity.builder()
                                        .ci(command.getCi())
                                        .nombre(command.getNombre())
                                        .apellido(command.getApellido())
                                        .fotografia(command.getFotografia())
                                        .email(command.getEmail())
                                        .genero(command.getGenero())
                                        .correoInstitucional(command.getCorreoInstitucional())
                                        .contrasenia(command.getContrasenia())
                                        .activo(command.isActivo())
                                        .rol(this.iRepositoryRol.findById(command.getRol())
                                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el rol con el ID: " + command.getRol())))
                                        .reporteEmail(command.isReporteEmail())
                                        .reporteInstitucional(command.isReporteInstitucional())
                                        .build()
                        )
                )
        );
    }

    @Override
    public boolean updateSupervisorActivo(UpdateActivoCommandSupervisor command) {
        SupervisorEntity supervisorEntity = this.iRepositorySupervisor.findById(command.getCi())
                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el supervisor con el CI: " + command.getCi()));
        supervisorEntity.setActivo(command.isActivo());
        supervisorEntity = this.iRepositorySupervisor.save(supervisorEntity);
        return supervisorEntity.isActivo() == command.isActivo();
    }
}
