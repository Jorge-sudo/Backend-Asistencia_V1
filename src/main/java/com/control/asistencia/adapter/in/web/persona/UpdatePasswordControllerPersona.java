package com.control.asistencia.adapter.in.web.persona;

import com.control.asistencia.application.port.in.persona.IUpdatePasswordInPortPersona;
import com.control.asistencia.application.port.in.persona.command.UpdatePasswordPersona;
import com.control.asistencia.common.WebAdapter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/api")
public class UpdatePasswordControllerPersona {
    private final IUpdatePasswordInPortPersona iUpdatePasswordInPortPersona;

    public UpdatePasswordControllerPersona(IUpdatePasswordInPortPersona iUpdatePasswordInPortPersona){
        this.iUpdatePasswordInPortPersona = iUpdatePasswordInPortPersona;
    }

    @PostMapping("/personas/update_password")
    ResponseEntity<?> updatePasswordPersona(@RequestBody @Valid UpdatePasswordPersona command){
        return this.iUpdatePasswordInPortPersona.updatePassword(command);
    }
}
