package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.aula.IMapperAula;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryAula;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.aula.IDeleteOutPortAula;
import com.control.asistencia.application.port.out.aula.ISaveOrUpdateOutPortAula;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

@PersistenceAdapter
public class AulaPersistenceAdapter implements
        IViewOutPortAula ,
        ISaveOrUpdateOutPortAula ,
        IDeleteOutPortAula {

    private final IRepositoryAula iRepositoryAula;
    private final IMapperAula iMapperAula;
    public AulaPersistenceAdapter(
            IRepositoryAula iRepositoryAula,
            IMapperAula iMapperAula ){

        this.iRepositoryAula = iRepositoryAula;
        this.iMapperAula = iMapperAula;

    }

    @Override
    public Page<CommandAula> viewPageAulaDTO(Pageable pageable) {
        return this.iMapperAula.entitysToCommandsPage(
                this.iRepositoryAula.findAll(pageable)
        );
    }

    @Override
    public Optional<CommandAula> viewByIdAulaDTO(int idAula) {
        return Optional.of(
                this.iMapperAula.entityToCommand(
                        this.iRepositoryAula.findById(idAula)
                                .orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la aula con el id: " + idAula))
                )
        );
    }

    @Override
    public Optional<Set<CommandAula>> viewAllAulaDTO() {
        return Optional.of(
                this.iMapperAula.entitysToCommandsSet(
                        this.iRepositoryAula.findAll()
                )
        );
    }

    @Override
    public Optional<CommandAula> saveOrUpdateAula(CommandAula commandAula) {
        return Optional.of(
                this.iMapperAula.entityToCommand(
                        this.iRepositoryAula.save(
                                this.iMapperAula.dtoToEntity(commandAula)
                        )
                )
        );
    }

    @Override
    public boolean deleteAula(int idAula) {
        return this.iRepositoryAula.findById(idAula).map(
                aula -> {
                    this.iRepositoryAula.delete(aula);
                    return true;
                }
        ).orElseThrow(() -> new DataNotFoundExceptionMessage("No existe la aula con el id: " + idAula));
    }
}
