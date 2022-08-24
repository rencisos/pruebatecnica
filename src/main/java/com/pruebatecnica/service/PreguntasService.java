package com.pruebatecnica.service;


import java.util.List;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;


@Repository
public interface PreguntasService{

	 List<Preguntas> findAll();
	
	 Preguntas findPreguntasById(Long id);
	 
}
