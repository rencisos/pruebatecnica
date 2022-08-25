CREATE DATABASE `prueba_tecnica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- prueba_tecnica.estudiantes definition

CREATE TABLE `estudiantes` (
  `id_estudiante` bigint NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `zona_horaria` datetime NOT NULL,
  PRIMARY KEY (`id_estudiante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- prueba_tecnica.preguntas definition

CREATE TABLE `preguntas` (
  `id_pregunta` bigint NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_pregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- prueba_tecnica.estudiantes_preguntas definition

CREATE TABLE `estudiantes_preguntas` (
  `id_estudiante_pregunta` bigint NOT NULL,
  `id_estudiante` bigint NOT NULL,
  `id_pregunta` bigint NOT NULL,
  `valor` int DEFAULT NULL,
  PRIMARY KEY (`id_estudiante_pregunta`),
  KEY `id_estudiante_pregunta` (`id_estudiante_pregunta`),
  KEY `id_preguntaFK` (`id_pregunta`),
  KEY `id_estudianteFK` (`id_estudiante`),
  CONSTRAINT `id_preguntaFK` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_pregunta`),
  CONSTRAINT `iid_estudianteFK` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id_estudiante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- prueba_tecnica.opciones definition

CREATE TABLE `opciones` (
  `id_opcion` bigint NOT NULL,
  `id_pregunta` bigint NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `respuesta` bit(1) DEFAULT NULL,
  `valor` int DEFAULT NULL,
  PRIMARY KEY (`id_opcion`),
  KEY `id_pregunta` (`id_pregunta`),
  CONSTRAINT `id_pregunta` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_pregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO prueba_tecnica.estudiantes (id_estudiante,nombre,apellido,edad,ciudad,zona_horaria) VALUES
	 (1,'Ricardo','Enciso',26,'BOGOTA','2022-08-23 19:38:50'),
	 (2,'Estuiante','2',23,'BOGOTA','2022-08-24 14:45:15'),
	 (3,'Predro','Perez',24,'BOGOTA','2022-08-24 00:00:00');


INSERT INTO prueba_tecnica.estudiantes_preguntas (id_estudiante_pregunta,id_estudiante,id_pregunta,valor) VALUES
	 (1,3,1,50),
	 (2,3,1,50);




INSERT INTO prueba_tecnica.preguntas (id_pregunta,descripcion) VALUES
	 (1,'Pregunta 1'),
	 (2,'Pregunta 2'),
	 (3,'Pregunta 3'),
	 (4,'Pregunta 4'),
	 (5,'Pregunta 5'),
	 (6,'Pregunta 6');







INSERT INTO prueba_tecnica.opciones (id_opcion,id_pregunta,descripcion,respuesta,valor) VALUES
	 (1,1,'A. Respuesta 1',1,50),
	 (2,1,'B. Respuesta 2',0,0),
	 (3,1,'C. Respuesta 3',0,0),
	 (4,1,'D. Respuesta 4',0,0),
	 (5,2,'A. Respuesta 1',0,0),
	 (6,2,'B. Respuesta 2',1,50),
	 (7,2,'C. Respuesta 3',0,0),
	 (8,2,'D. Respuesta 4',0,0),
	 (9,3,'A. Respuesta 1',0,0),
	 (10,3,'B. Respuesta 2',0,0);
INSERT INTO prueba_tecnica.opciones (id_opcion,id_pregunta,descripcion,respuesta,valor) VALUES
	 (11,3,'C. Respuesta 3',1,25),
	 (12,3,'D. Respuesta 4',0,0),
	 (13,4,'A. Respuesta 1',0,0),
	 (14,4,'B. Respuesta 2',0,0),
	 (15,4,'C. Respuesta 3',0,0),
	 (16,4,'D. Respuesta 4',1,25),
	 (17,5,'A. Pregunta 1',1,25);

