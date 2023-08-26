package com.control.asistencia.config.security;

import com.control.asistencia.config.jwt.JwtAuthenticationEntryPoint;
import com.control.asistencia.config.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//Le indica al contenedor de spring que esta es una clase de seguridad al momento de arrancar la aplicación
@EnableWebSecurity
//Indicamos que se activa la seguridad web en nuestra aplicación y además esta será una clase la cual contendrá toda la configuración referente a la seguridad
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final CustomUsersDetailsService customUsersDetailsService;

    @Autowired
    public SecurityConfig(
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint ,
            CustomUsersDetailsService customUsersDetailsService) {

        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.customUsersDetailsService = customUsersDetailsService;
    }


    //Este bean va a encargarse de verificar la información de los usuarios que se loguearán en nuestra api
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Con este bean nos encargaremos de encriptar todas nuestras contraseñas
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Este bean incorporará el filtro de seguridad de json web token que creamos en nuestra clase anterior
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }


    //Vamos a crear un bean el cual va a establecer una cadena de filtros de seguridad en nuestra aplicación.
    // Y es aquí donde determinaremos los permisos segun los roles de usuarios para acceder a nuestra aplicación
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/publico/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .cors(withDefaults())
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exception) -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)

                )
                .userDetailsService(customUsersDetailsService)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }
}