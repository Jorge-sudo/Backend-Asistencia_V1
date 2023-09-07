package com.control.asistencia.application.port.out.docente;

import com.control.asistencia.domain.docente.DocenteViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewOutPortDocente {
    Page<DocenteViewDTO> viewPageDocenteDTO(Pageable pageable);
    Optional<DocenteViewDTO> viewByCiDocenteDTO(Long ci);
    Optional<DocenteViewDTO> viewByCodigoRfidDocenteDTO(String codigoRfid);
}
