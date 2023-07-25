package com.control.asistencia.adapter.out.persistence.implRepository.asistencia;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.AsistenciaEntity;
import com.control.asistencia.adapter.out.persistence.repository.asistencia.IViewAllRepositoryAsistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ViewAllImplAsistencia implements IViewAllRepositoryAsistencia {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<AsistenciaEntity> getAsistencias(int page, int size, String sortBy) {
        try{
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
            List<AsistenciaEntity> asistencias = this.em.createQuery("SELECT a FROM Asistencia a"
                                        , AsistenciaEntity.class).getResultList();
                                        
            Page<AsistenciaEntity> paginacion = new PageImpl<>(asistencias, pageable, asistencias.size());
            return paginacion;
        }catch (Exception ex){
            ex.printStackTrace(System.out);
            return  null;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
