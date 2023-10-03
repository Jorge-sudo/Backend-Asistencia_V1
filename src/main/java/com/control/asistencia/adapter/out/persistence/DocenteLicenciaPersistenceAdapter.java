package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.adapter.out.persistence.entity.DocenteLicenciaEntity;
import com.control.asistencia.adapter.out.persistence.mapper.docenteLicencia.IMapperDocenteLicencia;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocenteLicencia;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryLicencia;
import com.control.asistencia.application.port.in.docenteLicencia.command.SaveCommandDocenteLicencia;
import com.control.asistencia.application.port.out.docenteLicencia.ISaveOrUpdateOutPortDocenteLicencia;
import com.control.asistencia.application.port.out.docenteLicencia.IViewOutPortDocenteLicencia;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.docenteLicencia.DocenteLicenciaDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

@PersistenceAdapter
public class DocenteLicenciaPersistenceAdapter implements
        IViewOutPortDocenteLicencia ,
        ISaveOrUpdateOutPortDocenteLicencia {
    private final IRepositoryDocenteLicencia iRepositoryDocenteLicencia;
    private final IRepositoryDocente iRepositoryDocente;
    private final IRepositoryLicencia iRepositoryLicencia;
    private final IMapperDocenteLicencia iMapperDocenteLicencia;
    public DocenteLicenciaPersistenceAdapter(
            IRepositoryDocenteLicencia iRepositoryDocenteLicencia ,
            IMapperDocenteLicencia iMapperDocenteLicencia ,
            IRepositoryDocente iRepositoryDocente ,
            IRepositoryLicencia iRepositoryLicencia) {

        this.iRepositoryDocenteLicencia = iRepositoryDocenteLicencia;
        this.iMapperDocenteLicencia = iMapperDocenteLicencia;
        this.iRepositoryDocente = iRepositoryDocente;
        this.iRepositoryLicencia = iRepositoryLicencia;
    }
    @Override
    public Optional<DocenteLicenciaDTO> saveOrUpdateDocenteLicencia(SaveCommandDocenteLicencia command) {
        return Optional.of(
                this.iMapperDocenteLicencia.entityToDto(
                        this.iRepositoryDocenteLicencia.save(
                                DocenteLicenciaEntity.builder()
                                        .idDocenteLicencia(command.getIdDocenteLicencia())
                                        .docente(
                                                this.iRepositoryDocente.findById(command.getCi())
                                                        .orElseThrow( () -> new DataNotFoundExceptionMessage("No existe el docente con el CI: " + command.getCi() ))
                                        )
                                        .licencia(
                                                this.iRepositoryLicencia.findById(command.getIdLicencia())
                                                        .orElseThrow( () -> new DataNotFoundExceptionMessage("No existe la licencia con el ID: " + command.getIdLicencia()))
                                        )
                                        .build()
                        )
                )
        );
    }

    @Override
    public Page<DocenteLicenciaDTO> viewPageActiveDocenteLicenciaDTO(Pageable pageable ) {
        return this.iMapperDocenteLicencia.entitysToDtosPage(
                this.iRepositoryDocenteLicencia.findAllAtTheMoment(
                        new Date(),
                        pageable
                )
        );
    }


    @Override
    public Page<DocenteLicenciaDTO> viewPageInactiveDocenteLicenciaDTO(Pageable pageable) {
        return this.iMapperDocenteLicencia.entitysToDtosPage(
                this.iRepositoryDocenteLicencia.findAllPrevious(
                        new Date(),
                        pageable
                )
        );
    }

    @Override
    public Page<DocenteLicenciaDTO> viewPageFilterGlobalDocenteLicenciaDTO(Pageable pageable, String globalFilter) {
        return this.iMapperDocenteLicencia.entitysToDtosPage(
                this.iRepositoryDocenteLicencia.findAll(
                        this.funFilterGlobal(globalFilter),
                        pageable
                )
        );
    }

    private Example<DocenteLicenciaEntity> funFilterGlobal(String globalFilter) {
        return Example.of(

                DocenteLicenciaEntity.builder()
                        .docente(
                                DocenteEntity.builder()
                                        .nombre(globalFilter)
                                        .apellido(globalFilter)
                                        .build()
                        )
                        .build(),

                ExampleMatcher.matchingAny() // Cambiar  por matching()
                        .withMatcher("docente.nombre", match -> match.contains().ignoreCase())
                        .withMatcher("docente.apellido", match -> match.contains().ignoreCase())
                        .withIgnorePaths(
                                "idDocenteLicencia", "licencia",
                                "docente.ci", "docente.fotografia", "docente.email", "docente.genero",
                                "docente.correoInstitucional", "docente.activo", "docente.rol",
                                "docente.codRfid")
        );
    }
}
