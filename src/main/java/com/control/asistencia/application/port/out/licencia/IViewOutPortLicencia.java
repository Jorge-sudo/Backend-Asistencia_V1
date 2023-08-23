package com.control.asistencia.application.port.out.licencia;

import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IViewOutPortLicencia {
    Page<CommandSaveOrViewLicencia> viewPageLicencia(Pageable pageable);
}
