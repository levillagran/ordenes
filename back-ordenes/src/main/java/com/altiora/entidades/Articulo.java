package com.altiora.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name = "precio_unitario")
	private String precio_unitario;
	
	@OneToMany(mappedBy = "articulo_id", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<OrdenDetalle> ordenDetalleList;
	
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

	public String getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(String precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public List<OrdenDetalle> getOrdenDetalleList() {
		return ordenDetalleList;
	}

	public void setOrdenDetalleList(List<OrdenDetalle> ordenDetalleList) {
		this.ordenDetalleList = ordenDetalleList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Articulo(@NotNull Integer articulo_id, @Size(max = 50) String codigo, @Size(max = 50) String nombre,
			@Size(max = 50) String precio_unitario, List<OrdenDetalle> ordenDetalleList) {
		super();
		this.articulo_id = articulo_id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio_unitario = precio_unitario;
		this.ordenDetalleList = ordenDetalleList;
	}

	public Articulo(@NotNull Integer articulo_id, @Size(max = 50) String codigo, @Size(max = 50) String nombre,
			@Size(max = 50) String precio_unitario) {
		super();
		this.articulo_id = articulo_id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio_unitario = precio_unitario;
	}

	public Articulo() {
	}
	
}

	