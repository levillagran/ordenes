package com.altiora.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ordenes")
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Integer orden_id;
    
    @Size(max = 50)
	@Column(name = "codigo")
	private String codigo;
    
    @Size(max = 30)
    @Column(name = "fecha")
    private Date fecha;
    
    @OneToMany(mappedBy = "articulo_id")
	private List<Articulo> articuloList;
    
    @OneToMany(mappedBy = "cliente_id")
    private List<Cliente> clienteList;
	
	public Integer getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Integer orden_id) {
		this.orden_id = orden_id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Articulo> getArticuloList() {
		return articuloList;
	}

	public void setArticuloList(List<Articulo> articuloList) {
		this.articuloList = articuloList;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Orden(@NotNull Integer orden_id, @Size(max = 50) String codigo, @Size(max = 30) Date fecha,
			List<Articulo> articuloList, List<Cliente> clienteList) {
		super();
		this.orden_id = orden_id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.articuloList = articuloList;
		this.clienteList = clienteList;
	}

	public Orden(@NotNull Integer orden_id, @Size(max = 50) String codigo, @Size(max = 30) Date fecha) {
		super();
		this.orden_id = orden_id;
		this.codigo = codigo;
		this.fecha = fecha;
	}

	public Orden() {
		
	}
    
}
