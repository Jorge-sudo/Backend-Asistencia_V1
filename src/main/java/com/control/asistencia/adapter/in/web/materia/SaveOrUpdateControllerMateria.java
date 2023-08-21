package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.application.port.in.materia.ISaveOrUpdateInPortMateria;
import com.control.asistencia.application.port.in.materia.command.CommandMateria;
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
public class SaveOrUpdateControllerMateria {
    private final ISaveOrUpdateInPortMateria iSaveOrUpdateInPortMateria;
    public SaveOrUpdateControllerMateria(
            ISaveOrUpdateInPortMateria iSaveOrUpdateInPortMateria){

        this.iSaveOrUpdateInPortMateria = iSaveOrUpdateInPortMateria;

    }
    @PostMapping("/materias")
    ResponseEntity<?> saveOrUpdateMateria(@RequestBody @Valid CommandMateria data){
        return this.iSaveOrUpdateInPortMateria.saveOrUpdateMateria(data);
    }
}
