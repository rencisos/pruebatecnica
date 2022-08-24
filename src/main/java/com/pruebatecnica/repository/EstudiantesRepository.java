package com.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entity.Estudiantes;




@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiantes,Long>{

}
