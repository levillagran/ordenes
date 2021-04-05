package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.Cliente;

public interface ClienteServicio {
	public abstract List<Cliente> listar();
	public abstract Cliente obtener(Integer clienteId);
	public abstract void guardar(Cliente cliente);
	public abstract void eliminar(Cliente cliente);
}
