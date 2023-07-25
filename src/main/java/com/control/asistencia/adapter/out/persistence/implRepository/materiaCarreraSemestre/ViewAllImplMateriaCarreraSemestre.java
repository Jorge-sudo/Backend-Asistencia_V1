package com.control.asistencia.adapter.out.persistence.implRepository.materiaCarreraSemestre;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.entity.MateriaCarreraSemestreEntity;
import com.control.asistencia.adapter.out.persistence.repository.materiaCarreraSemestre.IViewAllRepositoryMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ViewAllImplMateriaCarreraSemestre implements IViewAllRepositoryMateriaCarreraSemestre {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<MateriaCarreraSemestreEntity> getMateriaCarreraSemestreEntitys(ViewAllCommandMateriaCarreraSemestre viewAllCommandMateriaCarreraSemestre) {
        try{
            Pageable pageable = PageRequest.of(viewAllCommandMateriaCarreraSemestre.getPage()
                            , viewAllCommandMateriaCarreraSemestre.getSize()
                            , Sort.by(viewAllCommandMateriaCarreraSemestre.getSortBy()).ascending());
            List<MateriaCarreraSemestreEntity> materiaCarreraSemestres = this.em.createQuery("SELECT m FROM MateriaCarreraSemestreEntity m"
                                        , MateriaCarreraSemestreEntity.class).getResultList();
                                        
            Page<MateriaCarreraSemestreEntity> paginacion = new PageImpl<>(materiaCarreraSemestres, pageable, materiaCarreraSemestres.size());
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
