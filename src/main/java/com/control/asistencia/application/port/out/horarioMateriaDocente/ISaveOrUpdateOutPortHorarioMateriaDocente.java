package com.control.asistencia.application.port.out.horarioMateriaDocente;

import com.control.asistencia.application.port.in.asignatura.command.CommandHorarioMateriaDocente;

import java.util.Set;

public interface ISaveOrUpdateOutPortHorarioMateriaDocente {
    Set<CommandHorarioMateriaDocente> saveOrUpdateHorarioMateriaDocente(
            Set<CommandHorarioMateriaDocente> commands);
}
