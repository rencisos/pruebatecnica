package com.pruebatecnica.dto;

import java.util.List;

public class EstudiantesPreguntasDto {
 
	
	private Long idPreguntas;

	private String descripcion;
	
	private List<OpcionesDto> listaOpciones;

	public Long getIdPreguntas() {
		return idPreguntas;
	}

	public void setIdPreguntas(Long idPreguntas) {
		this.idPreguntas = idPreguntas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<OpcionesDto> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(List<OpcionesDto> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}
	

	
}
