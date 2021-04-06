package com.altiora.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.altiora.entidades.Orden;
import com.altiora.repositorios.ClienteRepositorio;
import com.altiora.repositorios.OrdenRepositorio;
import com.altiora.servicios.OrdenServicio;


@Service("ordenServicio")
public class OrdenServicioImpl implements OrdenServicio {

	@Autowired
	@Qualifier("ordenRepositorio")
	private OrdenRepositorio ordenRepositorio;
	
	@Autowired
	@Qualifier("clienteRepositorio")
	private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Orden> listar() {
		return ordenRepositorio.findAll();
	}
	
	@Override
	public Orden obtener(Integer ordenId) {
		return ordenRepositorio.findById(ordenId).get();
	}

	@Override
	public Orden guardar(Orden orden) {
		return ordenRepositorio.save(orden);
	}

	@Override
	public void eliminar(Integer ordenId) {
		ordenRepositorio.deleteById(ordenId);
	}

	
}
