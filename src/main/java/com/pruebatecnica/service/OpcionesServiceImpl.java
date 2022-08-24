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



@Service
public class OpcionesServiceImpl implements  OpcionesService{

   @Autowired
   OpcionesRepository repository;
  
   @Override
	public List<Opciones> findAll() {
		 try {
			   List<Opciones> opciones = new ArrayList<>();
			   opciones = repository.findAll();
			   
			   return opciones;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa controller",e);
			}
	    }

		@Override
		public Opciones findById(Long id) {
			 try {
			   Opciones opciones = new Opciones();
			   opciones = repository.findById(id).orElse(null);
			   
			   return opciones;
	
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa controller",e);
			
		 }
	    }
		
		
   
}
