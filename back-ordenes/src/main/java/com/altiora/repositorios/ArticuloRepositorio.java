package com.altiora.repositorios;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altiora.entidades.Articulo;

@Repository("articuloRepositorio")
public interface ArticuloRepositorio extends JpaRepository<Articulo, Serializable>{
	
	/*
	 * @Query("select a.stock from articulo a where a.id = :id ") public abstract
	 * int findStock(@Param("id") Integer id);
	 * 
	 * @Query("update a set a.stock=a.stock-cantidad from articulo a where a.id = :id "
	 * ) public abstract int disStock(@Param("contidad") int cantidad, @Param("id")
	 * Integer id);
	 */
}
