package com.control.asistencia.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;
    private final JwtGenerador jwtGenerador;

    public JwtAuthenticationFilter(
            UserDetailsService userDetailsService,
            JwtGenerador jwtGenerador) {

        this.userDetailsService = userDetailsService;
        this.jwtGenerador = jwtGenerador;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //Obtenemos los datos del token mediante el método desarrollado arriba
        String token = this.jwtGenerador.getJwtFromCookies(request);
        // Validamos la información del token
        if (StringUtils.hasText(token) && jwtGenerador.validarToken(token)) {
            String username = jwtGenerador.obtenerUsernameDeJwt(token);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            //Cargamos una lista de String con los roles alojados en BD
            String role = userDetails.getAuthorities().stream().findFirst().isPresent()
                    ? userDetails.getAuthorities().stream().findFirst().get().getAuthority()
                    : "USER" ;
            //Comprobamos que el usuario autenticado posee alguno de los siguientes roles alojados en BD
            if (role.contains("USER") || role.contains("ADMIN")) {
                /*Creamos el objeto UsernamePasswordAuthenticationToken el cual contendrá los detalles de autenticación del usuario*/
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                //Aca establecimos información adicional de la autenticación, como por ejemplo la dirección ip del usuario, o el agente de usuario para hacer la solicitud etc.
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //Establecemos el objeto anterior (autenticación del usuario) en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        //Permite que la solicitud continue hacia el siguiente filtro en la cadena de filtro.
        filterChain.doFilter(request, response);
    }

}
