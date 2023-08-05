package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.materia.IMapperMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.PersistenceAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class MateriaPersistenceAdapter implements
                IViewOutPortMateria ,
        ISaveOrUpdateOutPortMateria,
                IDeleteOutPortMateria {

    private final IRepositoryMateria iRepositoryMateria;
    private final IMapperMateria iMapperMateria;
    public MateriaPersistenceAdapter(IRepositoryMateria repositoryMateria
                , IMapperMateria mapperMateria){
        this.iRepositoryMateria = repositoryMateria;
        this.iMapperMateria = mapperMateria;
    }

    @Override
    public Page<CommandMateria> viewPageMateriaEntity(Pageable pageable) {
        return this.iMapperMateria.pageEntitysToDtos(
                this.iRepositoryMateria.findAll(pageable)
        );
    }


    @Override
    public Optional<CommandMateria> viewByIdMateriaDTO(String sigla) {
        return Optional.of(
                this.iMapperMateria.entityToDto(
                        this.iRepositoryMateria.findById(sigla)
                                .orElseThrow(() -> new RuntimeException("No existe la materia con la sigla: " + sigla))
                )
        );
    }

    @Override
    public Optional<CommandMateria> saveOrUpdateMateria(CommandMateria commandMateria) {
        return Optional.of(
                this.iMapperMateria.entityToDto(
                        this.iRepositoryMateria.save(
                                this.iMapperMateria.dtoToEntity(commandMateria)
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
        ).orElseThrow(() -> new RuntimeException("No existe la materia con la sigla: " + sigla));
    }
}
