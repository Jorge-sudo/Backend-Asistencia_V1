package com.control.asistencia.application.port.in.materiaCarreraSemestre;

import org.springframework.data.domain.Page;

import com.control.asistencia.domain.MateriaCarreraSemestreDTO;

public interface ViewAllInPortMateriaCarreraSemestre {
    public Page<MateriaCarreraSemestreDTO> viewAll(ViewAllCommandMateriaCarreraSemestre command);
}
