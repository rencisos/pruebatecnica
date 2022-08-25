package com.pruebatecnica.dto;

import java.util.List;

public class PreguntasDto {

	Long id;
	String descripcion;
	List<OpcionesDto> listaOpciones;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
