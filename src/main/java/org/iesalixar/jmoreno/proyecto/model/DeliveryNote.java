package org.iesalixar.jmoreno.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery_note")
public class DeliveryNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	private String fecha;

	@Column(name = "descripcion")
	private String descripcion;

	public DeliveryNote() {
		super();
	}

	public DeliveryNote(String fecha, String descripcion) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public DeliveryNote(Long id, String fecha, String descripcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "DeliveryNote [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}

}
