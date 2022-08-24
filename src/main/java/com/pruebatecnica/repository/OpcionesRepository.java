package com.pruebatecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;



@Repository
public interface OpcionesRepository extends JpaRepository<Opciones,Long>{

	 List<Opciones> findByIdPregunta(Preguntas preguntas);

	
}
