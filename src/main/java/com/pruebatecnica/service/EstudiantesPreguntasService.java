package com.pruebatecnica.service;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.dto.CalificacionEstudianteDto;
import com.pruebatecnica.entity.EstudiantesPreguntas;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;


@Repository
public interface EstudiantesPreguntasService{

	 List<EstudiantesPreguntas> findAll();
	
	 EstudiantesPreguntas findPreguntasById(Long id);
	 
	 EstudiantesPreguntas save(EstudiantesPreguntas opciones);
	 
	 CalificacionEstudianteDto obtieneCalificaciones(Long id);
	 
	 EstudiantesPreguntas Update(EstudiantesPreguntas opciones);

	 
}
