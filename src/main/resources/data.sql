
-- CONTROL DE ASISTENCIA MODELO RELACIONAL NORMALIZADO


--SUPERVISOR
INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia)
VALUES (11077821, 'Jorge Luis', 'Arone Delgado', 'JorgeLuisAroneDelgado11077821.jpg', 'jorgearone567@gmail.com', 'M',
        'jorge.arone@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi');
--DOCENTES
INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia, activo)
VALUES (222221, 'Rita Roxana', 'Torrico', 'RitaRoxanaTorrico222221.jpg', 'ritatorrico222@gmail.com', 'F', 'rita.torrico@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222224, 'Lorena Morayma', 'Huasco Aruquipa', 'LorenaMoraymaHuascoAruquipa2222224.jpg', 'lorenahuasco222@gmail.com', 'F','lorena.huasco@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (22225, 'Maribel', 'Apaza Atahuachi', 'MaribelApazaAtahuachi22225.jpg', 'marielapaza222@gmail.com', 'F','maribel.apaza@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222231, 'Erik Alvaro', 'Mamani Callisaya', 'ErikAlvaroMamaniCallisaya2222231.jpg', 'erikmamanicallisaya222@gmail.com', 'M','erik.mamani@usalesiana.edu.bo', 'erik222', TRUE),
       (222223, 'Ariel Naddir', 'Aguilar Duran', 'ArielNaddirAguilarDuran222223.jpg', 'arielaguilar222@gmail.com', 'M','ariel.aguilar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (22227, 'Angela Raquel', 'Blanco Velasquez', 'AngelaRaquelBlancoVelasquez22227.jpg', 'angelablanco222@gmail.com', 'F','angela.blanco@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222241, 'Maria Elizabeth', 'Quezada Gutierrez', 'MariaElizabethQuezadaGutierrez2222241.jpg', 'mariaquezada222@gmail.com', 'F','maria.quezada@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222234, 'Maria Nila', 'Morales Quispe', 'MariaNilaMoralesQuispe2222234.jpg', 'mariamorales222@gmail.com', 'F','maria.morales@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (22219, 'Alfonso Martin', 'Flores Chumacero', 'AlfonsoMartinFloresChumacero22219.jpg', 'alfonsoflores222@gmail.com', 'M','alfonso.flores@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222230, 'Erik Elio', 'Mamani Padilla', 'ErikElioMamaniPadilla2222230.jpg', 'erikmamani222@gmail.com', 'M','erik.mamani@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE),
       (2222251, 'Adalid Irvin', 'Yujra Alí', 'AdalidIrvinYujraAlí2222251.jpg', 'adalidyujra222@gmail.com', 'M','adalid.yujra@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', FALSE),
       (22215, 'Fernando Ramiro', 'estrada Navia', 'FernandoRamiroestradaNavia22215.jpg', 'fernandoestrada222@gmail.com', 'M','fernando.estrada@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', FALSE);


INSERT IGNORE INTO rol(id_rol, nombre) VALUES(1, 'USER');
INSERT IGNORE INTO rol(id_rol, nombre) VALUES(2, 'ADMIN');

INSERT IGNORE INTO persona_rol(id_persona_rol , id_rol, ci) VALUES(1, 1, 11077821);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(2, 2, 11077821);
--DOCENTES
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(3, 1, 222221);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(4, 1, 2222224);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(5, 1, 22225);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(6, 1, 2222231);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(7, 1, 222223);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(8, 1, 22227);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(9, 1, 2222241);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(10, 1, 2222234);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(11, 1, 22219);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(12, 1, 2222230);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(13, 1, 2222251);
INSERT IGNORE INTO persona_rol(id_persona_rol ,id_rol, ci) VALUES(14, 1, 22215);

INSERT IGNORE INTO supervisor(ci, reporte_email, reporte_institucional) VALUES(11077821, true, true);

--DOCENTES
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(222221, 'HJDVND56DV');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222224, 'NDJCND56');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22225, 'DNDU1E3');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222231, 'NDDSHS5S');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(222223, 'NSU56DS');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22227, 'MUS45SD');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222241, 'MSJS456SD');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222234, 'SDKDS56');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22219, 'BDST4501M');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222230, '315BM00S');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222251, 'NN35NDDS');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22215, 'F38CDB09');

INSERT IGNORE INTO licencia(id_licencia, fecha_inicio, fecha_final, descripcion)
VALUES(1, '2023-3-22', '2023-3-27', 'No podre asistir por motivos de salud');

INSERT IGNORE INTO docente_licencia(id_docente_licencia, id_licencia, ci) VALUES(1, 1, 22219);

INSERT IGNORE INTO asistencia(id_asistencia, hora_entrada, cant_estudiantes, fecha, estado) VALUES(1, '7:30', 21, '2023-3-22' , 'Puntual');
INSERT IGNORE INTO asistencia(id_asistencia, hora_entrada, cant_estudiantes, fecha, estado) VALUES(2, '9:00', 21, '2023-3-26' , 'Puntual');

