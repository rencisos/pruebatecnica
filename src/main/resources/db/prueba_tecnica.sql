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
  `respuesta` tinyint(1) DEFAULT NULL,
  `valor` int DEFAULT NULL,
  PRIMARY KEY (`id_opcion`),
  KEY `id_pregunta` (`id_pregunta`),
  CONSTRAINT `id_pregunta` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_pregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;