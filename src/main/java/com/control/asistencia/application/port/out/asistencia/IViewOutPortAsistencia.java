package com.control.asistencia.application.port.out.asistencia;

import com.control.asistencia.domain.asistencia.AsistenciaViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IViewOutPortAsistencia {
    Page<AsistenciaViewDTO> viewPageGlobalFilterAsistencia(Pageable pageable, String globalFilter) ;
    Page<AsistenciaViewDTO> viewPageFindAllByFechaAsistencia(Pageable pageable, String fechaSearch);
}
