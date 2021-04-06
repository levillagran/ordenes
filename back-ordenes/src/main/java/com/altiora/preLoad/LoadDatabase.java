package com.altiora.preLoad;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.altiora.entidades.Articulo;
import com.altiora.entidades.Cliente;
import com.altiora.entidades.Orden;
import com.altiora.entidades.OrdenDetalle;
import com.altiora.repositorios.ArticuloRepositorio;
import com.altiora.repositorios.ClienteRepositorio;
import com.altiora.repositorios.OrdenDetalleRepositorio;
import com.altiora.repositorios.OrdenRepositorio;

@Configuration
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(ClienteRepositorio clienteRepositorio, ArticuloRepositorio articuloRepositorio,
			OrdenRepositorio ordenRepositorio, OrdenDetalleRepositorio ordenDetalleRepositorio) {
		return args -> {
			// clientes
			clienteRepositorio.save(new Cliente(1,"lenin", "villagran"));
			clienteRepositorio.save(new Cliente(2,"ernesto", "pancho"));
			clienteRepositorio.save(new Cliente(3,"walter", "chavez"));
			
			// articulos
			articuloRepositorio.save(new Articulo(1, "001", "lapiz", "0,25"));
			articuloRepositorio.save(new Articulo(2, "002", "esfero", "0,50"));
			articuloRepositorio.save(new Articulo(3, "003", "cuader", "2,25"));
			
			// orden
			ordenRepositorio.save(new Orden(1, new Date(), clienteRepositorio.findById(1).get()));
			ordenRepositorio.save(new Orden(2, new Date(), clienteRepositorio.findById(2).get()));
			
			// orden detalle
			ordenDetalleRepositorio.save(new OrdenDetalle(1, ordenRepositorio.findById(1).get(), articuloRepositorio.findById(1).get()));
			ordenDetalleRepositorio.save(new OrdenDetalle(2, ordenRepositorio.findById(1).get(), articuloRepositorio.findById(2).get()));
			ordenDetalleRepositorio.save(new OrdenDetalle(3, ordenRepositorio.findById(1).get(), articuloRepositorio.findById(3).get()));
			ordenDetalleRepositorio.save(new OrdenDetalle(4, ordenRepositorio.findById(2).get(), articuloRepositorio.findById(1).get()));
			ordenDetalleRepositorio.save(new OrdenDetalle(5, ordenRepositorio.findById(2).get(), articuloRepositorio.findById(2).get()));
			ordenDetalleRepositorio.save(new OrdenDetalle(6, ordenRepositorio.findById(2).get(), articuloRepositorio.findById(3).get()));
			
		};
	}
}



