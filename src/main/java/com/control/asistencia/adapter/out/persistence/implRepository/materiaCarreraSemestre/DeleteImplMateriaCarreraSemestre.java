package com.control.asistencia.adapter.out.persistence.implRepository.materiaCarreraSemestre;

import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.adapter.out.persistence.repository.materiaCarreraSemestre.IDeleteRepositoryMateriaCarreraSemestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DeleteImplMateriaCarreraSemestre implements IDeleteRepositoryMateriaCarreraSemestre {

    @PersistenceContext
    private EntityManager em;


    @Override
    public boolean eliminarMateriaCarreraSemestre(int id) {
        MateriaCarreraSemestreEntity materiaCarreraSemestreEntity;
        boolean result = false;
        try {
            materiaCarreraSemestreEntity = em.find(MateriaCarreraSemestreEntity.class, id);
            em.remove(materiaCarreraSemestreEntity);
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
