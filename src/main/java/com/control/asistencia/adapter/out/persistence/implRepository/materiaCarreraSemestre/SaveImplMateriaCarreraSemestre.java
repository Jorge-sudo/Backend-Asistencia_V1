package com.control.asistencia.adapter.out.persistence.implRepository.materiaCarreraSemestre;

import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.adapter.out.persistence.repository.materiaCarreraSemestre.ISaveRepositoryMateriaCarreraSemestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SaveImplMateriaCarreraSemestre implements ISaveRepositoryMateriaCarreraSemestre{

    @PersistenceContext
    private EntityManager em;


    @Override
    public boolean saveMateriaCarreraSemestreEntity(MateriaCarreraSemestreEntity materiaCarreraSemestreEntity) {
        boolean result = false;
        try {
            em.merge(materiaCarreraSemestreEntity);
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
