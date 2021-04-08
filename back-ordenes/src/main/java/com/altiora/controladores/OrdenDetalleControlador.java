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

import com.altiora.entidades.OrdenDetalle;
import com.altiora.servicios.OrdenDetalleServicio;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/ordenDetalle")
public class OrdenDetalleControlador {

	@Autowired
	@Qualifier("ordenDetalleServicio")
	private OrdenDetalleServicio ordenDetalleServicio;

	@GetMapping("/listar")
	public List<OrdenDetalle> listar() {
		return ordenDetalleServicio.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public OrdenDetalle obtener(@PathVariable Integer id) {
		return ordenDetalleServicio.obtener(id);
	}
	
	@PostMapping("/guardar")
	public OrdenDetalle nuevoCliente(@RequestBody OrdenDetalle orden) {
	    return ordenDetalleServicio.guardar(orden);
	}
	
	@PutMapping("/actualizar")
	public OrdenDetalle actualizar(@RequestBody OrdenDetalle orden) {
		return ordenDetalleServicio.guardar(orden);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		ordenDetalleServicio.eliminar(id);
	  }
	}