package com.control.asistencia.application.service.persona;

import com.control.asistencia.application.port.in.persona.IUpdatePasswordInPortPersona;
import com.control.asistencia.application.port.in.persona.command.UpdatePasswordPersona;
import com.control.asistencia.application.port.out.persona.IUpdatePasswordOutPortPersona;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class UpdatePasswordInPortImplPersona implements IUpdatePasswordInPortPersona {

    private final IUpdatePasswordOutPortPersona iUpdatePasswordOutPortPersona;
    public UpdatePasswordInPortImplPersona(IUpdatePasswordOutPortPersona iUpdatePasswordOutPortPersona) {
        this.iUpdatePasswordOutPortPersona = iUpdatePasswordOutPortPersona;
    }


    @Override
    @Transactional
    public ResponseEntity<?> updatePassword(UpdatePasswordPersona command) {
        return ResponseBuilderApiRest.updatePassword(
                iUpdatePasswordOutPortPersona.updatePassword(command)
        );
    }
}
