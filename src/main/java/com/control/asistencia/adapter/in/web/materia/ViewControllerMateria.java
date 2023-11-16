package com.control.asistencia.adapter.in.web.materia;

import com.control.asistencia.application.port.in.materia.IViewInPortMateria;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerMateria {
    private final IViewInPortMateria iViewInPortMateria;
    public ViewControllerMateria(IViewInPortMateria iViewInPortMateria){
        this.iViewInPortMateria = iViewInPortMateria;
    }
    @GetMapping(path = "/materias/{sigla}")
    ResponseEntity<?> viewByIdMateria(@PathVariable String sigla){
        return this.iViewInPortMateria.viewByIdMateriaDTO(sigla);
    }
}
