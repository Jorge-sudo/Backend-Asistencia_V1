package com.control.asistencia.adapter.out.persistence;


import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.docente.IMapperDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;
import com.control.asistencia.application.port.out.docente.ISaveOrUpdateOutPortDocente;
import com.control.asistencia.application.port.out.docente.IUpdateOutPortDocente;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class DocentePersistenceAdapterOrUpdate implements
            IViewOutPortDocente ,
            ISaveOrUpdateOutPortDocente ,
            IUpdateOutPortDocente {
    private final IRepositoryDocente iRepositoryDocente;
    private final IRepositoryRol iRepositoryRol;
    private final IMapperDocente iMapperDocente;
    public DocentePersistenceAdapterOrUpdate(
            IRepositoryDocente iRepositoryDocente ,
            IMapperDocente iMapperDocente ,
            IRepositoryRol iRepositoryRol) {

        this.iRepositoryDocente = iRepositoryDocente;
        this.iMapperDocente = iMapperDocente;
        this.iRepositoryRol = iRepositoryRol;
    }

    @Override
    public Page<DocenteViewDTO> viewPageDocenteDTO(String globalFilter, Pageable pageable){
        Example<DocenteEntity> example = Example.of(
                DocenteEntity.builder()
                        .nombre(globalFilter)
                        .apellido(globalFilter)
                        .build(),
                ExampleMatcher.matchingAny() // Cambiar  por matching()
                        .withMatcher("nombre", match -> match.contains().ignoreCase())
                        .withMatcher("apellido", match -> match.contains().ignoreCase())
                        .withIgnorePaths(
                                "ci", "fotografia",
                                "email", "genero",
                                "correoInstitucional", "activo",
                                "rol", "codRfid")
        );

        return this.iMapperDocente.entitysToDtosPage(
                globalFilter == null
                        ? this.iRepositoryDocente.findAll(pageable)
                        : this.iRepositoryDocente.findAll(example, pageable)
        );
    }

    @Override
    public Optional<DocenteViewDTO> viewByCiDocenteDTO(Long ci) {
        return Optional.ofNullable(
                this.iMapperDocente.entityToDto(
                        this.iRepositoryDocente.findById(ci)
                                .orElse(null)
                )
        );
    }

    @Override
    public Optional<DocenteViewDTO> viewByCodigoRfidDocenteDTO(String codigoRfid) {
        return Optional.ofNullable(
                this.iMapperDocente.entityToDto(
                        this.iRepositoryDocente.findByCodRfid(codigoRfid)
                )
        );
    }

    @Override
    public Optional<DocenteViewDTO> saveOrUpdateDocente(SaveCommandDocente command) {
        return Optional.of(
                this.iMapperDocente.entityToDto(
                        this.iRepositoryDocente.save(
                                DocenteEntity.builder()
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
                                        .codRfid(command.getCodRfid())
                                        .build()

                        )
                )
        );
    }

    @Override
    public boolean updateDocenteActivo(UpdateActivoCommandDocente command) {
        DocenteEntity docenteEntity = this.iRepositoryDocente.findById(command.getCi())
                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe el docente con el CI: " + command.getCi()));
        docenteEntity.setActivo(command.isActivo());
        docenteEntity = this.iRepositoryDocente.save(docenteEntity);
        return docenteEntity.isActivo() == command.isActivo();
    }
}
