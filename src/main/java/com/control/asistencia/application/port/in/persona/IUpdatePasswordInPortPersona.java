package com.control.asistencia.application.port.in.persona;

import com.control.asistencia.application.port.in.persona.command.UpdatePasswordPersona;
import org.springframework.http.ResponseEntity;

public interface IUpdatePasswordInPortPersona {
    ResponseEntity<?> updatePassword(UpdatePasswordPersona command);
}
