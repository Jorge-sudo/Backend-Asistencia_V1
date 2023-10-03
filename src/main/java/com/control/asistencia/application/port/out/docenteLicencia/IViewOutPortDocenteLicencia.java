package com.control.asistencia.application.port.out.docenteLicencia;

import com.control.asistencia.domain.docenteLicencia.DocenteLicenciaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IViewOutPortDocenteLicencia {
    Page<DocenteLicenciaDTO> viewPageActiveDocenteLicenciaDTO(Pageable pageable );
    Page<DocenteLicenciaDTO> viewPageInactiveDocenteLicenciaDTO(Pageable pageable);
    Page<DocenteLicenciaDTO> viewPageFilterGlobalDocenteLicenciaDTO(Pageable pageable, String globalFilter);
}
