package com.control.asistencia.application.port.in.horario;

import com.control.asistencia.application.port.in.horario.command.SaveCommandHorario;
import org.springframework.http.ResponseEntity;

public interface ISaveOrUpdateInPortHorario {
    ResponseEntity<?> saveOrUpdateHorario(SaveCommandHorario commandHorario);
}
