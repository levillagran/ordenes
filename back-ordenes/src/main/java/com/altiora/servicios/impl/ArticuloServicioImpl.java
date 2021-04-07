package com.altiora.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.altiora.entidades.Articulo;
import com.altiora.repositorios.ArticuloRepositorio;
import com.altiora.servicios.ArticuloServicio;


@Service("articuloServicio")
public class ArticuloServicioImpl implements ArticuloServicio {

	@Autowired
	@Qualifier("articuloRepositorio")
	private ArticuloRepositorio articuloRepositorio;

	@Override
	public List<Articulo> listar() {
		return articuloRepositorio.findAll();
	}
	
	@Override
	public Articulo obtener(Integer articuloId) {
		return articuloRepositorio.findById(articuloId).get();
	}

	@Override
	public Articulo guardar(Articulo articulo) {
		return articuloRepositorio.save(articulo);
	}

	@Override
	public void eliminar(Integer articuloId) {
		articuloRepositorio.deleteById(articuloId);
	}

	@Override
	public Articulo disStock(Integer articuloId,  int cantidad) {
		Articulo articulo = new Articulo();
		articulo = articuloRepositorio.findById(articuloId).get();
		
		if (articulo.getStock() > 0 && articulo.getStock() >cantidad) {
			articulo.setStock(articulo.getStock()-cantidad);
			return articuloRepositorio.save(articulo);
		} else {
			return null;
		}	
	}

	
}
