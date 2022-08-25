package com.pruebatecnica.dto;

import java.util.List;

public class CalificacionEstudianteDto {

	String nombre;
	String apellido;
	List<PreguntasDto> listaPreguntas;
	
	int calificacion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<PreguntasDto> getListaPreguntas() {
		return listaPreguntas;
	}
	public void setListaPreguntas(List<PreguntasDto> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
