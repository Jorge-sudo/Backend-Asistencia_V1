package com.control.asistencia.domain.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LogoutMessageResponse {
    private String message;
}
