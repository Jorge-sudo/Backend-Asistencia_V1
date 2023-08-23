package com.control.asistencia.adapter.in.web.licencia;

import com.control.asistencia.application.port.in.licencia.ISaveOrUpdateInPortLicencia;
import com.control.asistencia.application.port.in.licencia.command.CommandSaveOrViewLicencia;
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
public class SaveOrUpdateControllerLicencia {
    private final ISaveOrUpdateInPortLicencia iSaveOrUpdateInPortLicencia;
    public SaveOrUpdateControllerLicencia(ISaveOrUpdateInPortLicencia iSaveOrUpdateInPortLicencia) {
        this.iSaveOrUpdateInPortLicencia = iSaveOrUpdateInPortLicencia;
    }
    @PostMapping(path = "/licencia")
    ResponseEntity<?> saveOrUpdateLicencia(@RequestBody @Valid CommandSaveOrViewLicencia data){
        return this.iSaveOrUpdateInPortLicencia.saveOrUpdateLicencia(data);
    }
}
