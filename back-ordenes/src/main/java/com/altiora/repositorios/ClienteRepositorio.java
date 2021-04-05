package com.altiora.repositorios;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altiora.entidades.Cliente;

@Repository("clienteRepositorio")
public interface ClienteRepositorio extends JpaRepository<Cliente, Serializable>{
	
}
