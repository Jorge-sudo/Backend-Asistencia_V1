package com.control.asistencia.application.port.out.docente;

import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;

public interface IUpdateOutPortDocente {
    boolean updateDocenteActivo(UpdateActivoCommandDocente command);
}
