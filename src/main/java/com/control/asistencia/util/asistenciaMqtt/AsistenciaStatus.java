package com.control.asistencia.util.asistenciaMqtt;

import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Optional;
import java.util.Set;

@Component
public class AsistenciaStatus {

    public Optional<HorarioMateriaDocenteDTO> getDocenteLate(
            Set<HorarioMateriaDocenteDTO> horarios, Time time){

        return horarios.stream()
                .filter(horario -> UtilMaxAndMinMinutes.increaseMinutes(horario.getHoraInicio()).before(time)
                        && horario.getHoraFin().after(time))
                .findFirst();
    }

    public Optional<HorarioMateriaDocenteDTO> getDocentePunctual(
            Set<HorarioMateriaDocenteDTO> horarios, Time time){

        return horarios.stream()
                .filter(horario -> UtilMaxAndMinMinutes.delayMinutes(horario.getHoraInicio()).before(time)
                        && UtilMaxAndMinMinutes.increaseMinutes(horario.getHoraInicio()).after(time))
                .findFirst();
    }
}
