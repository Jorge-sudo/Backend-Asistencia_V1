package com.control.asistencia.adapter.in.web.docenteLicencia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.docenteLicencia.IViewInPortDocenteLicencia;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerDocenteLicencia {
    private final IViewInPortDocenteLicencia iViewInPortDocenteLicencia;
    public ViewControllerDocenteLicencia(IViewInPortDocenteLicencia iViewInPortDocenteLicencia){
        this.iViewInPortDocenteLicencia = iViewInPortDocenteLicencia;
    }

    @GetMapping("/docenteLicencias/page/active/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageActiveDocenteLicencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField){


        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder);

        return this.iViewInPortDocenteLicencia.viewPageActiveDocenteLicenciaDTO(command);

    }

    @GetMapping("/docenteLicencias/page/inactive/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageInactiveDocenteLicencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField){



        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder);

        return this.iViewInPortDocenteLicencia.viewPageInactiveDocenteLicenciaDTO(command);

    }

    @GetMapping("/docenteLicencias/page/search/{page}/{size}/{shortOrder}/{sortField}")
    ResponseEntity<?> viewPageGlobalFilterDocenteLicencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("shortOrder") int shortOrder,
            @PathVariable("sortField") String sortField,
            @RequestParam(value = "globalFilter", required = false) String globalFilter){

        if (globalFilter == null || globalFilter.isEmpty()) {
            globalFilter = null;
        }

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortField,
                shortOrder,
                globalFilter);

        return this.iViewInPortDocenteLicencia.viewPageFilterGlobalDocenteLicenciaDTO(command);

    }
}
