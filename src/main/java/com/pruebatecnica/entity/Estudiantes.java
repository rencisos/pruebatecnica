package com.pruebatecnica.entity;

import java.time.LocalDate;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiantes {
 
	@Id
	@Column(name ="id_estudiante")
	private Long idEstudiante;
	
	@Column(name ="nombre")
	private String nombre;
	
	@Column(name ="apellido")
	private String apellido;
	
	@Column(name ="edad")
	private String edad;
	
	@Column(name ="ciudad")
	private String ciudad;
	
	@Column(name ="zona_horaria")
	private TimeZone zonaHoraria;
	//private LocalDate zonaHoraria;

	

	public Long getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public TimeZone  getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(TimeZone  zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	

	
}
