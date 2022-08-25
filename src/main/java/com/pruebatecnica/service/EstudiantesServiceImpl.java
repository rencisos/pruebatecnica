package com.pruebatecnica.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dto.CalificacionEstudianteDto;
import com.pruebatecnica.dto.EstudiantesPreguntasDto;
import com.pruebatecnica.dto.OpcionesDto;
import com.pruebatecnica.dto.PreguntasDto;
import com.pruebatecnica.entity.Estudiantes;
import com.pruebatecnica.entity.EstudiantesPreguntas;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
import com.pruebatecnica.repository.EstudiantesPreguntasRepository;
import com.pruebatecnica.repository.EstudiantesRepository;
import com.pruebatecnica.repository.OpcionesRepository;



@Service
public class EstudiantesServiceImpl implements  EstudiantesService{

   @Autowired
   EstudiantesRepository repository;
   
   @Autowired
   EstudiantesPreguntasRepository repositoryEstudiantesPreguntasRepository;
   
   @Autowired
   OpcionesRepository opcionesRepository;
   
   
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
		
		
		@Override
		public Estudiantes save(Estudiantes estudiante) {
			try {
				
				Estudiantes estudiantes = new Estudiantes();
				estudiantes = repository.save(estudiante);
				   
				   return estudiantes;
		
			   } catch (Exception e) {
					throw new ServiceException("Error en la capa service",e);
				
			 }
		}

		@Override
		public CalificacionEstudianteDto obtieneExamenAsignado(Long id ) {
			CalificacionEstudianteDto listaCalificacionEstudianteDto = new CalificacionEstudianteDto();
			
			try {
				
				List<EstudiantesPreguntas> estudiantesPreguntas = new ArrayList<EstudiantesPreguntas>();
			    estudiantesPreguntas = repositoryEstudiantesPreguntasRepository.findAll();
			    
			    List<Opciones> listaOpciones = new ArrayList<>();
			    listaOpciones = opcionesRepository.findAll();
			    
	    		List<PreguntasDto> listaPreguntasDto = new ArrayList<PreguntasDto>();
	    		int calificacion =0;
	    		
			    for(EstudiantesPreguntas estud:estudiantesPreguntas) {
			    	
			    	if (estud.getIdEstudiante().getIdEstudiante()==id) {
			    		
			    		PreguntasDto preguntasDto = new PreguntasDto();
			    		
			    		preguntasDto.setDescripcion(estud.getIdPregunta().getDescripcion());
			    		preguntasDto.setId(estud.getIdPregunta().getIdPregunta());
						calificacion = calificacion + estud.getValor();

			    		List<OpcionesDto> listaOpcionesDto = new ArrayList<OpcionesDto>();

			    		for(Opciones opci:listaOpciones) {
			    			
			    			    OpcionesDto opciones = new OpcionesDto();
			    			    
								if (opci.getIdPregunta().getIdPregunta()== preguntasDto.getId()) {
									
									opciones.setIdOpcion(opci.getIdOpcion());
									opciones.setDescripcion(opci.getDescripcion());
									opciones.setValor(opci.getValor());
									opciones.setRespuesta(opci.getRespuesta());
									
									listaOpcionesDto.add(opciones);
								}	
						}
			    		
						preguntasDto.setListaOpciones(listaOpcionesDto);

			    		listaPreguntasDto.add(preguntasDto);
			    		
			    	}
			    }
			    
			    
			    listaCalificacionEstudianteDto.setListaPreguntas(listaPreguntasDto);


			    
			    Estudiantes estudiantes = new Estudiantes();
				estudiantes = repository.findById(id).orElse(null);
			   
				listaCalificacionEstudianteDto.setNombre(estudiantes.getNombre());
				listaCalificacionEstudianteDto.setApellido(estudiantes.getApellido());
				listaCalificacionEstudianteDto.setCalificacion(calificacion);
				
			   return listaCalificacionEstudianteDto;
	
		    } catch (Exception e) {
				throw new ServiceException("Error en la capa service",e);
			
		   }
		}
}
