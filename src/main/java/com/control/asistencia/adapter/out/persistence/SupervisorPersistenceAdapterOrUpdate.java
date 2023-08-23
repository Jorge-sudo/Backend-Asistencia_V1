package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import com.control.asistencia.adapter.out.persistence.mapper.supervisor.IMapperSupervisor;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundException;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class SupervisorPersistenceAdapterOrUpdate implements
        IViewOutPortSupervisor ,
        ISaveOrUpdateOutPortSupervisor {

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
    public Page<SupervisorViewDTO> viewPageSupervisorDTO(Pageable pageable) {
        return this.iMapperSupervisor.entitysToDtosPage(
                this.iRepositorySupervisor.findAll(pageable)
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
                                                .orElseThrow(() -> new DataNotFoundException("No existe el rol con el ID: " + command.getRol())))
                                        .reporteEmail(command.isReporteEmail())
                                        .reporteInstitucional(command.isReporteInstitucional())
                                        .build()
                        )
                )
        );
    }
}
