package com.pruebatecnica.service;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entity.Estudiantes;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;


@Repository
public interface EstudiantesService{

	 List<Estudiantes> findAll();
   
	 Estudiantes findEstudiantesById(Long id);
	 
	 Estudiantes save(Estudiantes opciones);

	 
}
