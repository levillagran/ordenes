package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.Orden;

public interface OrdenServicio {
	public abstract List<Orden> listar();
	public abstract Orden obtener(Integer ordenId);
	public abstract Orden guardar(Orden orden);
	public abstract void eliminar(Integer ordenId);
}
