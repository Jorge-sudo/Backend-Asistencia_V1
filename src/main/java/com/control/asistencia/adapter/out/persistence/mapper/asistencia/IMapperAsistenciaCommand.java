package com.control.asistencia.adapter.out.persistence.mapper.asistencia;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import org.mapstruct.*;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperAsistenciaCommand {
    @Mappings({
            @Mapping(source = "idAsistencia", target = "idAsistencia"),
            @Mapping(source = "horaEntrada", target = "horaEntrada"),
            @Mapping(source = "cantidadEstudiantes", target = "cantidadEstudiantes"),
            @Mapping(source = "fecha", target = "fecha"),
            @Mapping(source = "estado", target = "estado"),
            @Mapping(source = "aula.idAula", target = "idAula"),
            @Mapping(source = "horarioMateriaDocente.idHorarioMateriaDocente", target = "idHorarioMateriaDocente"),

    })
    CommandAsistencia entityToCommand(AsistenciaEntity asistenciaEntity);
}
