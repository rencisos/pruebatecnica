package com.pruebatecnica.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.entity.Estudiantes;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
import com.pruebatecnica.service.EstudiantesService;
import com.pruebatecnica.service.OpcionesService;
import com.pruebatecnica.service.PreguntasService;

@RestController
@RequestMapping(value="/pruebaTecnica")
@ComponentScan("com.pruebatecnica")
public class PruebaTecnicaController {

	@Autowired
	OpcionesService opcionesService;
	
	@Autowired
	PreguntasService preguntasService;
	
	@Autowired
	EstudiantesService estudiantesService;
	

	
	@PostMapping("/obtieneOpcionesPorIdPregunta")
	public ResponseEntity<List<Opciones>> obtieneOpcionesPorIdPregunta(@RequestBody Preguntas preguntas){
        String reponse = "";
        
        try {
        	List<Opciones> opciones = opcionesService.findByIdPregunta(preguntas);
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(opciones);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}
	
	@GetMapping("/obtieneOpciones")
	public ResponseEntity<List<Opciones>> obtieneOpciones(){
        String reponse = "";
        
        try {
        	List<Opciones> opciones = opcionesService.findAll();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(opciones);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}
	
	
	@GetMapping("/obtieneOpciones/{id}")
	public ResponseEntity<Opciones> obtieneOpcionesPorId(@PathVariable("id") Long id){
        String reponse = "";
        
        try {
        	Opciones opciones = opcionesService.findById(id);
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(opciones);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}

	
	    @PostMapping("/creaOpciones")
		public ResponseEntity<Opciones> creaOpciones(@RequestBody Opciones opcion){
	        String reponse = "";
	        
	        try {
	        	Opciones opciones = opcionesService.save(opcion);
		        ObjectMapper mapper = new ObjectMapper();
		        JsonNode jsonNodeResponse = mapper.readTree(reponse);
				return ResponseEntity.ok(opciones);

			} catch (Exception e) {
				throw new ServiceException("Error en la capa controller",e);
			}

		}
	 
	@GetMapping("/obtienePreguntas")
	public ResponseEntity<List<Preguntas>> obtienePreguntas(){
        String reponse = "";
        
        try {
        	List<Preguntas>  preguntas= preguntasService.findAll();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(preguntas);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}

	
	
	@GetMapping("/obtienePreguntas/{id}")
	public ResponseEntity<Preguntas> obtienePreguntasPorId(@PathVariable("id") Long id){
        String reponse = "";
        
        try {
        	Preguntas opciones = preguntasService.findPreguntasById(id);
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(opciones);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	 }
	
	
	 @PostMapping("/creaPregunta")
		public ResponseEntity<Preguntas> obtieneOpciones(@RequestBody Preguntas pregunta){
	        String reponse = "";
	        
	        try {
	        	Preguntas preguntas = preguntasService.save(pregunta);
		        ObjectMapper mapper = new ObjectMapper();
		        JsonNode jsonNodeResponse = mapper.readTree(reponse);
				return ResponseEntity.ok(preguntas);

			} catch (Exception e) {
				throw new ServiceException("Error en la capa controller",e);
			}

		}
		
	
	@GetMapping("/obtieneEstudiantes")
	public ResponseEntity<List<Estudiantes>> obtieneEstudiantes(){
        String reponse = "";
        
        try {
        	List<Estudiantes>  estudiantes= estudiantesService.findAll();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(estudiantes);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}

	
	@GetMapping("/obtieneEstudiantes/{id}")
	public ResponseEntity<Estudiantes> obtieneEstudiantesPorId(@PathVariable("id") Long id){
        String reponse = "";
        
        try {
        	Estudiantes estudiantes = estudiantesService.findEstudiantesById(id);
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode jsonNodeResponse = mapper.readTree(reponse);
			return ResponseEntity.ok(estudiantes);

		} catch (Exception e) {
			throw new ServiceException("Error en la capa controller",e);
		}

	}
	
	 @PostMapping("/creaEstudiante")
		public ResponseEntity<Estudiantes> creaEstudiante(@RequestBody Estudiantes estudiante){
	        String reponse = "";
	        
	        try {
	        	Estudiantes estudiantes = estudiantesService.save(estudiante);
		        ObjectMapper mapper = new ObjectMapper();
		        JsonNode jsonNodeResponse = mapper.readTree(reponse);
				return ResponseEntity.ok(estudiantes);

			} catch (Exception e) {
				throw new ServiceException("Error en la capa controller",e);
			}

		}
		
}
