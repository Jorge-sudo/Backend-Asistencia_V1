package com.control.asistencia.adapter.in.web.materiaCarreraSemestre;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.IViewServiceMateriaCarreraSemestre;
import com.control.asistencia.application.port.in.materiaCarreraSemestre.command.ViewPageCommandMateriaCarreraSemestre;
import com.control.asistencia.common.WebAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequestMapping("/api")
public class ViewControllerMateriaCarreraSemestre {
    private final IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre;
    private final Logger logger = LogManager.getLogger(ViewControllerMateriaCarreraSemestre.class);
    public ViewControllerMateriaCarreraSemestre(IViewServiceMateriaCarreraSemestre iViewServiceMateriaCarreraSemestre){
        this.iViewServiceMateriaCarreraSemestre = iViewServiceMateriaCarreraSemestre;
    }
    @GetMapping(path = "/materiaCarreraSemestres/page/{page}/{size}/{sortBy}")
    ResponseEntity<?> viewPageMateriaCarreraSemestre(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortBy") String sortBy) {

        ViewPageCommandMateriaCarreraSemestre command = new ViewPageCommandMateriaCarreraSemestre(
                page,
                size,
                sortBy);

        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewPageMateriaCarreraSemestreDTO(command)
            );
        }catch (DataAccessException e) {
            response = ResponseBuilderApiRest.errorWithData(
                    Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        } catch (Exception e) {
            response =  ResponseBuilderApiRest.error(
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        }
        return response;
    }
    @GetMapping(path = "/materiaCarreraSemestres")
    ResponseEntity<?> viewAllMateriaCarreraSemestre() {
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewAllMateriaCarreraSemestreDTO()
            );
        } catch (DataAccessException e) {
            response = ResponseBuilderApiRest.errorWithData(
                    Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ResponseBuilderApiRest.error(
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        }
        return response;
    }
    @GetMapping(path = "/materiaCarreraSemestres/{id}")
    ResponseEntity<?> viewByIdMateriaCarreraSemestre(@PathVariable("id") int id) {
        ResponseEntity<?> response;
        try {
            response = ResponseBuilderApiRest.view(
                    this.iViewServiceMateriaCarreraSemestre.viewByIdMateriaCarreraSemestreDTO(id)
            );
        } catch (DataAccessException e) {
            response = ResponseBuilderApiRest.errorWithData(
                    Optional.empty(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        } catch (Exception e) {
            // Captura de cualquier otra excepción no esperada
            response =  ResponseBuilderApiRest.error(
                    HttpStatus.INTERNAL_SERVER_ERROR);
            //imprimimos el error
            this.logger.error(e.toString());
        }
        return response;
    }


}
