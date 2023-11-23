-- CONTROL DE ASISTENCIA MODELO RELACIONAL NORMALIZADO
CREATE TABLE IF NOT EXISTS rol (
    id_rol INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS persona (
    ci BIGINT NOT NULL PRIMARY KEY,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    fotografia VARCHAR(100) NULL,
    email VARCHAR(50) NOT NULL,
    genero VARCHAR(1) NOT NULL,
    correo_institucional VARCHAR(50) NOT NULL,
    contrasenia VARCHAR(200) NOT NULL,
    activo BOOLEAN NOT NULL,
    id_rol INTEGER NOT NULL,
    FOREIGN KEY(id_rol) REFERENCES rol(id_rol)
);

CREATE TABLE IF NOT EXISTS supervisor (
    ci BIGINT NOT NULL PRIMARY KEY,
    reporte_email BOOLEAN NOT NULL,
    reporte_institucional BOOLEAN NOT NULL,
    FOREIGN KEY(ci) REFERENCES persona(ci)
);

CREATE TABLE IF NOT EXISTS docente (
    ci BIGINT  NOT NULL PRIMARY KEY,
    cod_rfid VARCHAR(20) NOT NULL,
    FOREIGN KEY(ci) REFERENCES persona(ci)
);

CREATE TABLE IF NOT EXISTS licencia (
    id_licencia INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fecha_inicio DATE NOT NULL,
    fecha_final DATE NOT NULL,
    descripcion VARCHAR(1000) NOT NULL
);

CREATE TABLE IF NOT EXISTS docente_licencia(
    id_docente_licencia INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_licencia INTEGER NOT NULL,
    ci BIGINT NOT NULL,
    FOREIGN KEY (ci) REFERENCES persona(ci),
    FOREIGN KEY (id_licencia) REFERENCES licencia(id_licencia)
);


CREATE TABLE IF NOT EXISTS semestre(
    id_semestre INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS materia(
    sigla VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS carrera(
    id_carrera INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS materia_carrera_semestre(
    id_materia_carrera_semestre INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_carrera INTEGER NOT NULL,
    sigla VARCHAR(10) NOT NULL,
    id_semestre INTEGER NOT NULL,
    activo BOOLEAN NOT NULL,
    FOREIGN KEY (id_semestre) REFERENCES  semestre(id_semestre),
    FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera),
    FOREIGN KEY (sigla) REFERENCES materia(sigla)
);

CREATE TABLE IF NOT EXISTS materia_docente(
    id_materia_docente INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_materia_carrera_semestre INTEGER NOT NULL,
    ci BIGINT NOT NULL,
    FOREIGN KEY (id_materia_carrera_semestre) REFERENCES materia_carrera_semestre(id_materia_carrera_semestre),
    FOREIGN KEY (ci) REFERENCES docente(ci)
);

CREATE TABLE IF NOT EXISTS turno(
    id_turno INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(8)
);

CREATE TABLE IF NOT EXISTS dia_semana(
    id_dia INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS horario(
    id_horario INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    id_dia INTEGER NOT NULL,
    id_turno INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS aula(
    id_aula INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    aula VARCHAR(5) NOT NULL,
    paralelo VARCHAR(10) NOT NULL,
    piso VARCHAR(5) NOT NULL,
    bloque VARCHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS aula_materia_docente(
    id_aula_materia_docente INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_materia_docente INTEGER NOT NULL,
    id_aula INTEGER NOT NULL,
    FOREIGN KEY (id_materia_docente) REFERENCES materia_docente(id_materia_docente),
    FOREIGN KEY (id_aula) REFERENCES aula(id_aula)
);

CREATE TABLE IF NOT EXISTS horario_materia_docente(
    id_horario_materia_docente INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nro_laboratorio INTEGER NULL,
    laboratorio BOOLEAN NOT NULL,
    id_horario INTEGER NOT NULL,
    id_materia_docente INTEGER NOT NULL,
    FOREIGN KEY (id_horario) REFERENCES horario(id_horario),
    FOREIGN KEY (id_materia_docente) REFERENCES materia_docente(id_materia_docente)
);

CREATE TABLE IF NOT EXISTS asistencia (
    id_asistencia INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    hora_entrada TIME NOT NULL,
    cantidad_estudiantes INTEGER NULL,
    fecha DATE NOT NULL,
    estado VARCHAR(20) NOT NULL,
    id_aula INTEGER NOT NULL,
    id_horario_materia_docente INTEGER NOT NULL,
    FOREIGN KEY (id_aula) REFERENCES aula(id_aula),
    FOREIGN KEY (id_horario_materia_docente) REFERENCES horario_materia_docente(id_horario_materia_docente)
);


CREATE VIEW IF NOT EXISTS asignatura_view AS
SELECT  ROW_NUMBER() OVER (ORDER BY m.nombre) AS 'id',
        m.nombre AS 'materia',
        mc.activo AS 'activo',
        m.sigla AS 'sigla',
        c.nombre AS 'carrera',
        CONCAT(a.paralelo,'-', a.aula, '-', a.piso, '-', a.bloque) AS 'aula' ,
        ds.nombre AS 'dia',
        CONCAT(SUBSTRING(h.hora_inicio, 1, 5), '-', SUBSTRING(h.hora_fin, 1, 5)) AS 'horario', -- Aquí se ajusta el formato
        t.nombre AS 'turno',
        hmd.laboratorio AS 'laboratorio',
        hmd.nro_laboratorio AS 'nro_laboratorio',
        s.nombre AS 'semestre',
        p.nombre AS 'nombre_docente',
        p.apellido AS 'apellido_docente',
        p.fotografia AS 'fotografia_docente'
FROM    materia m
            JOIN materia_carrera_semestre mc ON m.sigla = mc.sigla
            JOIN carrera c ON mc.id_carrera = c.id_carrera
            JOIN materia_docente md ON mc.id_materia_carrera_semestre = md.id_materia_carrera_semestre
            JOIN aula_materia_docente amd ON amd.id_materia_docente = md.id_materia_docente
            JOIN aula a ON amd.id_aula = a.id_aula
            JOIN horario_materia_docente hmd ON hmd.id_materia_docente = md.id_materia_docente
            JOIN horario h ON hmd.id_horario = h.id_horario
            JOIN dia_semana ds ON h.id_dia = ds.id_dia
            JOIN turno t ON h.id_turno = t.id_turno
            JOIN semestre s ON mc.id_semestre = s.id_semestre
            JOIN docente d ON md.ci = d.ci
            JOIN persona p ON d.ci = p.ci;

CREATE VIEW IF NOT EXISTS dashboard_view AS
SELECT
    1 AS id,
    (SELECT COUNT(*)
     FROM materia_carrera_semestre) AS 'materias',
    (SELECT COUNT(*)
     FROM materia_carrera_semestre mcs
     WHERE mcs.activo = TRUE ) AS 'materias_activas',
    (SELECT COUNT(*)
     FROM docente)  AS 'docentes',
    (SELECT COUNT(*)
     FROM docente d
              JOIN persona p ON d.ci =  p.ci
     WHERE p.activo = TRUE) AS 'docentes_activos',
    (SELECT COUNT(*)
     FROM asistencia a
     WHERE a.fecha = CURDATE()) AS 'asistencias_hoy',
    (SELECT CAST(SUM(IF(a.estado = 'Puntual', 1, 0)) AS INTEGER)
     FROM asistencia a
     WHERE a.fecha = CURDATE())
        AS 'asistencias_puntuales_hoy',
    (SELECT COUNT(*)
     FROM asistencia a
     WHERE MONTH(a.fecha) = MONTH(CURDATE())) AS 'asistencias_mes',
    (SELECT CAST(SUM(IF(a.estado = 'Puntual', 1, 0)) AS INTEGER)
     FROM asistencia a
     WHERE MONTH(a.fecha) = MONTH(CURDATE()))
        AS 'asistencias_puntuales_mes';