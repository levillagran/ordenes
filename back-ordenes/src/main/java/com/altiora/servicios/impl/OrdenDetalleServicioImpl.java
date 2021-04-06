package com.altiora.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.altiora.entidades.OrdenDetalle;
import com.altiora.repositorios.OrdenDetalleRepositorio;
import com.altiora.servicios.OrdenDetalleServicio;


@Service("ordenDetalleServicio")
public class OrdenDetalleServicioImpl implements OrdenDetalleServicio {

	@Autowired
	@Qualifier("ordenDetalleRepositorio")
	private OrdenDetalleRepositorio ordenDetalleRepositorio;
	
	@Override
	public List<OrdenDetalle> listar() {
		return ordenDetalleRepositorio.findAll();
	}
	
	@Override
	public OrdenDetalle obtener(Integer ordenId) {
		return ordenDetalleRepositorio.findById(ordenId).get();
	}

	@Override
	public OrdenDetalle guardar(OrdenDetalle orden) {
		return ordenDetalleRepositorio.save(orden);
	}

	@Override
	public void eliminar(Integer ordenId) {
		ordenDetalleRepositorio.deleteById(ordenId);
	}

	
}
