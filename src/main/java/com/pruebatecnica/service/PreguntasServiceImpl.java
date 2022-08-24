package com.pruebatecnica.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
import com.pruebatecnica.repository.OpcionesRepository;
import com.pruebatecnica.repository.PreguntasRepository;



@Service
public class PreguntasServiceImpl implements  PreguntasService{

   @Autowired
   PreguntasRepository repository;
  
		
	   @Override
		public List<Preguntas> findAll() {
		   try {
			   List<Preguntas> opciones = new ArrayList<>();
			   opciones = repository.findAll();
			   
			   return opciones;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			}
		}
   
		@Override
		public Preguntas findPreguntasById(Long id){
			 try {
			   Preguntas preguntas = new Preguntas();
			   preguntas = repository.findById(id).orElse(null);
			   
			   return preguntas;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			
		 }
	    }

		@Override
		public Preguntas save(Preguntas opciones) {
			try {
				   Preguntas preguntas = new Preguntas();
				   preguntas = repository.save(opciones);
				   
				   return preguntas;
		
			   } catch (Exception e) {
					throw new ServiceException("Error en la capa service",e);
				
			 }
		}


		
   
}
