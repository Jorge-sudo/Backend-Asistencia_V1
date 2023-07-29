package com.control.asistencia.application.service.materia;

import com.control.asistencia.application.port.in.command.ViewPageCommand;
import com.control.asistencia.application.port.in.materia.IViewServiceMateria;
import com.control.asistencia.application.port.out.materia.IViewOutPortMateria;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.materia.MateriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@UseCase
public class ViewServiceImplMateria  implements IViewServiceMateria {
    private final IViewOutPortMateria iViewOutPortMateria;
    public ViewServiceImplMateria(IViewOutPortMateria iViewOutPortMateria) {
        this.iViewOutPortMateria = iViewOutPortMateria;
    }

    @Override
    public Optional<Page<MateriaDTO>> viewPageMateriaDTO(ViewPageCommand command) {
        Sort sort = Sort.by(Sort.Direction.ASC, command.getSortBy());
        return this.iViewOutPortMateria.viewPageMateriaEntity(
                PageRequest.of(command.getPage(), command.getSize(), sort )
        );
    }

    @Override
    public Optional<MateriaDTO> viewByIdMateriaDTO(String sigla) {
        return this.iViewOutPortMateria.viewByIdMateriaDTO(sigla);
    }
}
