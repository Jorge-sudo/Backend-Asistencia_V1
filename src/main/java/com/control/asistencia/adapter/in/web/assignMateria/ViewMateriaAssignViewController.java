package com.control.asistencia.adapter.in.web.assignMateria;

import com.control.asistencia.application.port.in.commandPage.ViewPageCommand;
import com.control.asistencia.application.port.in.assignMateria.IViewInPortMateriaAssignView;
import com.control.asistencia.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewMateriaAssignViewController {
    private final IViewInPortMateriaAssignView iViewInPortMateriaAssignView;
    public ViewMateriaAssignViewController(IViewInPortMateriaAssignView iViewInPortMateriaAssignView){
        this.iViewInPortMateriaAssignView = iViewInPortMateriaAssignView;
    }
    @GetMapping(path = "/materiasAssignView/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageMateriaAssignView(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy ){

        ViewPageCommand command = new ViewPageCommand(
                page,
                size,
                sortBy);

        return this.iViewInPortMateriaAssignView.viewPageMateriaAssignView(command);
    }
}
