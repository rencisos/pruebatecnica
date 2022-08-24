package com.pruebatecnica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes_preguntas")
public class EstudiantesPreguntas {
 
	@Id
	@Column(name ="id_estudiante_pregunta")
	private Long idEstudiantePregunta;
	
	@ManyToOne
	@JoinColumn(name="id_estudiante")
	private Estudiantes idEstudiante;

	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Preguntas idPregunta;

	public Long getIdEstudiantePregunta() {
		return idEstudiantePregunta;
	}

	public void setIdEstudiantePregunta(Long idEstudiantePregunta) {
		this.idEstudiantePregunta = idEstudiantePregunta;
	}

	public Estudiantes getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiantes idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Preguntas getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Preguntas idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	

	
}
