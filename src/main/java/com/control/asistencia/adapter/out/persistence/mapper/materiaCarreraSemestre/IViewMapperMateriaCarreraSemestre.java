package com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre;

import com.control.asistencia.domain.materiaCarreraSemestre.ViewMateriaCarreraSemestreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;

import java.util.Set;


@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IViewMapperMateriaCarreraSemestre {

    //@Mapping(source = "campoOrigen", target = "campoDestino")
    @Mappings({
            @Mapping(source = "idMateriaCarreraSemestre", target = "idMateriaCarreraSemestre"),
            @Mapping(source = "materia.sigla", target = "sigla"),
            @Mapping(source = "materia.nombre", target = "materia"),
            @Mapping(source = "carrera.nombre", target = "carrera"),
            @Mapping(source = "semestre.nombre", target = "semestre"),
            @Mapping(source = "activo", target = "activo")
    })
    ViewMateriaCarreraSemestreDTO entityToDto(MateriaCarreraSemestreEntity materiaCarreraSemestreEntity);

    // Método para mapear una Page de entidades a una Page de DTOs
    default Page<ViewMateriaCarreraSemestreDTO> entitysToDtosPage(Page<MateriaCarreraSemestreEntity> page) {
        return page.map(this::entityToDto);
    }

    default Set<ViewMateriaCarreraSemestreDTO> entitysToDtosSet(Set<MateriaCarreraSemestreEntity> materiaCarreraSemestreEntity) {
        return materiaCarreraSemestreEntity
                .stream()
                .map(this::entityToDto)
                .collect(java.util.stream.Collectors.toSet());
    }
}