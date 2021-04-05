package com.altiora.repositorios;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altiora.entidades.Orden;

@Repository("ordenRepositorio")
public interface OrdenRepositorio extends JpaRepository<Orden, Serializable>{
	
}
