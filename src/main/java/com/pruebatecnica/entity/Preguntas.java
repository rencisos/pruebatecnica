package com.pruebatecnica.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preguntas")
public class Preguntas implements Serializable{
 
	@Id
	@Column(name ="id_pregunta")
	private Long idPregunta;
	
	@Column(name ="descripcion")
	private String descripcion;

	
	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
