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
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer cliente_id;

	@Size(max = 50)
	@Column(name = "nombre")
	private String nombre;

	@Size(max = 50)
	@Column(name = "apellido")
	private String apellido;
	
	@JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    @ManyToOne
    @JsonIgnore
    private Orden orden;
	
	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Cliente(@NotNull Integer cliente_id, @Size(max = 50) String nombre, @Size(max = 50) String apellido,
			Orden orden) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.orden = orden;
	}

	public Cliente() {
	}
	
}

	