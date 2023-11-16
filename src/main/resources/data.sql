
INSERT IGNORE INTO turno(id_turno, nombre) VALUES(1, 'Mañana');
INSERT IGNORE INTO turno(id_turno, nombre) VALUES(2, 'Tarde');
INSERT IGNORE INTO turno(id_turno, nombre) VALUES(3, 'Noche');

INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(1, 'Lunes');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(2, 'Martes');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(3, 'Miércoles');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(4, 'Jueves');
INSERT IGNORE INTO dia_semana(id_dia, nombre) VALUES(5, 'Viernes');

--Aula
INSERT IGNORE INTO aula(id_aula, aula, paralelo, piso, bloque) VALUES(1, 'A2', '111', 'P2', 'B');
INSERT IGNORE INTO aula(id_aula, aula, paralelo, piso, bloque) VALUES(2, 'A3', '112', 'P2', 'B');

INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(1, 'Ingeniería de Sistemas');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(2, 'Contaduría Pública');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(3, 'Derecho');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(4, 'Educación Parvularia');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(5, 'Ingeniería Comercial y Desarrollo de Negocios');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(6, 'Gastronomía y Gestión de Restaurantes');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(7, 'Ciencias de la Educación');
INSERT IGNORE INTO carrera(id_carrera, nombre) VALUES(8, 'Psicomotricidad');


-- CONTROL DE ASISTENCIA MODELO RELACIONAL NORMALIZADO
INSERT IGNORE INTO rol(id_rol, nombre) VALUES(1, 'USER');
INSERT IGNORE INTO rol(id_rol, nombre) VALUES(2, 'ADMIN');

INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia, activo, id_rol)
VALUES (11077821, 'Jorge Luis', 'Arone Delgado', 'JorgeLuisAroneDelgado11077821.jpg', 'jorgearone567@gmail.com', 'M',
        'jorge.arone@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 2);

INSERT IGNORE INTO supervisor(ci, reporte_email, reporte_institucional) VALUES(11077821, true, true);

-- INGENIERIA DE SISTEMAS
INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia, activo, id_rol)
VALUES (222221, 'Rita Roxana', 'Torrico', 'RitaRoxanaTorrico222221.jpg', 'ritatorrico222@gmail.com', 'F', 'rita.torrico@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222224, 'Lorena Morayma', 'Huasco Aruquipa', 'LorenaMoraymaHuascoAruquipa2222224.jpg', 'lorenahuasco222@gmail.com', 'F','lorena.huasco@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22225, 'Maribel', 'Apaza Atahuachi', 'MaribelApazaAtahuachi22225.jpg', 'marielapaza222@gmail.com', 'F','maribel.apaza@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222231, 'Erik Alvaro', 'Mamani Callisaya', 'ErikAlvaroMamaniCallisaya2222231.jpg', 'erikmamanicallisaya222@gmail.com', 'M','erik.mamani@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (222223, 'Ariel Naddir', 'Aguilar Duran', 'ArielNaddirAguilarDuran222223.jpg', 'arielaguilar222@gmail.com', 'M','ariel.aguilar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22227, 'Angela Raquel', 'Blanco Velasquez', 'AngelaRaquelBlancoVelasquez22227.jpg', 'angelablanco222@gmail.com', 'F','angela.blanco@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222241, 'Maria Elizabeth', 'Quezada Gutierrez', 'MariaElizabethQuezadaGutierrez2222241.jpg', 'mariaquezada222@gmail.com', 'F','maria.quezada@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222234, 'Maria Nila', 'Morales Quispe', 'MariaNilaMoralesQuispe2222234.jpg', 'mariamorales222@gmail.com', 'F','maria.morales@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22219, 'Alfonso Martin', 'Flores Chumacero', 'AlfonsoMartinFloresChumacero22219.jpg', 'alfonsoflores222@gmail.com', 'M','alfonso.flores@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222230, 'Erik Elio', 'Mamani Padilla', 'ErikElioMamaniPadilla2222230.jpg', 'erikmamani222@gmail.com', 'M','erik.mamani@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222251, 'Adalid Irvin', 'Yujra Alí', 'AdalidIrvinYujraAlí2222251.jpg', 'adalidyujra222@gmail.com', 'M','adalid.yujra@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22215, 'Fernando Ramiro', 'estrada Navia', 'FernandoRamiroestradaNavia22215.jpg', 'fernandoestrada222@gmail.com', 'M','fernando.estrada@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222235, 'Victor Raul', 'Moran Valencia', 'VictorRaulMoran Valencia2222235.jpg', 'victormoran222@gmail.com', 'M','victor.moran@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222245, 'Nicolas', 'Salvador Flores', 'NicolasSalvadorFlores.jpg', 'nicolassalvador222@gmail.com', 'M','nicolas.salvador@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222251, 'Adalid Irvin', 'Yujra Alí', 'AdalidIrvinyujraAlí.jpg', 'adalidyujra222@gmail.com', 'M','adalid.yujra@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222228, 'Nélson Ramiro', 'López Velasco', 'NelsonRamiroLopezVelasco.jpg', 'nelsonlopez222@gmail.com', 'M','nelson.lopez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (222222, 'Denise Cleofe', 'Aguilar Aliga', 'DeniseCleofeAguilarAliga.jpg', 'deniseaguilar222@gmail.com', 'F','denise.aguilar@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22211, 'Ingrid Ximena', 'Claros Fuentes', 'IngridXimenaClarosFuentes.jpg', 'ingridclaros222@gmail.com', 'F','ingrid.claros@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222229, 'Grover Milton', 'Magueño Gordillo', 'GroverMiltonmagueñoGordillo.jpg', 'grovermagueño222@gmail.com', 'M','grover.magueño@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22229, 'Tito Isrrael', 'Chavez Mamani', 'TitoIsrraelChavezMamani.jpg', 'titochavez222@gmail.com', 'M','tito.chavez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222221, 'Claudia Raquel', 'Guevara Murillo', 'ClaudiaRaquelGuevaraMurillo.jpg', 'claudiaguevara222@gmail.com', 'F','claudia.guevara@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222240, 'Katya Maricela', 'Pérez Martínez', 'KatiaMaricelaPerezMartínez.jpg', 'katyaperez222@gmail.com', 'F','katya.perez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22219, 'Alfonso Martin', 'Flores Chumacero', 'AlfonsoMartinfloresChumacero.jpg', 'alfonsoflores222@gmail.com', 'M','alfonso.flores@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222233, 'Cristian', 'Mondaca Cori', 'CristianMondacaCori.jpg', 'cristianmondaca222@gmail.com', 'M','cristian.mondaca@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222238, 'Edgardo Ilich', 'Pabón Morales', 'EdgardoIlichpabonMorales.jpg', 'edgardopavon222@gmail.com', 'M','edgardo.pabon@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222249, 'David', 'Valero Llanos', 'DavidValeroLlanos.jpg', 'davidvalero222@gmail.com', 'M','david.valero@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22212, 'Mónica', 'Cuiza Beltrán', 'MónicaCuizaBeltrán.jpg', 'monicacuiza222@gmail.com', 'F','monica.cuiza@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222227, 'Edwing', 'López Florez', 'EdwingLópezFlorez.jpg', 'edwinglopez222@gmail.com', 'M','edwing.lopez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222246, 'Luis', 'Segales Espinoza', 'LuisSegalesEspinoza.jpg', 'luissegales222@gmail.com', 'M','luis.segales@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222226, 'Jorge Luis', 'Limachi Quispe', 'JorgeLuisLimachiQuispe.jpg', 'jorgelimachi222@gmail.com', 'M','jorge.limachi@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22224, 'Elias', 'Ali Alvarez', 'EliasAliAlvarez.jpg', 'eliasali222@gmail.com', 'M','elias.ali@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222223, 'Erlinda Elvira', 'Gutierrez Poma', 'ErlindaElviragutierrezPoma.jpg', 'erlindagutierrez222@gmail.com', 'F','erlinda.gutierrez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22222243, 'Carlos Pedro', 'Saaverda Salazar', 'CarlosPedroSaavedraSalazar.jpg', 'carlossaavedra222@gmail.com', 'M','carlos.saavedra@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22220, 'Freddy Cosme', 'Garnica Carrasco', 'FreddyCosmeGarnicaCarrasco.jpg', 'freddygarnica222@gmail.com', 'M','freddy.garnica@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22218, 'Epifanio Johny', 'Flores Flores', 'EpifanioJohnyFloresFlores.jpg', 'epifanioflores222@gmail.com', 'M','epifanio.flores@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222251, 'Hernando Enrique', 'Zarate Armijo', 'HernandoEnriqueZarateArmijo.jpg', 'hernandozarate222@gmail.com', 'M','hernando.zarate@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22216, 'Luis Vladimir', 'fernandez Ramos', 'LuisVladimirFernandezRamos.jpg', 'luisfernandez222@gmail.com', 'M','luis.fernandez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222242, 'Jesús Juan', 'Rocha Vera', 'JesúsJuanRochaVera.jpg', 'jesusrocha222@gmail.com', 'M','jesus.rocha@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22226, 'Porfirio', 'Arduz Urquieta', 'PorfirioArduzUrquieta.jpg', 'porfirioarduz222@gmail.com', 'M','porfirio.arduz@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222237, 'Juan Jose', 'Ortiz Copa', 'JuanJoseOrtizCopa.jpg', 'juanortiz222@gmail.com', 'M','juan.ortiz@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22214, 'Beatriz Mariel', 'Escóbar Olivarez', 'BeatrizMarielEscobarOlivarez.jpg', 'beatrizescobar222@gmail.com', 'F','beatriz.escobar@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222242, 'Adrian Eusebio', 'Quisbert Vilela', 'AdrianEusebioQuisbertVilela.jpg', 'adrianquisbert222@gmail.com', 'M','adrian.quisbert@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222227, 'Edwing', 'López Florez', 'EdwingLópezFlorez.jpg', 'edwinglopez222@gmail.com', 'M','edwing.lopez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222236, 'Rubi Daniela', 'Mujica Quisbert', 'RubiDanielaMujicaQuisbert.jpg', 'rubimujica222@gmail.com', 'F','rubi.mujica@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222232, 'Carmen Rosa', 'Mollinedo Laura', 'CarmenRosaMollinedoLaura.jpg', 'carmenmollinedo222@gmail.com', 'F','carmen.mollinedo@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22217, 'Miguel', 'Flores Chumacero', 'MiguelfloresChumacero.jpg', 'miguelflores222@gmail.com', 'M','miguel.flores@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222247, 'Liz Wendy', 'Sepulveda Medina', 'LizWendySepulvedaMedina.jpg', 'lizsepulveda222@gmail.com', 'F','liz.sepulveda@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222250, 'Ivan Amado', 'Verastegui Palao', 'IvanAmadoVerasteguiPalao.jpg', 'ivanverastegui222@gmail.com', 'M','ivan.verastegui@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22213, 'Carla Silvana', 'Escóbar Olivarez', 'CarlaSilvanaEscóbarOlivarez.jpg', 'carlaescobar222@gmail.com', 'F','carla.escobar@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222222, 'Freddy Felix', 'Gutierrez Chavez', 'FreddyFelixGutierrezChavez.jpg', 'freddygutierrez222@gmail.com', 'M','freddy.gutierrez@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222244, 'Freddy', 'Salgueiro Trujillo', 'FreddySalgueiroTrujillo.jpg', 'freddysalgueiro222@gmail.com', 'M','freddy.salgueiro@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222239, 'Juan Alejandro', 'Palomino López', 'JuanAlejandroPalominoLópez.jpg', 'juanpalomino222@gmail.com', 'M','juan.palomino@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22210, 'Karen Ruth', 'Chura Gonzales', 'KarenRuthChuraGonzales.jpg', 'karenchura222@gmail.com', 'F','karen.chura@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (22228, 'Angela del Pilar', 'Castellón Gorena', 'AngeladelpilarcastellonGorena.jpg', 'angeladelpilarcastellon222@gmail.com', 'F','angeladelpilar.castellon@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222248, 'Kevin Marlon', 'Soza Mamani', 'KevinMarlonSozaMamani.jpg', 'kevinsoza222@gmail.com', 'M','kevin.soza@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2222225, 'Edwin Marcos', 'Juchani Monrroy', 'EdwinMarcosJuchaniMonrroy.jpg', 'edwinjuchani222@gmail.com', 'M','edwin.juchani@usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (2000402,'Paola Andrea', 'Bernal Ramirez', 'PaolaAndreaBernalRamirez.jpg', 'paolabernal77@gmail.com', 'F','paola.bernal@servicios.usalesiana.edu.bo','$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1);



-- DERECHO

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
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222235, 'FFFFFFF');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222245, 'FFFFFF23');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222251, 'FOFFFOF23');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22215, 'RANNNN20');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222235, 'VICRA2100');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222228, 'NELRA779');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(222222, 'DENCLEO977');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22211, 'INGXIM4511');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222229, 'GROVMILT9011');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22229, 'TITISR4086');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222221, 'CLAURAQU6510');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222240, 'KATMAR6221');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22219, 'ALFOMAART8815');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222233, 'CRISMOND21044');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222249, 'DAVVALLL45611');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22212, 'MONICUI110055');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222227, 'EDWLOFL9950');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222246, 'LIUUSEES67121334');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222226, 'JORLULIM22089');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22224, 'ELIALQT511');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222223, 'EERLIALERJ9901');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222223, 'CARPE239SAA10');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22220, 'FRECOSGAR4451');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22218, 'EPIFJH8801');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222251, 'HERNENRI223009');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22216, 'LUIVLA4451173');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222242, 'JEJURO98112');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22226, 'PORFARDU779011');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222237, 'JUJOORCO8911445');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22214, 'BEAMARI23990');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222242, 'ADSRIEUSEQU8831700');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222227, 'EDWILOFL9902227');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222236, 'RUBDANI0000317');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222232, 'CARMROS3338066');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22217, 'MIGFLCHU8871130');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222247, 'LIZWEN44650056578');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222250, 'IVAAMA4456780121');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22213, 'CARLSILVA999033');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222222, 'FREDDFEL88933335');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222244, 'DRESALGTR5567002');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222239, 'JUAALEH679CVB54');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22210, 'KARERUT6672G');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(22228, 'ANGDELPIL990331VC');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222248, 'KEVMAR99044461');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2222225, 'EDWMAR456YHU811');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(2000402, 'PAOLBERNn562210');

INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia, activo, id_rol)
VALUES (44441, 'Jose Armando', 'Chavez', 'JoseArmandoChavez.jpg', 'JoseArmando55@gmail.com', 'M', 'jose.chavez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44442,'Oscar Ricardo', 'Chuquimia', 'OscarRicardoChuquimia.jpg', 'Chuquimia67@gmail.com', 'M', 'oscar.chuquimia@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44443,'Diego Antonio', 'Perez', 'DiegoAntonioPerez.jpg', 'DiegoAntonio11@gmail.com', 'M', 'diego.perez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44444,'Edgar Gustavo', 'Aguilar Camacho', 'EdgarGustavoAguilarCamacho.jpg', 'EdgarGustavoAguilar@gmail.com', 'M', 'edgar.aguilar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44445,'Virginia Paula', 'Aguirre Calani', 'VirginiaPaulaAguirreCalani.jpg', 'VirginiaPaulaAguirreCalani@gmail.com', 'F', 'virginia.aguirre@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44446,'Robin Daniel', 'Aliaga Gonzales', 'RobinDanielAliagaGonzales.jpg', 'RobinDanielAliagaGonzales@gmail.com', 'M', 'robin.aliaga@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44447,'Patricia Monica', 'Alvarez Navarrete', 'PatriciaMonicaAlvarezNavarrete.jpg', 'PatriciaMonicaAlvarezNavarrete@gmail.com', 'F', 'patricia.alvarez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44448,'Ramiro Amilcar', 'Andrade Quisbert', 'RamiroAmilcarAndradeQuisbert.jpg', 'RamiroAmilcarAndradeQuisbert@gmail.com', 'M', 'ramiro.andrade@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44449,'Marco Antonio', 'Apaza Callizaya', 'MarcoAntonioApazaCallizaya.jpg', 'MarcoAntonioApazaCallizaya@gmail.com', 'M', 'marco.apaza@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44410,'Carlos Urcino', 'Aquino Rubin de Celis','CarlosUrcinoAquinoRubindeCelis.jpg', 'RubindeCelis@gmail.com', 'M', 'carlos.aquino@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44411,'Franz Gabriel', 'Arroyo Salazar', 'FranzGabrielArroyoSalazar.jpg', 'FranzGabrielArroyoSalazar@gmail.com', 'M', 'franz.arroyo@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44412,'Rolando Andres', 'Avila Blacutt', 'RolandoAndresAvilaBlacutt.jpg', 'RolandoAndresAvilaBlacutt@gmail.com', 'M', 'rolando.avila@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44413,'Claudia Cecilia', 'Balboa Bernal', 'ClaudiaCeciliaBalboaBernal.jpg', 'ClaudiaCeciliaBalboaBernal@gmail.com', 'F', 'claudia.balboa@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44414,'Oscar Isaac', 'Blanco Cuenca', 'OscarIsaacBlancoCuenca.jpg', 'OscarIsaacBlancoCuenca@gmail.com', 'M', 'oscar.blanco@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44415,'Gonzalo', 'Brañez Mendoza', 'GonzaloBrañezMendoza.jpg', 'GonzaloBrañezMendoza@gmail.com', 'M', 'gonzalo.brañez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44416,'Nidia Maricianca', 'Bulacia Perez', 'NidiaMariciancaBulaciaPerez.jpg', 'NidiaMariciancaBulaciaPerez@gmail.com', 'F', 'nidia.bulacia@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44417,'Marisol', 'Bulucua Camacho', 'MarisolBulucuaCamacho.jpg', 'MarisolBulucuaCamacho@gmail.com', 'F', 'marisol.bulucua@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44418,'Hector Israel', 'Calani Chavez', 'HectorIsraelCalaniChavez.jpg', 'HectorIsraelCalaniChavez@gmail.com', 'M', 'hector.calani@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44419,'Fernando Antonio', 'Calderon Eduardo', 'FernandoAntonioCalderonEduardo.jpg', 'FernandoAntonioCalderonEduardo@gmail.com', 'M', 'fernando.calderon@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44420,'Sixto', 'Calle Palacios', 'SixtoCallePalacios.jpg', 'SixtoCallePalacios@gmail.com', 'M', 'sixto.calle@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44421,'Juan Carlos', 'Capra Guerrero', 'JuanCarlosCapraGuerrero.jpg', 'JuanCarlosCapraGuerrero@gmail.com', 'M', 'juan.capra@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1);




INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44441, 'josarmavhgj35657');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44442, 'OSCCHUE496NN');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44443, 'DIEPER55507');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44444, 'EDGGU33354561J');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44445, 'VIRPAU88806XX');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44446, 'ROBBDANIE334TT');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44447, 'PATRMONI44RV881');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44448, 'RAMIAMILC558110');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44449, 'MARANTAP3348TN11');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44410, 'carrubdece333120g');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44411, 'FRGABR550ARRY00');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44412, 'ROLANAVI773100VF');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44413, 'CLAUBALBO555771DD');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44414, 'OSCISSBL6669121DV');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44415, 'GONBRFAÑ55591D22');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44416, 'NIDIAMRI666711CVB0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44417, 'MABULU777901145LL');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44418, 'HECIS559CAL1200');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44419, 'FER332CALD44965');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44420, 'SIX238CALL00999');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44420, 'SIX238CALL00999');

