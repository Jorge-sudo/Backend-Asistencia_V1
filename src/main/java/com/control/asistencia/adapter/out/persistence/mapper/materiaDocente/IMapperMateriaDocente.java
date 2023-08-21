package com.control.asistencia.adapter.out.persistence.mapper.materiaDocente;

import com.control.asistencia.adapter.out.persistence.entity.MateriaDocenteEntity;
import com.control.asistencia.application.port.in.asignarMateria.command.CommandMateriaDocente;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperMateriaDocente {

    @Mappings({
            @Mapping(source = "idMateriaDocente", target = "idMateriaDocente"),
            @Mapping(source = "materia.sigla", target = "sigla"),
            @Mapping(source = "docente.ci", target = "ci")
    })
    CommandMateriaDocente entityToDto(MateriaDocenteEntity materiaDocenteEntity);
}
