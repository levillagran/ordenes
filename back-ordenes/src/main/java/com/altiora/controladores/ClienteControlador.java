package com.altiora.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.entidades.Cliente;
import com.altiora.servicios.ClienteServicio;

@CrossOrigin(origins = "http://localhost:3000")
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
	
	@GetMapping("/obtener/{id}")
	public Cliente obtener(@PathVariable Integer id) {
		return clienteServicio.obtener(id);
	}
	
	@PostMapping("/guardar")
	public Cliente nuevoCliente(@RequestBody Cliente cliente) {
	    return clienteServicio.guardar(cliente);
	}
	
	@PutMapping("/actualizar")
	public Cliente actualizar(@RequestBody Cliente cliente) {
		return clienteServicio.guardar(cliente);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		clienteServicio.eliminar(id);
	  }
	}