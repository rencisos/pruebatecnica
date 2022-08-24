package com.pruebatecnica.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Preguntas {
 
	@Id
	@Column(name ="id_pregunta")
	private Long id_pregunta;
	
	@Column(name ="descripcion")
	private String descripcion;

	public Long getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Long id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
