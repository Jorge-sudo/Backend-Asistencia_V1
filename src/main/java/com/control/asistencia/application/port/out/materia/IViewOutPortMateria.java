package com.control.asistencia.application.port.out.materia;

import com.control.asistencia.application.port.in.materia.command.SaveCommandMateria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IViewOutPortMateria {
    Optional<Page<SaveCommandMateria>> viewPageMateriaEntity(Pageable pageable);
    Optional<SaveCommandMateria> viewByIdMateriaDTO(String sigla);
}
