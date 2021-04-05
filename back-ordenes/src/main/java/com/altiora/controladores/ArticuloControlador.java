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

import com.altiora.entidades.Articulo;
import com.altiora.servicios.ArticuloServicio;

@RestController
@RequestMapping(path = "/articulo")
public class ArticuloControlador {

	@Autowired
	@Qualifier("articuloServicio")
	private ArticuloServicio articuloServicio;

	@GetMapping("/listar")
	public List<Articulo> listar() {
		return articuloServicio.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Articulo obtener(@PathVariable Integer id) {
		return articuloServicio.obtener(id);
	}
	
	@PostMapping("/guardar")
	public Articulo nuevoCliente(@RequestBody Articulo articulo) {
	    return articuloServicio.guardar(articulo);
	}
	
	@PutMapping("/actualizar")
	public Articulo actualizar(@RequestBody Articulo articulo) {
		return articuloServicio.guardar(articulo);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		articuloServicio.eliminar(id);
	  }
	}