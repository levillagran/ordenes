package com.altiora.modelos;

import com.altiora.entidades.Articulo;

public class Stock {
	
	private Articulo articulo;
	private int cantidad;
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Stock(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public Stock() {
		super();
	}
	
	
}
