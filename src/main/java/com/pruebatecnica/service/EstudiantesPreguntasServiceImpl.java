package com.pruebatecnica.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dto.CalificacionEstudianteDto;
import com.pruebatecnica.dto.PreguntasDto;
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
   
   @Autowired
   OpcionesService opcionesService;
		
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

		@Override
		public CalificacionEstudianteDto obtieneCalificaciones(Long id) {
			 try {
				   EstudiantesPreguntas opciones = new EstudiantesPreguntas();
				   opciones = repository.findById(id).orElse(null);
				  
				   
				   List<Opciones> listaOpciones =opcionesService.findByIdPregunta(opciones.getIdPregunta());
				   
				   int valorCal= 0;
				   CalificacionEstudianteDto calificacionEstudianteDto = new CalificacionEstudianteDto();
				   calificacionEstudianteDto.setNombre(opciones.getIdEstudiante().getNombre());
				   calificacionEstudianteDto.setApellido(opciones.getIdEstudiante().getApellido());
				   
				   
				   PreguntasDto  preguntasDto = new PreguntasDto();
				   preguntasDto.setId(opciones.getIdPregunta().getIdPregunta());
				   preguntasDto.setDescripcion(opciones.getIdPregunta().getDescripcion());

				   List<PreguntasDto>  listaPreguntasDto = new ArrayList<PreguntasDto>();
				   listaPreguntasDto.add(preguntasDto);
				   
				   calificacionEstudianteDto.setListaPreguntas(listaPreguntasDto);
				   
				   for (Opciones op:listaOpciones) {
					   valorCal = valorCal + op.getValor();
				   }
				   
				   calificacionEstudianteDto.setCalificacion(valorCal);
				   
				   return calificacionEstudianteDto;
		
			   } catch (Exception e) {
					throw new ServiceException("Error en la capa service",e);
				}
		}

		@Override
		public EstudiantesPreguntas Update(EstudiantesPreguntas opciones) {
			 try {
				 
				 
				 List<Opciones> listaOpciones =opcionesService.findByIdPregunta(opciones.getIdPregunta());

				 for (Opciones opc:listaOpciones) {
					 if(opc.getIdPregunta().getIdPregunta()==opciones.getIdPregunta().getIdPregunta()
							 && opc.getValor()>0){
						 if (repository.existsById(opciones.getIdEstudiantePregunta())) {
								return repository.save(opciones);
						 }
					 }
				 }
				 
				
				
		   } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			}
				
			 return null;
		}


		
   
}
