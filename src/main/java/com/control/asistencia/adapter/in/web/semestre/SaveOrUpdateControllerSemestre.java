package com.control.asistencia.adapter.in.web.semestre;

import com.control.asistencia.adapter.in.web.utilController.ExceptionHandlerUtil;
import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.semestre.ISaveOrUpdateServiceSemestre;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.generic.GenericDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerSemestre {
    private final ISaveOrUpdateServiceSemestre iSaveOrUpdateServiceSemestre;
    public SaveOrUpdateControllerSemestre(ISaveOrUpdateServiceSemestre iSaveOrUpdateServiceSemestre){
        this.iSaveOrUpdateServiceSemestre = iSaveOrUpdateServiceSemestre;
    }
    @PostMapping("/semestres")
    ResponseEntity<?> saveOrUpdateSemestre(@RequestBody GenericDTO data){
        ResponseEntity<?> response;
        try {
            response = data.getId() > 0
                    ? ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateServiceSemestre.saveOrUpdateSemestre(data)
            )
                    : ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateServiceSemestre.saveOrUpdateSemestre(data)
            );
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ExceptionHandlerUtil.handleException(e);
        }
        return response;
    }


}
