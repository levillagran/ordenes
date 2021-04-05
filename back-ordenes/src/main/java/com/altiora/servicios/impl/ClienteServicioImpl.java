package com.altiora.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.altiora.entidades.Cliente;
import com.altiora.repositorios.ClienteRepositorio;
import com.altiora.servicios.ClienteServicio;


@Service("clienteServicio")
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	@Qualifier("clienteRepositorio")
	private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> listar() {
		return clienteRepositorio.findAll();
	}
	
	@Override
	public Cliente obtener(Integer clienteId) {
		return clienteRepositorio.findById(clienteId).get();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public void eliminar(Integer clienteId) {
		clienteRepositorio.deleteById(clienteId);
	}

	
}
