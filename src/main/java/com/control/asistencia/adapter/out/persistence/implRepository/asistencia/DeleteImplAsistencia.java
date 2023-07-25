package com.control.asistencia.adapter.out.persistence.implRepository.asistencia;

import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import com.control.asistencia.adapter.out.persistence.repository.asistencia.IDeleteRepositoryAsistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DeleteImplAsistencia implements IDeleteRepositoryAsistencia {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void eliminarAsistencia(int id) {
        AsistenciaEntity asistencia;
        try {
            asistencia = em.find(AsistenciaEntity.class, id);
            em.remove(asistencia);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
