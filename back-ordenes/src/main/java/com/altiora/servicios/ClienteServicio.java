package com.altiora.servicios;

import java.util.List;

import com.altiora.entidades.Cliente;

public interface ClienteServicio {
	public abstract List<Cliente> listar();
	public abstract Cliente obtener(Integer clienteId);
	public abstract Cliente guardar(Cliente cliente);
	public abstract void eliminar(Integer clienteId);
}
