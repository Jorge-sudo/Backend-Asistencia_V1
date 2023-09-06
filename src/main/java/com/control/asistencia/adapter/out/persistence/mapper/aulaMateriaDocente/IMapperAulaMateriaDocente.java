package com.control.asistencia.adapter.out.persistence.mapper.aulaMateriaDocente;

import com.control.asistencia.adapter.out.persistence.entity.AulaMateriaDocenteEntity;
import com.control.asistencia.application.port.in.assignMateria.command.CommandAulaMateriaDocente;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperAulaMateriaDocente {
    @Mappings({
            @Mapping(source = "idAulaMateriaDocente", target = "idAulaMateriaDocente"),
            @Mapping(source = "materiaDocente.idMateriaDocente", target = "idMateriaDocente"),
            @Mapping(source = "aula.idAula", target = "idAula")
    })
    CommandAulaMateriaDocente entityToCommand(AulaMateriaDocenteEntity aulaMateriaDocenteEntity);
}
