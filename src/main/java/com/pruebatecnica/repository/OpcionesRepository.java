package com.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pruebatecnica.entity.Opciones;



@Repository
public interface OpcionesRepository extends JpaRepository<Opciones,Long>{

}
