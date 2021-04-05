package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.Orden;

public interface OrdenServicio {
	public abstract List<Orden> listar();
	public abstract Orden obtener(Integer ordenId);
	public abstract void guardar(Orden orden);
	public abstract void eliminar(Orden orden);
}
