package com.control.asistencia.adapter.out.persistence.mapper.AsignaturaView;

import com.control.asistencia.adapter.out.persistence.entity.view.AsignaturaView;
import com.control.asistencia.application.port.in.imagePersona.IViewInPortImagePersona;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class MapperAsignaturaView {
    private final IViewInPortImagePersona iViewInPortImagePersona;
    public MapperAsignaturaView(IViewInPortImagePersona iViewInPortImagePersona) {
        this.iViewInPortImagePersona = iViewInPortImagePersona;
    }

    public AsignaturaView fotografiaToBase64Image(AsignaturaView asignaturaView) {
        try {
            asignaturaView.setBase64Image(iViewInPortImagePersona.viewByNameImagePersona(asignaturaView.getFotografiaDocente()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return asignaturaView;
    }

    public Page<AsignaturaView> fotografiaToBase64Images(Page<AsignaturaView> page) {
        return page.map(this::fotografiaToBase64Image);
    }
}
