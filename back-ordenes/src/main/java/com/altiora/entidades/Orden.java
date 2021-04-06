package com.altiora.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ordenes")
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "orden_id")
    private Integer orden_id;
    
    @Size(max = 30)
    @Column(name = "fecha")
    private Date fecha;
    
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente cliente_id;
    
    @OneToMany(mappedBy = "orden_id", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<OrdenDetalle> ordenDetalleList;
        
	public Integer getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(Integer orden_id) {
		this.orden_id = orden_id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente_id;
	}

	public void setCliente(Cliente cliente_id) {
		this.cliente_id = cliente_id;
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

	public Orden(@NotNull Integer orden_id, @Size(max = 30) Date fecha, Cliente cliente_id,
			List<OrdenDetalle> ordenDetalleList) {
		super();
		this.orden_id = orden_id;
		this.fecha = fecha;
		this.cliente_id = cliente_id;
		this.ordenDetalleList = ordenDetalleList;
	}

	public Orden(@NotNull Integer orden_id, @Size(max = 30) Date fecha, Cliente cliente_id) {
		super();
		this.orden_id = orden_id;
		this.fecha = fecha;
		this.cliente_id = cliente_id;
	}

	public Orden() {
		
	}
    
}
