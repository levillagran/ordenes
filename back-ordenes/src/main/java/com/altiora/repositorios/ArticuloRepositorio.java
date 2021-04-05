package com.altiora.repositorios;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altiora.entidades.Articulo;

@Repository("articuloRepositorio")
public interface ArticuloRepositorio extends JpaRepository<Articulo, Serializable>{
	
}
