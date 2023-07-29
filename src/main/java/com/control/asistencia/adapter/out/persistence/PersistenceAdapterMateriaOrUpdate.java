package com.control.asistencia.adapter.out.persistence;

import com.control.asistencia.adapter.out.persistence.mapper.materia.IMapperMateria;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryMateria;
import com.control.asistencia.application.port.out.materia.IDeleteOutPortMateria;
import com.control.asistencia.application.port.out.materia.ISaveOrUpdateOutPortMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.PersistenceAdapter;
import com.control.asistencia.domain.materia.MateriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@PersistenceAdapter
public class PersistenceAdapterMateriaOrUpdate implements
                IViewOutPortMateria ,
        ISaveOrUpdateOutPortMateria,
                IDeleteOutPortMateria {

    private final IRepositoryMateria iRepositoryMateria;
    private final IMapperMateria iMapperMateria;
    public PersistenceAdapterMateriaOrUpdate(IRepositoryMateria repositoryMateria
                , IMapperMateria mapperMateria){
        this.iRepositoryMateria = repositoryMateria;
        this.iMapperMateria = mapperMateria;
    }

    @Override
    public Optional<Page<MateriaDTO>> viewPageMateriaEntity(Pageable pageable) {
        return Optional.of(
                this.iMapperMateria.pageEntitysToDtos(
                        this.iRepositoryMateria.findAll(pageable)
                )
        );
    }


    @Override
    public Optional<MateriaDTO> viewByIdMateriaDTO(String sigla) {
        return Optional.of(
                this.iMapperMateria.entityToDto(
                        this.iRepositoryMateria.findById(sigla).orElse(null)
                )
        );
    }

    @Override
    public Optional<MateriaDTO> saveOrUpdateMateria(MateriaDTO materiaDTO) {
        return Optional.of(
                this.iMapperMateria.entityToDto(
                        this.iRepositoryMateria.save(
                                this.iMapperMateria.dtoToEntity(materiaDTO)
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
        ).orElse(false);
    }
}
