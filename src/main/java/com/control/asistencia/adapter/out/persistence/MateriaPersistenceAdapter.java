package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.materia.IMapperMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.config.exception.exceptions.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class MateriaPersistenceAdapter implements
                IViewOutPortMateria ,
                ISaveOrUpdateOutPortMateria ,
                IDeleteOutPortMateria {

    private final IRepositoryMateria iRepositoryMateria;
    private final IMapperMateria iMapperMateria;
    public MateriaPersistenceAdapter(IRepositoryMateria repositoryMateria
                , IMapperMateria mapperMateria){
        this.iRepositoryMateria = repositoryMateria;
        this.iMapperMateria = mapperMateria;
    }

    @Override
    public Page<CommandMateria> viewPageMateria(Pageable pageable) {
        return this.iMapperMateria.entitysToCommandsPage(
                this.iRepositoryMateria.findAll(pageable)
        );
    }


    @Override
    public Optional<CommandMateria> viewByIdMateriaDTO(String sigla) {
        return Optional.ofNullable(
                this.iMapperMateria.entityToCommand(
                        this.iRepositoryMateria.findById(sigla)
                                .orElse(null)
                )
        );
    }

    @Override
    public Optional<CommandMateria> saveOrUpdateMateria(CommandMateria commandMateria) {
        return Optional.of(
                this.iMapperMateria.entityToCommand(
                        this.iRepositoryMateria.save(
                                this.iMapperMateria.commandToEntity(commandMateria)
                        )
                )
        );
    }

    @Override
    public boolean deleteMateria(String sigla) {
        return this.iRepositoryMateria.findById(sigla).map(
                materia -> {
                    this.iRepositoryMateria.delete(materia);
                    return true;
                }
        ).orElseThrow(() -> new DataNotFoundException("No existe la materia con la sigla: " + sigla));
    }
}
