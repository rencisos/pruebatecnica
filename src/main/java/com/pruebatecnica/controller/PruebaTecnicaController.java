package com.pruebatecnica.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;
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
	
	@PostMapping("/sayHi")
	public String sayHi() {
		
		return "Hi!!!";
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
}
