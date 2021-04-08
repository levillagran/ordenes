package com.altiora.modelos;

public class Stock {
	
	private int articuloId;
	private int cantidad;
	
	public int getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Stock(int articuloId, int cantidad) {
		super();
		this.articuloId = articuloId;
		this.cantidad = cantidad;
	}

	public Stock() {
		super();
	}
	
	
}
