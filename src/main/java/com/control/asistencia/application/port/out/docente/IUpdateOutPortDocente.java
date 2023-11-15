package com.control.asistencia.application.port.out.docente;

import com.control.asistencia.application.port.in.docente.command.UpdateActivoCommandDocente;
import com.control.asistencia.application.port.in.docente.command.UpdatePerfilCommandDocente;

public interface IUpdateOutPortDocente {
    boolean updateDocenteActivo(UpdateActivoCommandDocente command);
    boolean updateDocentePerfil(UpdatePerfilCommandDocente command);
}
