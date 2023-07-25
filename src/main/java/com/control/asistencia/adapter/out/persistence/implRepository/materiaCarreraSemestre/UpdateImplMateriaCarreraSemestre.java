package com.control.asistencia.adapter.out.persistence.implRepository.materiaCarreraSemestre;

import org.springframework.stereotype.Repository;

import com.control.asistencia.adapter.out.persistence.repository.asistencia.IUpdateRepositoryAsistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UpdateImplMateriaCarreraSemestre implements IUpdateRepositoryAsistencia {

    @PersistenceContext
    private EntityManager em;

    /*
    @Override
    public int updateAsistencia(MqttMessageResponseCantidadEstudiante mqttMessageResponseCantidadEstudiante) {
        int resultado = 0;
        String consulta = "UPDATE Asistencia a SET a.cantidadEstudiantes = :cantidadEstudiantes WHERE a.idAsistencia = :idAsistencia";
        try {
            Query query = em.createQuery(consulta);
            query.setParameter("cantidadEstudiantes", mqttMessageResponseCantidadEstudiante.getCantEstudiantes());
            query.setParameter("idAsistencia", mqttMessageResponseCantidadEstudiante.getIdAsistencia());
            resultado = query.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return resultado;
    } */
}
