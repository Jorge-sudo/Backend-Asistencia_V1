package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.licencia.IMapperLicencia;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryLicencia;
import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
import com.control.asistencia.application.port.out.licencia.ISaveOrUpdateOutPortLicencia;
import com.control.asistencia.application.port.out.licencia.IViewOutPortLicencia;
import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class LicenciaPersistenceAdapter implements
        IViewOutPortLicencia ,
        ISaveOrUpdateOutPortLicencia {

    private final IRepositoryLicencia iRepositoryLicencia;
    private final IMapperLicencia iMapperLicencia;
    public LicenciaPersistenceAdapter(
            IRepositoryLicencia iRepositoryLicencia,
            IMapperLicencia iMapperLicencia) {

        this.iRepositoryLicencia = iRepositoryLicencia;
        this.iMapperLicencia = iMapperLicencia;
    }

    @Override
    public Optional<CommandSaveOrViewLicencia> saveOrUpdateLicencia(
            CommandSaveOrViewLicencia commandSaveOrViewLicencia) {
        return Optional.of(
                this.iMapperLicencia.entityToCommand(
                        this.iRepositoryLicencia.save(
                                this.iMapperLicencia.commandToEntity(
                                        commandSaveOrViewLicencia
                                )
                        )
                )
        );
    }

    @Override
    public Page<CommandSaveOrViewLicencia> viewPageLicencia(Pageable pageable) {
        return this.iMapperLicencia.entityToCommandPage(
                this.iRepositoryLicencia.findAll(pageable)
        );
    }
}
