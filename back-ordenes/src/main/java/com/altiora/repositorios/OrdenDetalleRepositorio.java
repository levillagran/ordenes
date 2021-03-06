package com.altiora.repositorios;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altiora.entidades.OrdenDetalle;

@Repository("ordenDetalleRepositorio")
public interface OrdenDetalleRepositorio extends JpaRepository<OrdenDetalle, Serializable>{
	
}
