package com.altiora.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.entidades.Cliente;
import com.altiora.servicios.ClienteServicio;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteControlador {

	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServicio clienteServicio;

	@GetMapping("/listar")
	public List<Cliente> listar() {
		return clienteServicio.listar();
	}
}