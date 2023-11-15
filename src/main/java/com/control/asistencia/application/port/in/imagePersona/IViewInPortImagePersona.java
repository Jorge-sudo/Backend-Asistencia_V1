package com.control.asistencia.application.port.in.imagePersona;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IViewInPortImagePersona {
    String viewByNameImagePersona(String nombreFoto) throws MalformedURLException;
    boolean thisImagePersonaExists(String nameImg) throws IOException;

}
