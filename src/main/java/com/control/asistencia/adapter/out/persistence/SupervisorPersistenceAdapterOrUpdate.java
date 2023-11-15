package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.SupervisorEntity;
import com.control.asistencia.adapter.out.persistence.mapper.supervisor.MapperSupervisor;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySupervisor;
import com.control.asistencia.application.port.in.supervisor.command.SaveCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdateActivoCommandSupervisor;
import com.control.asistencia.application.port.in.supervisor.command.UpdatePerfilCommandSupervisor;
import com.control.asistencia.application.port.out.supervisor.ISaveOrUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IUpdateOutPortSupervisor;
import com.control.asistencia.application.port.out.supervisor.IViewOutPortSupervisor;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.supervisor.SupervisorViewDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class SupervisorPersistenceAdapterOrUpdate implements
        IViewOutPortSupervisor ,
        ISaveOrUpdateOutPortSupervisor ,
        IUpdateOutPortSupervisor {

    private final IRepositorySupervisor iRepositorySupervisor;
    private final MapperSupervisor mapperSupervisor;
    private final IRepositoryRol iRepositoryRol;
    private final PasswordEncoder passwordEncoder;
    public SupervisorPersistenceAdapterOrUpdate(
            IRepositorySupervisor iRepositorySupervisor ,
            MapperSupervisor mapperSupervisor,
            IRepositoryRol iRepositoryRol,
            PasswordEncoder passwordEncoder) {

        this.mapperSupervisor = mapperSupervisor;
        this.iRepositorySupervisor = iRepositorySupervisor;
        this.iRepositoryRol = iRepositoryRol;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<SupervisorViewDTO> viewSetSupervisorDTO() {
        return this.mapperSupervisor.entitysToDtosSet(
                this.iRepositorySupervisor.findAll()
        );
    }

    @Override
    public Optional<SupervisorViewDTO> viewByCiSupervisorDTO(Long ci) {
        return Optional.ofNullable(
                this.mapperSupervisor.entityToDto(
                        this.iRepositorySupervisor.findById(ci)
                                .orElse(null)
                )
        );
    }

    @Override
    public Optional<SupervisorViewDTO> saveOrUpdateSupervisor(SaveCommandSupervisor command) {
        return Optional.of(
                this.mapperSupervisor.entityToDto(
                        this.iRepositorySupervisor.save(
                                SupervisorEntity.builder()
                                        .ci(command.getCi())
                                        .nombre(command.getNombre())
                                        .apellido(command.getApellido())
                                        .fotografia(command.getFotografia())
                                        .email(command.getEmail())
                                        .genero(command.getGenero())
                                        .correoInstitucional(command.getCorreoInstitucional())
                                        .contrasenia(this.passwordEncoder.encode(command.getContrasenia()))
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

    @Override
    public boolean updateSupervisorPerfil(UpdatePerfilCommandSupervisor command) {
        return  this.iRepositorySupervisor.findById(command.getCi())
                .map(supervisorEntity -> {
                            supervisorEntity.setEmail(command.getEmail());
                            supervisorEntity.setActivo(command.isActivo());
                            supervisorEntity.setReporteEmail(command.isReporteEmail());
                            supervisorEntity.setReporteInstitucional(command.isReporteInstitucional());
                            this.iRepositorySupervisor.save(supervisorEntity);
                            return true;
                        }
                ).orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el supervisor con el CI: " + command.getCi()));
    }
}
