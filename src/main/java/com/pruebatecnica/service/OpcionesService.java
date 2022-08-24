package com.pruebatecnica.service;


import java.util.List;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;


@Repository
public interface OpcionesService{

	 List<Opciones> findAll();
   
	 Opciones findById(Long id);
	 
	 Opciones save(Opciones opciones);

	 List<Opciones> findByIdPregunta(Preguntas preguntas);
	 
	 
}
