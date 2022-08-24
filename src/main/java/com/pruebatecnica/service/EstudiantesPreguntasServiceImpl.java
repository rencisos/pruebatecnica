package com.pruebatecnica.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.EstudiantesPreguntas;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
import com.pruebatecnica.repository.EstudiantesPreguntasRepository;
import com.pruebatecnica.repository.OpcionesRepository;
import com.pruebatecnica.repository.PreguntasRepository;



@Service
public class EstudiantesPreguntasServiceImpl implements  EstudiantesPreguntasService{

   @Autowired
   EstudiantesPreguntasRepository repository;
  
		
	   @Override
		public List<EstudiantesPreguntas> findAll() {
		   try {
			   List<EstudiantesPreguntas> opciones = new ArrayList<>();
			   opciones = repository.findAll();
			   
			   return opciones;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			}
		}
   
		@Override
		public EstudiantesPreguntas findPreguntasById(Long id){
			 try {
			
				EstudiantesPreguntas estudiantesPreguntas = new EstudiantesPreguntas();
			     estudiantesPreguntas = repository.findById(id).orElse(null);
			   
			   return estudiantesPreguntas;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			
		 }
	    }

		@Override
		public EstudiantesPreguntas save(EstudiantesPreguntas opciones) {
			try {
				  EstudiantesPreguntas estudiantesPreguntas = new EstudiantesPreguntas();
				  estudiantesPreguntas = repository.save(opciones);
				   
				   return estudiantesPreguntas;
		
			   } catch (Exception e) {
					throw new ServiceException("Error en la capa service",e);
				
			 }
		}


		
   
}