INSERT IGNORE INTO docente_asistencia(id_docente_asistencia, id_asistencia, ci) VALUES(1, 1, 22219 );
INSERT IGNORE INTO docente_asistencia(id_docente_asistencia,id_asistencia, ci) VALUES(2, 2, 22215 );

--DOCENTES
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(1, 'Primero');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(2, 'Segundo');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(3, 'Tercero');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(4, 'Cuarto');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(5, 'Quinto');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(6, 'Sexto');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(7, 'Septimo');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(8, 'Octavo');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(9, 'Noveno');
INSERT IGNORE INTO semestre(id_semestre, nombre) VALUES(10, 'Decimo');

--MATERIAS
INSERT IGNORE INTO materia(sigla, nombre) VALUES('ING-111', 'Introduccion a la Informatica');
INSERT IGNORE INTO materia(sigla, nombre) VALUES('LIN-114', 'Expresion Oral y Escrita');
INSERT IGNORE INTO materia(sigla, nombre) VALUES('MAT-113', 'Calculo 1');
INSERT IGNORE INTO materia(sigla, nombre) VALUES('MAT-112', 'Algebra');
INSERT IGNORE INTO materia(sigla, nombre) VALUES('FHC-116', 'Revelacion y Fe');
INSERT IGNORE INTO materia(sigla, nombre) VALUES('INV-115', 'Tecnicas de Estudio');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ADM-212', 'Administración y Gestión Educativa I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('BIO-113', 'Fundamentos Biológicos de la Educación');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('FHC-126', 'Moral Cristiana, Iglesia y Sociedad');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('FHC-216', 'Biblia y Vida Cristiana');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('FHC-226', 'Sacramentos y Espiritualidad');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INF-122', 'Ofimática I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-121', 'Introducción a la Programación');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-211', 'Programación I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-221', 'Programación II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-311', 'Programación III');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-321', 'Programación Avanzada');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-411', 'Proyectos de Software');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-421', 'Ingeniería de Software I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-511', 'Ingeniería de Software II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('ING-512', 'Lenguajes Formales y Compiladores');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INV-125', 'Introducción al Pensamiento Científico');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INV-416', 'Metodología de la Investigación I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INV-426', 'Metodología de la Investigación II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INV-516', 'Taller de Grado I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('INV-525', 'Taller de Grado II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LEN-114', 'Expresión Oral y Escrita I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LEN-124', 'Expresión Oral y Escrita II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LIN-415', 'Optativa I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LIN-425', 'Optativa II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LIN-515', 'Optativa III');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('LIN-524', 'Optativa IV');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-124', 'Cálculo II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-212', 'Estadística I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-213', 'Álgebra Lineal');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-214', 'Cálculo III');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-224', 'Estadistica II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-314', 'Análisis Numérico');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-324', 'Investigación Operativa I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('MAT-413', 'Investigación Operativa II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('PED-111', 'Introducción a las Ciencias de la Educación');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('PED-121', 'Pedagogía General');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('PED-211', 'Corrientes Pedagógicas Contemporáneas');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-125', 'Electrónica I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-215', 'Electrónica II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-225', 'Sistemas Digitales');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-315', 'Hardware y Arquitectura de Computadoras');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-325', 'Redes de Computadoras');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-414', 'Redes y Comunicaciones');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('RED-422', 'Ingeniería de Redes');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-423', 'Inteligencia Artificial I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-424', 'Ingeniería de Sistemas I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-513', 'Inteligencia Artificial II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-514', 'Ingenieria de Sistemas II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-522', 'Simulación y Modelación');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIM-523', 'Sistemas de Control Digital');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-122', 'Introducción a los Sistemas Administrativos');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-123', 'Sistemas de Información Contable');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-222', 'Base de Datos I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-223', 'Análisis y Diseño de Sistemas I');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-312', 'Base de Datos II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-313', 'Análisis y Diseño de Sistemas II');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-322', 'Teoría de los Sistemas de Información');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-323', 'Sistemas Operativos');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SIS-412', 'Programación en Internet');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SOC-112', 'Sociedad y Estado');
INSERT IGNORE INTO materia (sigla, nombre) VALUES ('SOC-123', 'Sociologia de la Educación');

--DOCENTES
--111
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(1, 'ING-111', 2222224);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(2, 'LIN-114', 22225);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(3, 'MAT-113', 2222231);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(4, 'MAT-112', 222223);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(5, 'FHC-116', 22227);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(6, 'INV-115', 222221);
--112
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(7, 'ING-111', 2222251);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(8, 'LIN-114', 22219);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(9, 'MAT-113', 2222234);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(10, 'MAT-112', 22215);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(11, 'FHC-116', 2222230);
INSERT IGNORE INTO materia_docente(id_materia_docente, sigla, ci) VALUES(12, 'INV-115', 2222241);

INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(1, 'Ingieneria de Sistemas');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(2, 'Contaduria Publica');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(3, 'Derecho');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(4, 'Educacion Parvularia');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(5, 'Ingieneria Comercial y Desarrollo de Negocios');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(6, 'Gastronomia y Gestion de Restaurantes');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(7, 'Ciencias de la Educacion');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(8, 'Psicomotricidad');

--DOCENTES
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(1, 1, 'ING-111', 1, TRUE);
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(2, 1, 'LIN-114', 1, TRUE);
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(3, 1, 'MAT-113', 1, TRUE);
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(4, 1, 'MAT-112', 1, TRUE);
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(5, 1, 'FHC-116', 1, FALSE);
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(6, 1, 'INV-115', 1, FALSE);
    --eliminar mas adelante
INSERT IGNORE INTO materia_carrera_semestre(id_materia_carrera_semestre, id_carrera, sigla, id_semestre, activo) VALUES(7, 2, 'INV-115', 6, TRUE);

INSERT IGNORE INTO turno(id_turno, nombre) VALUES(1, 'Mañana');
INSERT IGNORE INTO turno(id_turno, nombre) VALUES(2, 'Tarde');
INSERT IGNORE INTO turno(id_turno, nombre) VALUES(3, 'Noche');

INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(1, 'Lunes');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(2, 'Martes');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(3, 'Miercoles');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(4, 'Jueves');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(5, 'Viernes');

--Lunes-Mañana
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(1, '7:30', '9:00', 1, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(2, '9:15', '10:45', 1, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(3, '11:00', '12:30', 1, 1);
--Martes-Mañana
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(4, '7:30', '9:00', 2, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(5, '9:15', '10:45', 2, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(6, '11:00', '12:30', 2, 1);
--Miercoles-Mañana
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(7, '7:30', '9:00', 3, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(8, '9:15', '10:45', 3, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(9, '11:00', '12:30', 3, 1);
--Jueves-Mañana
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(10, '7:30', '9:00', 4, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(11, '9:15', '10:45', 4, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(12, '11:00', '12:30', 4, 1);
--Viernes-Mañana
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(13, '7:30', '9:00', 5, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(14, '9:15', '10:45', 5, 1);
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(15, '11:00', '12:30', 5, 1);

--Miercoles-Noche
INSERT IGNORE INTO horario(id_horario, hora_inicio, hora_fin, id_dia, id_turno) VALUES(16, '20:30', '21:45', 3, 3);

--Aula
INSERT IGNORE INTO aula(id_aula, aula, paralelo, piso, bloque) VALUES(1, 'A2', '111', 'P2', 'B');
INSERT IGNORE INTO aula(id_aula, aula, paralelo, piso, bloque) VALUES(2, 'A3', '112', 'P2', 'B');

--DOCENTES
--111
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(1, 1, 1);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(2, 2, 1);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(3, 3, 1);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(4, 4, 1);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(5, 5, 1);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(6, 6, 1);
--112
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(7, 7, 2);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(8, 8, 2);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(9, 9, 2);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(10, 10, 2);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(11, 11, 2);
INSERT IGNORE INTO aula_materia_docente(id_aula_materia_docente, id_materia_docente, id_aula) VALUES(12, 12, 2);

-- 111
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente, nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(1,  4, TRUE, 1, 1);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(2,  NULL, FALSE, 2, 2);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(3,  NULL, FALSE, 3, 3);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(4,  NULL, FALSE, 4, 4);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(5,  NULL, FALSE, 5, 5);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(6,  NULL, FALSE, 6, 1);

INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(7,  NULL, FALSE, 10, 4);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(8,  NULL, FALSE, 11, 2);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(9,  NULL, FALSE, 12, 6);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(10,  NULL, FALSE, 13, 6);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(11,  NULL, FALSE, 14, 3);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(12,  NULL, FALSE, 15, 5);

--112
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(13,  NULL, FALSE, 1, 12);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(14,  4, TRUE, 2, 9);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(15,  NULL, FALSE, 3, 8);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(16,  NULL, FALSE, 4, 11);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(17,  4, TRUE, 5, 7);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(18,  NULL, FALSE, 6, 10);

INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(19,  NULL, FALSE, 10, 12);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(20,  NULL, FALSE, 11, 9);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(21,  NULL, FALSE, 12, 8);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(22,  NULL, FALSE, 13, 11);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(23,  NULL, FALSE, 14, 7);
INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(24,  NULL, FALSE, 15, 10);

INSERT IGNORE INTO horario_materia_docente(id_horario_materia_docente,  nro_laboratorio, laboratorio, id_horario, id_materia_docente) VALUES(25,  NULL, FALSE, 16, 10);
