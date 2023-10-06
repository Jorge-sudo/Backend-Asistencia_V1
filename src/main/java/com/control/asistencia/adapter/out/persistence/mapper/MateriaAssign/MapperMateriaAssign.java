package com.control.asistencia.adapter.out.persistence.mapper.MateriaAssign;

import com.control.asistencia.adapter.out.persistence.entity.view.MateriaAssignView;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class MapperMateriaAssign {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public MapperMateriaAssign(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    public MateriaAssignView fotografiaToBase64Image(MateriaAssignView materiaAssignView) {
        try {
            materiaAssignView.setBase64Image(iViewInPortImagePersona.viewByNameImagePersona(materiaAssignView.getFotografiaDocente()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return materiaAssignView;
    }

    public Page<MateriaAssignView> fotografiaToBase64Images(Page<MateriaAssignView> page) {
        return page.map(this::fotografiaToBase64Image);
    }
}
