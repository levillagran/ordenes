package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.Articulo;

public interface ArticuloServicio {
	public abstract List<Articulo> listar();
	public abstract Articulo obtener(Integer articuloId);
	public abstract Articulo guardar(Articulo articulo);
	public abstract void eliminar(Integer articuloId);
	public abstract Articulo disStock(Integer articuloId, int cantidad);
}
