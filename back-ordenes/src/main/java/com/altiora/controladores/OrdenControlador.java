package com.altiora.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiora.entidades.Orden;
import com.altiora.servicios.OrdenServicio;

@RestController
@RequestMapping(path = "/orden")
public class OrdenControlador {

	@Autowired
	@Qualifier("ordenServicio")
	private OrdenServicio ordenServicio;

	@GetMapping("/listar")
	public List<Orden> listar() {
		return ordenServicio.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Orden obtener(@PathVariable Integer id) {
		return ordenServicio.obtener(id);
	}
	
	@PostMapping("/guardar")
	public Orden nuevoCliente(@RequestBody Orden orden) {
	    return ordenServicio.guardar(orden);
	}
	
	@PutMapping("/actualizar")
	public Orden actualizar(@RequestBody Orden orden) {
		return ordenServicio.guardar(orden);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		ordenServicio.eliminar(id);
	  }
	}