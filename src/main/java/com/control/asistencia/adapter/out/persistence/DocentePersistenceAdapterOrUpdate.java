package com.control.asistencia.adapter.out.persistence;


import com.control.asistencia.adapter.out.persistence.entity.DocenteEntity;
import com.control.asistencia.adapter.out.persistence.mapper.docente.IMapperDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDocente;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryRol;
import com.control.asistencia.application.port.in.docente.command.SaveCommandDocente;
import com.control.asistencia.application.port.out.docente.ISaveOrUpdateOutPortDocente;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class DocentePersistenceAdapterOrUpdate implements
            IViewOutPortDocente ,
            ISaveOrUpdateOutPortDocente {
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
    public Optional<Page<DocenteViewDTO>> viewPageDocenteDTO(Pageable pageable){
        return Optional.of(
                this.iMapperDocente.pageEntitysToDtos(
                        this.iRepositoryDocente.findAll(pageable)
                )
        );
    }

    @Override
    public Optional<DocenteViewDTO> viewByCiDocenteDTO(Long ci) {
        return Optional.of(
                this.iMapperDocente.entityToDto(
                        this.iRepositoryDocente.findById(ci)
                                .orElseThrow(() -> new RuntimeException("No existe el docente con el ID: " + ci))
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
                                                .orElseThrow(() -> new RuntimeException("No existe el rol con el ID: " + command.getRol())))
                                        .codRfid(command.getCodRfid())
                                        .build()

                        )
                )
        );
    }
}
