package com.control.asistencia.adapter.in.web.docenteLicencia;

import com.control.asistencia.application.port.in.docenteLicencia.ISaveOrUpdateInPortDocenteLicencia;
import com.control.asistencia.application.port.in.docenteLicencia.command.SaveCommandDocenteLicencia;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerDocenteLicencia {
    private final ISaveOrUpdateInPortDocenteLicencia iSaveOrUpdateInPortDocenteLicencia;
    public SaveOrUpdateControllerDocenteLicencia(ISaveOrUpdateInPortDocenteLicencia iSaveOrUpdateInPortDocenteLicencia){
        this.iSaveOrUpdateInPortDocenteLicencia = iSaveOrUpdateInPortDocenteLicencia;
    }

    @PostMapping("/docenteLicencias")
    ResponseEntity<?> saveOrUpdateDocente(@RequestBody @Valid SaveCommandDocenteLicencia data){
        return this.iSaveOrUpdateInPortDocenteLicencia.saveOrUpdateDocenteLicencia(data);
    }
}
