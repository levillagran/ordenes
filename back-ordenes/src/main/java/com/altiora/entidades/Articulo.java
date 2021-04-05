package com.altiora.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "articulo_id")
	private Integer articulo_id;

	@Size(max = 50)
	@Column(name = "codigo")
	private String codigo;
	
	@Size(max = 50)
	@Column(name = "nombre")
	private String nombre;

	@Size(max = 50)
	@Column(name = "precio")
	private String precio;

	@JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    @ManyToOne
    @JsonIgnore
    private Orden orden;
	
	public Integer getArticulo_id() {
		return articulo_id;
	}

	public void setArticulo_id(Integer articulo_id) {
		this.articulo_id = articulo_id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Articulo(@NotNull Integer articulo_id, @Size(max = 50) String codigo, @Size(max = 50) String nombre,
			@Size(max = 50) String precio, Orden orden) {
		super();
		this.articulo_id = articulo_id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.orden = orden;
	}
public Articulo() {
	}
	
}

	