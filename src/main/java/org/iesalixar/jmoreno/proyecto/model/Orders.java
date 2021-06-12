package org.iesalixar.jmoreno.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	private String fecha;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private Double precio;

	@ManyToOne
	@JoinColumn(name = "providers_id", nullable = false)
	private Providers providers;

	public Orders() {
		super();
	}

	public Orders(String fecha, String descripcion, Double precio, Providers providers) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
		this.providers = providers;
	}

	public Orders(Long id, String fecha, String descripcion, Double precio, Providers providers) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
		this.providers = providers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Providers getProviders() {
		return providers;
	}

	public void setProviders(Providers providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", providers=" + providers + "]";
	}

}
