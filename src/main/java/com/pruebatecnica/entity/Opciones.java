package com.pruebatecnica.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opciones {
 
	@Id
	@Column(name ="id_opcion")
	private Long id_opcion;
	
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Preguntas id_pregunta;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Column(name ="respuesta")
	private String respuesta;
	
	@Column(name ="valor")
	private String valor;

	public Long getId_opcion() {
		return id_opcion;
	}

	public void setId_opcion(Long id_opcion) {
		this.id_opcion = id_opcion;
	}

	public Preguntas getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Preguntas id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
