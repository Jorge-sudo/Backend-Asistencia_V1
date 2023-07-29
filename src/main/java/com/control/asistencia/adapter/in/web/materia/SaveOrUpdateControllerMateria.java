package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materia.ISaveOrUpdateServiceMateria;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.materia.MateriaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerMateria {
    private final ISaveOrUpdateServiceMateria iSaveOrUpdateServiceMateria;
    public SaveOrUpdateControllerMateria(ISaveOrUpdateServiceMateria iSaveOrUpdateServiceMateria){
        this.iSaveOrUpdateServiceMateria = iSaveOrUpdateServiceMateria;
    }
    @PostMapping("/materias")
    ResponseEntity<?> saveOrUpdateMateria(@RequestBody MateriaDTO data){
        ResponseEntity<?> response;
        try {
            response = data.getSigla() == null
                    ? ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateServiceMateria.saveOrUpdateMateria(data)
            )
                    : ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateServiceMateria.saveOrUpdateMateria(data)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }
}
