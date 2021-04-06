package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.OrdenDetalle;

public interface OrdenDetalleServicio {
	public abstract List<OrdenDetalle> listar();
	public abstract OrdenDetalle obtener(Integer ordenId);
	public abstract OrdenDetalle guardar(OrdenDetalle orden);
	public abstract void eliminar(Integer ordenId);
}
