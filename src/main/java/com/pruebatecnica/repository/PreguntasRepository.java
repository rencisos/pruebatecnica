package com.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.entity.Opciones;
import com.pruebatecnica.entity.Preguntas;



@Repository
public interface PreguntasRepository extends JpaRepository<Preguntas,Long>{

}
