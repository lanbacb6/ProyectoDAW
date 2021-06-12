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
@Table(name = "invoices")
public class Invoices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	private String fecha;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio_total")
	private float precio;

	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Clients clients;

	public Invoices() {
		super();
	}

	public Invoices(String fecha, String descripcion, float precio, Clients clients) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
		this.clients = clients;
	}

	public Invoices(Long id, String fecha, String descripcion, float precio, Clients clients) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
		this.clients = clients;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Invoices [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", clients=" + clients + "]";
	}

}
