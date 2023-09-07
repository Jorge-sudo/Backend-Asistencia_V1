package com.control.asistencia.adapter.out.persistence.mapper.horarioMateriaDocente;

import com.control.asistencia.adapter.out.persistence.entity.HorarioMateriaDocenteEntity;
import com.control.asistencia.application.port.in.assignMateria.command.CommandHorarioMateriaDocente;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperHorarioMateriaDocenteCommand {
    @Mappings({
            @Mapping(source = "idHorarioMateriaDocente", target = "idHorarioMateriaDocente"),
            @Mapping(source = "laboratorio", target = "laboratorio"),
            @Mapping(source = "nroLaboratorio", target = "nroLaboratorio"),
            @Mapping(source = "horarioEntity.idHorario", target = "idHorario"),
            @Mapping(source = "materiaDocenteEntity.idMateriaDocente", target = "idMateriaDocente")
    })
    CommandHorarioMateriaDocente entityToCommand(HorarioMateriaDocenteEntity entity);
}
