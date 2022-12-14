package com.pruebatecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entity.Estudiantes;
import com.pruebatecnica.entity.EstudiantesPreguntas;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;



@Repository
public interface EstudiantesPreguntasRepository extends JpaRepository<EstudiantesPreguntas,Long>{

	
	 List<EstudiantesPreguntas> findByIdEstudiante(EstudiantesPreguntas estudiantesPregunta);
	
}
