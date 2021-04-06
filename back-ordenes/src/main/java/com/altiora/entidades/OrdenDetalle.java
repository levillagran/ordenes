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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordene_detalle")
public class OrdenDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "orden_detalle_id")
    private Integer orden_detalle_id;
    
    @JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Orden orden_id;
    
    @JoinColumn(name = "articulo_id", referencedColumnName = "articulo_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Articulo articulo_id;

	public Integer getOrden_detalle_id() {
		return orden_detalle_id;
	}

	public void setOrden_detalle_id(Integer orden_detalle_id) {
		this.orden_detalle_id = orden_detalle_id;
	}

	public Orden getOrden() {
		return orden_id;
	}

	public void setOrden(Orden orden_id) {
		this.orden_id = orden_id;
	}

	public Articulo getArticulo() {
		return articulo_id;
	}

	public void setArticulo(Articulo articulo_id) {
		this.articulo_id = articulo_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public OrdenDetalle(@NotNull Integer orden_detalle_id, Orden orden_id, Articulo articulo_id) {
		super();
		this.orden_detalle_id = orden_detalle_id;
		this.orden_id = orden_id;
		this.articulo_id = articulo_id;
	}

	public OrdenDetalle() {
		
	}
    
}
