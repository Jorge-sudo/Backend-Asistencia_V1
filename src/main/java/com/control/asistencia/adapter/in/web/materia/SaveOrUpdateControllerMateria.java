package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materia.ISaveOrUpdateInPortMateria;
import com.control.asistencia.application.port.in.materia.IViewInPortMateria;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.application.port.in.materia.command.SaveCommandMateria;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class SaveOrUpdateControllerMateria {
    private final ISaveOrUpdateInPortMateria iSaveOrUpdateInPortMateria;
    private final IViewInPortMateria iViewInPortMateria;
    public SaveOrUpdateControllerMateria(
            ISaveOrUpdateInPortMateria iSaveOrUpdateInPortMateria ,
            IViewInPortMateria iViewInPortMateria){

        this.iSaveOrUpdateInPortMateria = iSaveOrUpdateInPortMateria;
        this.iViewInPortMateria = iViewInPortMateria;

    }
    @PostMapping("/materias")
    ResponseEntity<?> saveOrUpdateMateria(@RequestBody @Valid SaveCommandMateria data){

        Optional<SaveCommandMateria> response = this.iViewInPortMateria
                .viewByIdMateriaDTO(data.getSigla());

        return response.isEmpty()
                ? ResponseBuilderApiRest.save(
                    this.iSaveOrUpdateInPortMateria.saveOrUpdateMateria(data)
                )
                : ResponseBuilderApiRest.update(
                    this.iSaveOrUpdateInPortMateria.saveOrUpdateMateria(data)
                );
    }
}
