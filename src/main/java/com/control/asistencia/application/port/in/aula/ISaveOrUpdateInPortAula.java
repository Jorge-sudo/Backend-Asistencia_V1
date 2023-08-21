package com.control.asistencia.application.port.in.aula;

import com.control.asistencia.application.port.in.aula.command.CommandAula;
import org.springframework.http.ResponseEntity;


public interface ISaveOrUpdateInPortAula {
    ResponseEntity<?> saveOrUpdateAula(CommandAula commandAula);
}
