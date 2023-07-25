package com.control.asistencia.adapter.out.persistence.repository.asistencia;


import org.springframework.data.domain.Page;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;

public interface IViewAllRepositoryAsistencia {
    Page<AsistenciaEntity> getAsistencias(int page, int size, String sortBy);
}
