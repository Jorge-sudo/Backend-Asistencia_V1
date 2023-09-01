package com.control.asistencia.adapter.in.web.imagePersona;

import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import com.control.asistencia.common.WebAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerImagePersona {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public ViewControllerImagePersona(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }
}
