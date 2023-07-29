package com.control.asistencia.adapter.out.persistence.mapper.materia;

import com.control.asistencia.adapter.out.persistence.entity.MateriaEntity;
import com.control.asistencia.domain.materia.MateriaDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.Set;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperMateria {
    //@Mapping(source = "campoOrigen", target = "campoDestino")
    @Mappings({
            @Mapping(source = "sigla", target = "sigla"),
            @Mapping(source = "nombre", target = "nombre")
    })
    MateriaDTO entityToDto(MateriaEntity materiaEntity);
    @Mappings({
            @Mapping(source = "sigla", target = "sigla"),
            @Mapping(source = "nombre", target = "nombre")
    })
    MateriaEntity dtoToEntity(MateriaDTO materiaDTO);
    default Page<MateriaDTO> pageEntitysToDtos(Page<MateriaEntity> page) {
        return page.map(this::entityToDto);
    }
    default Set<MateriaDTO> entitysToDtos(Set<MateriaEntity> materiaEntity) {
        return materiaEntity
                .stream()
                .map(this::entityToDto)
                .collect(java.util.stream.Collectors.toSet());
    }
}
