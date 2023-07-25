package com.control.asistencia.adapter.out.persistence.implRepository.asistencia;

import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import com.control.asistencia.adapter.out.persistence.repository.asistencia.ISaveRepositoryAsistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SaveImplAsistencia implements ISaveRepositoryAsistencia{

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean saveAsistencia(AsistenciaEntity asistencia) {
        boolean result = false;
        try {
            em.merge(asistencia);
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return result;
    }
    
}
