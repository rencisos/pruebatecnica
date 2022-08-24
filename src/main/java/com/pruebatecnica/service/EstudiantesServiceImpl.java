package com.pruebatecnica.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pruebatecnica.entity.Estudiantes;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
import com.pruebatecnica.repository.EstudiantesRepository;
import com.pruebatecnica.repository.OpcionesRepository;



@Service
public class EstudiantesServiceImpl implements  EstudiantesService{

   @Autowired
   EstudiantesRepository repository;
  
   @Override
	public List<Estudiantes> findAll() {
		 try {
			   List<Estudiantes> estudiantes = new ArrayList<>();
			   estudiantes = repository.findAll();
			   
			   return estudiantes;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			}
	    }

		@Override
		public Estudiantes findEstudiantesById(Long id) {
			 try {
				 Estudiantes estudiantes = new Estudiantes();
				 estudiantes = repository.findById(id).orElse(null);
			   
			   return estudiantes;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			
		 }
	    }
		
		
   
}
