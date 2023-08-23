package com.control.asistencia.adapter.out.persistence.mapper.horario;

import com.control.asistencia.adapter.out.persistence.entity.HorarioEntity;
import com.control.asistencia.domain.horario.HorarioViewDTO;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(
        //indicamos que la implementacion sea generado como un componente de spring para poder inyectarl
        componentModel = MappingConstants.ComponentModel.SPRING,
        //Este atributo determina cómo se manejarán los campos de destino que no tienen una asignación
        // directa definida en el mapper.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IMapperHorarioDTO {
    @Mappings({
            @Mapping(source = "idHorario", target = "idHorario"),
            @Mapping(source = "horaInicio", target = "horaInicio"),
            @Mapping(source = "horaFin", target = "horaFin"),
            @Mapping(source = "diaSemana", target = "diaSemana"),
            @Mapping(source = "turno", target = "turno"),
    })
    HorarioViewDTO entityToDto(HorarioEntity horarioEntity);
    default Page<HorarioViewDTO> entitysToDtosPage(Page<HorarioEntity> horarioEntityPage){
        return horarioEntityPage.map(this::entityToDto);
    }
}
