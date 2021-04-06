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
	
	@OneToMany(mappedBy = "cliente_id", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Orden> ordenList;
		
	public Integer getClienteId() {
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

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente(@NotNull Integer cliente_id, @Size(max = 50) String nombre, @Size(max = 50) String apellido,
			List<Orden> ordenList) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ordenList = ordenList;
	}

	public Cliente(@NotNull Integer cliente_id, @Size(max = 50) String nombre, @Size(max = 50) String apellido) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Cliente() {
	}
	
}

	