INSERT IGNORE INTO persona(ci, nombre, apellido, fotografia, email, genero,  correo_institucional, contrasenia, activo, id_rol)
VALUES (44422,'Heldy Shirley', 'Cardenas Mendez', 'HeldyShirleyCardenasMendez.jpg', 'HeldyShirleyCardenasMendez@gmail.com', 'F', 'heldy.cardenas@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44423,'Rodrigo', 'Carrillo Limachi', 'RodrigoCarrilloLimachi.jpg', 'RodrigoCarrilloLimachi@gmail.com', 'M', 'rodrigo.carrillo@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44424,'Humberto Stephano', 'Carbajal Flores', 'HumbertoStephanoCarbajalFlores.jpg', 'HumbertoStephanoCarbajalFlores@gmail.com', 'M', 'humberto.carbajal@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44425,'Neddy Etman', 'Choque Flores', 'NeddyEtmanChoqueFlores.jpg', 'NeddyEtmanChoqueFlores@gmail.com', 'M', 'neddy.choque@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44426,'Romelio Oscar', 'Coca Untoja', 'RomelioOscarCocaUntoja.jpg', 'RomelioOscarCocaUntoja@gmail.com', 'M', 'romelio.coca@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44427,'Victor Diego', 'Cruz Villca', 'VictorDiegoCruzVillca.jpg', 'VictorDiegoCruzVillca@gmail.com', 'M', 'victor.cruz@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44428,'Edgar Diego', 'Davila Camacho', 'EdgarDiegoDavilaCamacho.jpg', 'EdgarDiegoDavilaCamacho@gmail.com', 'M', 'edgar.davila@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44429,'Celia Rosmery', 'Deheza Flores', 'CeliaRosmeryDehezaFlores.jpg', 'CeliaRosmeryDehezaFlores@gmail.com', 'F', 'celia.deheza@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44430,'Ariel Gustavo', 'Delgado Mamani', 'ArielGustavoDelgadoMamani.jpg', 'ArielGustavoDelgadoMamani@gmail.com', 'M', 'ariel.delgado@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44431,'Valentin Antonio', 'Encinas Flores', 'ValentinAntonioEncinasFlores.jpg', 'ValentinAntonioEncinasFlores@gmail.com', 'M', 'valentin.encinas@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44432,'Marga Ruth', 'Escobar Yujra', 'MargaRuthEscobarYujra.jpg', 'MargaRuthEscobarYujra@gmail.com', 'F', 'marga.escobar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44433,'Mireya Eliana', 'Escobar Herrera', 'MireyaElianaEscobarHerrera.jpg', 'MireyaElianaEscobarHerrera@gmail.com', 'F', 'mireya.escobar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44434,'Marcelo Augusto', 'Esprella Torrico', 'MarceloAugustoEsprellaTorrico.jpg', 'MarceloAugustoEsprellaTorrico@gmail.com', 'M', 'marcelo.esprella@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44435,'Armando David', 'Fernandez Rodriguez', 'ArmandoDavidFernandezRodriguez.jpg', 'ArmandoDavidFernandezRodriguez@gmail.com', 'M', 'armando.fernandez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44436,'Marcelo Herson', 'Flores Ramirez', 'MarceloHersonFloresRamirez.jpg', 'MarceloHersonFloresRamirez@gmail.com', 'M', 'marcelo.flores@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44437,'Marcela Victoria', 'Flores Baptista', 'MarcelaVictoriaFloresBaptista.jpg', 'MarcelaVictoriaFloresBaptista@gmail.com', 'F', 'marcela.flores@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44438,'Ramiro', 'Gambarte Calvimontes', 'RamiroGambarteCalvimontes.jpg', 'RamiroGambarteCalvimontes@gmail.com', 'M', 'ramiro.gambarte@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44439,'Fatima Alison', 'Gutierrez Soliz', 'FatimaAlisonGutierrezSoliz.jpg', 'FatimaAlisonGutierrezSoliz@gmail.com', 'F', 'fatima.gutierrez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44440,'Lucio Emilio', 'Guzman Tapia', 'LucioEmilioGuzmanTapia.jpg', 'LucioEmilioGuzmanTapia@gmail.com', 'M', 'lucio.guzman@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44441,'Rodolfo Raul', 'Jimenez Vilavicencio', 'RodolfoRaulJimenezVilavicencio.jpg', 'RodolfoRaulJimenezVilavicencio@gmail.com', 'M', 'rodolfo.jimenez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44442,'Mireya Eliana', 'Escobar Herrera', 'MireyaElianaEscobarHerrera.jpg', 'MireyaElianaEscobarHerrera@gmail.com', 'F', 'mireya.escobar@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44443,'Yeffry Yamil', 'Kafka Delgado', 'YeffryYamilKafkaDelgado.jpg', 'YeffryYamilKafkaDelgado@gmail.com', 'M', 'yeffry.kafka@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44444,'Giovanna', 'Lazcano Miranda', 'GiovannaLazcanoMiranda.jpg', 'GiovannaLazcanoMiranda@gmail.com', 'F', 'giovanna.lazcano@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44445,'Mariel Andrea', 'Limadin Flores', 'MarielAndreaLimadinFlores.jpg', 'MarielAndreaLimadinFlores@gmail.com', 'F', 'mariel.limadin@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44446,'Juan Victor', 'Lopez Colquehuanca', 'JuanVictorLopezColquehuanca.jpg', 'JuanVictorLopezColquehuanca@gmail.com', 'M', 'juan.lopez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44447,'Ariel Alejandro', 'Luna Maruvia', 'ArielAlejandroLunaMaruvia.jpg', 'ArielAlejandroLunaMaruvia@gmail.com', 'M', 'ariel.luna@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44448,'Ronal', 'Maca Huanca', 'RonalMacaHuanca.jpg', 'RonalMacaHuanca@gmail.com', 'M', 'ronal.maca@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44449,'Marco Antonio', 'Machicado Orosco', 'MarcoAntonioMachicadoOrosco.jpg', 'MarcoAntonioMachicadoOrosco@gmail.com', 'M', 'marco.machicado@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44450,'Amel Abel', 'Maldonado Alvarez', 'AmelAbelMaldonadoAlvarez.jpg', 'AmelAbelMaldonadoAlvarez@gmail.com', 'M', 'amel.maldonado@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44451,'Erick Grover', 'Miranda Gutierrez', 'ErickGroverMirandaGutierrez.jpg', 'ErickGroverMirandaGutierrez@gmail.com', 'M', 'erick.miranda@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44452,'Nataly Isabel', 'Morato Hurtado', 'NatalyIsabelMoratoHurtado.jpg', 'NatalyIsabelMoratoHurtado@gmail.com', 'F', 'nataly.morato@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44453,'Ana Maria', 'Olivio Arispe', 'AnaMariaOlivioArispe.jpg', 'AnaMariaOlivioArispe@gmail.com', 'F', 'ana.olivio@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44454,'Iveth', 'Orellana Vera', 'IvethOrellanaVera.jpg', 'IvethOrellanaVera@gmail.com', 'F', 'iveth.orellana@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44455,'Luis Abelardo', 'Pabon Morales', 'LuisAbelardoPabonMorales.jpg', 'LuisAbelardoPabonMorales@gmail.com', 'M', 'luis.pabon@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44456,'Oscar Ivan', 'Paz Contreras', 'OscarIvanPazContreras.jpg', 'OscarIvanPazContreras@gmail.com', 'M', 'oscar.paz@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44457,'Juan Gabriel', 'Perez Roque', 'JuanGabrielPerezRoque.jpg', 'JuanGabrielPerezRoque@gmail.com', 'M', 'juan.perez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44458,'Wascar Pablo', 'Perez Ayala', 'WascarPabloPerezAyala.jpg', 'WascarPabloPerezAyala@gmail.com', 'M', 'wascar.perez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44459,'Maribel Patricia', 'Pinto Vargas', 'MaribelPatriciaPintoVargas.jpg', 'MaribelPatriciaPintoVargas@gmail.com', 'F', 'maribel.pinto@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44460,'Oscar Ariel', 'Poma Chuquimia', 'OscarArielPomaChuquimia.jpg', 'OscarArielPomaChuquimia@gmail.com', 'M', 'oscar.poma@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44461,'Ana Maria Ricarda', 'Quintana Vargas', 'AnaMariaRicardaQuintanaVargas.jpg', 'AnaMariaRicardaQuintanaVargas@gmail.com', 'F', 'ana.quintana@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44462,'Estenka', 'Quintanilla Lopez', 'EstenkaQuintanillaLopez.jpg', 'EstenkaQuintanillaLopez@gmail.com', 'F', 'estenka.quintanilla@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44463,'Jose Luis', 'Quiroga Altamirano', 'JoseLuisQuirogaAltamirano.jpg', 'JoseLuisQuirogaAltamirano@gmail.com', 'M', 'jose.quiroga@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44464,'Lidia Virginia', 'Quisberth Flores', 'LidiaVirginiaQuisberthFlores.jpg', 'LidiaVirginiaQuisberthFlores@gmail.com', 'F', 'lidia.quisberth@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44465,'Juvenal', 'Quispe Huanca', 'JuvenalQuispeHuanca.jpg', 'JuvenalQuispeHuanca@gmail.com', 'M', 'juvenal.quispe@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44466,'Tania Mireya', 'Revilla Claure', 'TaniaMireyaRevillaClaure.jpg', 'TaniaMireyaRevillaClaure@gmail.com', 'F', 'tania.revilla@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44467,'Omar Alberto', 'Revollo Riveros', 'OmarAlbertoRevolloRiveros.jpg', 'OmarAlbertoRevolloRiveros@gmail.com', 'M', 'omar.revollo@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44468,'Cristina Roxana', 'Rodrigo Velásquez', 'CristinaRoxanaRodrigoVelásquez.jpg', 'CristinaRoxanaRodrigoVelásquez@gmail.com', 'F', 'crisitina.rodrigo@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44469,'Juan Mirko', 'Rodriguez Franco', 'JuanMirkoRodriguezFranco.jpg', 'JuanMirkoRodriguezFranco@gmail.com', 'M', 'juan.rodriguez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44470,'Juan Pablo', 'Rojas Rada', 'JuanPabloRojasRada.jpg', 'JuanPabloRojasRada@gmail.com', 'M', 'juan.rojas@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44471,'Jose Manuel', 'Rojas Pradel', 'JoseManuelRojasPradel.jpg', 'JoseManuelRojasPradel@gmail.com', 'M', 'jose.rojas@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44472,'Edmundo Primitivo', 'Sanchez Zurita', 'EdmundoPrimitivoSanchezZurita.jpg', 'EdmundoPrimitivoSanchezZurita@gmail.com', 'M', 'edmundo.sanchez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44473,'Marcela', 'Sandi Bellido', 'MarcelaSandiBellido.jpg', 'MarcelaSandiBellido@gmail.com', 'F', 'marcela.sandi@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44474,'Leila', 'Tapia Suarez', 'LeilaTapiaSuarez.jpg', 'LeilaTapiaSuarez@gmail.com', 'F', 'leila.tapia@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44475,'Cristian Wilson', 'Tarifa Foronda', 'CristianWilsonTarifaForonda.jpg', 'CristianWilsonTarifaForonda@gmail.com', 'M', 'cristian.tarifa@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44476,'Jaime Clemente', 'Ticona Cruz', 'JaimeClementeTiconaCruz.jpg', 'JaimeClementeTiconaCruz@gmail.com', 'M', 'jaime.ticona@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44477,'Vladimir Roger', 'Torrez Monasterios', 'VladimirRogerTorrezMonasterios.jpg', 'VladimirRogerTorrezMonasterios@gmail.com', 'M', 'vladimir.torrez@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44478,'Maria Eugenia', 'Ugarte Cornejo', 'MariaEugeniaUgarteCornejo.jpg', 'MariaEugeniaUgarteCornejo@gmail.com', 'F', 'maria.ugarte@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44479,'Stefani Ruth', 'Uriarte Bothelo', 'StefaniRuthUriarteBothelo.jpg', 'StefaniRuthUriarteBothelo@gmail.com', 'F', 'stefani.uriarte@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44480,'Ludwig Ángel', 'Valverde Botello', 'LudwigÁngelValverdeBotello.jpg', 'LudwigÁngelValverdeBotello@gmail.com', 'M', 'ludwing.valverde@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44481,'Luis Rene', 'Vargas Rodriguez', 'LuisReneVargasRodriguez.jpg', 'LuisReneVargasRodriguez@gmail.com', 'M', 'luis.vargas@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44482,'Ivan Amado', 'Verategui Palao', 'IvanAmadoVerateguiPalao.jpg', 'IvanAmadoVerateguiPalao@gmail.com', 'M', 'ivan.verastegui@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44483,'Javier', 'Vilaseca Velasco', 'JavierVilasecaVelasco.jpg', 'JavierVilasecaVelasco@gmail.com', 'M', 'javier.vilaseca@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44484,'Mary Fortunata', 'Villena Almendras', 'MaryFortunataVillenaAlmendras.jpg', 'MaryFortunataVillenaAlmendras@gmail.com', 'F', 'mary.villena@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44485,'Javier Antonio', 'Viscarra Osuna', 'JavierAntonioViscarraOsuna.jpg', 'JavierAntonioViscarraOsuna@gmail.com', 'M', 'javier.viscarra@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44486,'Patricia Alejandra', 'Yapu Alcazar', 'PatriciaAlejandraYapuAlcazar.jpg', 'PatriciaAlejandraYapuAlcazar@gmail.com', 'F', 'patricia.yapu@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1),
       (44487,'Sergio Estephen', 'Zamorano Pinilla', 'SergioEstephenZamoranoPinilla.jpg', 'SergioEstephenZamoranoPinilla@gmail.com', 'M', 'sergio.zamorano@usalesiana.edu.bo', '$2a$10$bhC2WU3LGtlCC8lGNOpzhOtQbDQfGkTS/axflao.Bs2II8kGWwdKi', TRUE, 1);


INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44441, 'josarmavhgj35657');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44442, 'OSCCHUE496NN');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44443, 'DIEPER55507');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44444, 'EDGGU33354561J');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44445, 'VIRPAU88806XX');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44446, 'ROBBDANIE334TT');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44447, 'PATRMONI44RV881');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44448, 'RAMIAMILC558110');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44449, 'MARANTAP3348TN11');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44410, 'carrubdece333120g');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44411, 'FRGABR550ARRY00');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44412, 'ROLANAVI773100VF');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44413, 'CLAUBALBO555771DD');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44414, 'OSCISSBL6669121DV');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44415, 'GONBRFAÑ55591D22');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44416, 'NIDIAMRI666711CVB0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44417, 'MABULU777901145LL');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44418, 'HECIS559CAL1200');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44419, 'FER332CALD44965');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44420, 'SIX238CALL00999');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44421, 'JUAMCARl4450212F');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44422, 'HEY44CARD51111');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44423, 'RODR88ARRI008');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44424, 'HUM11CA99RBJA10');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44425, 'NED9YDYCHO1QPL');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44426, 'ROM110LI55COC00');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44427, 'VIC5597TOCR12Z');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44428, 'EDG009DAVI4450');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44429, 'CELL9986DEHE00ZA');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44430, 'AR3392ILDEL3119');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44431, 'VALEN222347ANRON0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44432, 'MAR557GA00ESCO66');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44433, 'MRE38YAESCO110BAR');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44434, 'MARCE00096ESPRE128');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44435, 'ARMAN557FERNA10');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44436, 'MARC00LOFLO331');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44437, 'FLOR559MARCE1');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44438, 'RAM559RO0GAM11');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44439, 'FATIGUT7712PZ');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44440, 'LUC669GUZ100');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44441, 'RODOL2219FOJI33');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44442, 'MIRE2294ESCO991');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44443, 'YEF7769FRYKAFK001');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44444, 'GIO4481LAZC0098');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44445, 'MAR00057LIMA1129');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44446, 'JUAN44927LOPZZ7V');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44447, 'ARI440218LUNZ01');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44448, 'RONA20987MAC00');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44449, 'MAR99361COMA09CADO');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44450, 'AME0854761MALDO001');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44451, 'ERI0085CKMI110');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44452, 'NATA0018LYMO10TO');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44453, 'ANA009187OL66VIO');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44454, 'IVET008HORE883');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44455, 'LU330PAVZ00');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44456, 'OSSCA0048PA88Z');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44457, 'JUA0038NPERE8828');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44458, 'WAS0017PEZ444');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44459, 'MARI00218PINT011');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44460, 'OSC0028POM4471');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44461, 'AN0038QUIN5576');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44462, 'ES00KA74QUIN77');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44463, 'JOS00238QUIG0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44464, 'LID8845IQUI00BEH');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44465, 'JUV0038QUIS001');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44466, 'TAN2058VILL10');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44467, 'OMA774IRE00LLO');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44468, 'CRIS90586GOO91');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44469, 'JUA00385RODRIII1');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44470, 'DFMNTGR81000001');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44471, 'JO9275RO00JA0S');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44472, 'EDM9957ZCH0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44473, 'MAR000SAN7546DI');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44474, 'LEI88475TA00PIA');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44475, 'CRIS8573TARI777FA');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44476, 'JAI5875763TICO0');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44477, 'VALFI69916TOZZQ');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44478, 'MARIU557TEEE2');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44479, 'STIVND723URUAR9');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44480, 'WWWICMLING8835');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44481, 'LUI677SAVAR002');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44482, 'IVAJV888376TTTY');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44483, 'JAVI0084VIL11');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44484, 'JDNFD6661CCC');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44485, 'CVJGMVB8881QQ');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44486, 'VVVIDNC6111');
INSERT IGNORE INTO docente(ci, cod_rfid) VALUES(44487, 'SERT999VJZAMO0');