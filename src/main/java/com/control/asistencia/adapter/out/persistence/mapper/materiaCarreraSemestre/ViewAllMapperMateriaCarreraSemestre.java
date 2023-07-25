package com.control.asistencia.adapter.out.persistence.mapper.materiaCarreraSemestre;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.domain.MateriaCarreraSemestreDTO;



@Mapper(
    //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
    //Este atributo determina cómo se manejarán los campos de destino que no tienen una 
    //asignación directa definida en el mapper. En tu ejemplo, se está utilizando ReportingPolicy.IGNORE, 
    //lo que significa que se ignorarán los campos de destino no mapeados y no se mostrarán informes de advertencia 
    //o error. Esto es útil cuando solo deseas mapear algunos campos específicos y no te importa 
    //si algunos campos no se asignan directamente.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ViewAllMapperMateriaCarreraSemestre {
   
    //@Mapping(source = "campoOrigen", target = "campoDestino")
    @Mappings({
        @Mapping(source = "materia.sigla", target = "sigla"),
        @Mapping(source = "materia.nombre", target = "materia"),
        @Mapping(source = "carrera.nombre", target = "carrera"),
        @Mapping(source = "semestre.semestre", target = "semestre"),
        @Mapping(source = "activo", target = "activo")
    })
    MateriaCarreraSemestreDTO entityToDto(MateriaCarreraSemestreEntity materiaCarreraSemestreEntity);

    // Método para mapear una Page de entidades a una Page de DTOs
    default Page<MateriaCarreraSemestreDTO> pageEntityToDto(Page<MateriaCarreraSemestreEntity> page) {
        return page.map(this::entityToDto);
    }
}