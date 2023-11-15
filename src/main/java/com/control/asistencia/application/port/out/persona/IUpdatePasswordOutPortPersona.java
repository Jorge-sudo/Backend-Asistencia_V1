package com.control.asistencia.application.port.out.persona;

import com.control.asistencia.application.port.in.persona.command.UpdatePasswordPersona;

public interface IUpdatePasswordOutPortPersona {
    boolean updatePassword(UpdatePasswordPersona command);
}
