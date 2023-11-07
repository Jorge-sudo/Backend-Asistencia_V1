package com.control.asistencia.config.security;

import com.control.asistencia.config.jwt.JwtAuthenticationEntryPoint;
import com.control.asistencia.config.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public SecurityConfig(
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint ,
            CustomUsersDetailsService customUsersDetailsService ,
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.customUsersDetailsService = customUsersDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    //Este bean va a encargarse de verificar la información de los usuarios que se loguearán en nuestra api
    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Con este bean nos encargaremos de encriptar todas nuestras contraseñas
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Este bean incorporará el filtro de seguridad de json web token que creamos en nuestra clase anterior


    //Vamos a crear un bean el cual va a establecer una cadena de filtros de seguridad en nuestra aplicación.
    // Y es aquí donde determinaremos los permisos segun los roles de usuarios para acceder a nuestra aplicación
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/swagger-ui/index.html#/").permitAll()

                        /* ---- PERSONA IMAGE ---- */

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/imagePersona/upload"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- DOCENTE ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/docentes",
                                "/api/docentes/page/{page}/{size}/{shortOrder}/{sortField}",
                                "/api/docentes/{ci}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/docentes/activo",
                                "/api/docentes"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- SUPERVISOR ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/supervisores",
                                "/api/supervisores/{ci}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/supervisores/activo",
                                "/api/supervisores"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- MATERIA-CARRERA-SEMESTRE ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/materiaCarreraSemestres",
                                "/api/materiaCarreraSemestres/page/{page}/{size}/{shortOrder}/{sortField}",
                                "/api/materiaCarreraSemestres/{id}",
                                "/api/materiaCarreraSemestres/sigla/{sigla}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/materiaCarreraSemestres/activo",
                                "/api/materiaCarreraSemestres"
                        ).hasAnyAuthority( "ADMIN")
                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/materiaCarreraSemestres/{id}"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- SEMESTRES ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/semestres"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/semestres"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- MATERIA ---- */

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/materias"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- CARRERAS---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/carreras"
                        ).hasAnyAuthority( "ADMIN" ,"USER")

                        /* ---- AULA ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/aulas",
                                "/api/aulas/{id}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/aulas"
                        ).hasAnyAuthority( "ADMIN")
                        .requestMatchers(
                                HttpMethod.DELETE,
                                "/api/aulas/{id}"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- TURNO ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/turnos"
                        ).hasAnyAuthority( "ADMIN" ,"USER")

                        /* ---- ASIGNATURA ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/asignaturas/page/{page}/{size}/{shortOrder}/{sortField}/{idCarrera}/{idDia}/{idSemestre}/{idTurno}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/asignaturas"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- HORARIO ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/horarios"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/horarios"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- DOCENTE LICENCIA ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/docenteLicencias",
                                "/api/docenteLicencias/page/active/{page}/{size}/{shortOrder}/{sortField}",
                                "/api/docenteLicencias/page/inactive/{page}/{size}/{shortOrder}/{sortField}",
                                "/api/docenteLicencias/page/search/{page}/{size}/{shortOrder}/{sortField}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/docenteLicencias"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- DIA SEMANA ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/diasSemana"
                        ).hasAnyAuthority( "ADMIN" ,"USER")

                        /* ---- LICENCIA ---- */

                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/licencias"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- ASISTENCIA ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/asistencias/page/{page}/{size}/{shortOrder}/{sortField}/{idCarrera}/{idSemestre}/{fechaSearch}"
                        ).hasAnyAuthority( "ADMIN" ,"USER")
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/asistencias"
                        ).hasAnyAuthority( "ADMIN")

                        /* ---- ROL ---- */

                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/roles"
                        ).hasAnyAuthority( "ADMIN" ,"USER")

                        .anyRequest().authenticated()
                )
                .cors(withDefaults())
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exception) -> exception
                        .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                )
                .userDetailsService(this.customUsersDetailsService)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        return http.build();
    }

}