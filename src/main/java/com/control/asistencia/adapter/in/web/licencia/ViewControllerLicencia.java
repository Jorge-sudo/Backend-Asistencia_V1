package com.control.asistencia.adapter.in.web.licencia;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.licencia.IViewInPortLicencia;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerLicencia {
    private final IViewInPortLicencia iViewInPortLicencia;
    public ViewControllerLicencia(IViewInPortLicencia iViewInPortLicencia) {
        this.iViewInPortLicencia = iViewInPortLicencia;
    }
    @GetMapping(path = "/licencias/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageLicencia(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return this.iViewInPortLicencia.viewPageLicenciaDTO(command);
    }
}
