package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllCommandMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.ViewAllInPortMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import com.control.asistencia.domain.MateriaCarreraSemestreDTO;

@WebAdapter
@RestController
@RequestMapping("/api")
public class viewController {
    private final ViewAllInPortMateriaCarreraSemestre allInPortMateriaCarreraSemestre;
    public viewController(ViewAllInPortMateriaCarreraSemestre allInPortMateriaCarreraSemestre){
        this.allInPortMateriaCarreraSemestre = allInPortMateriaCarreraSemestre;
    }
    @GetMapping(path = "/materiaCarreraSemestres/{page}/{size}/{sortBy}")
    Page<MateriaCarreraSemestreDTO> viewAll(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy) {

        ViewAllCommandMateriaCarreraSemestre command = new ViewAllCommandMateriaCarreraSemestre(
                page,
                size,
                sortBy);

        return allInPortMateriaCarreraSemestre.viewAll(command);
    }
}
