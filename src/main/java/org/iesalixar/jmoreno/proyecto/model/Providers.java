package org.iesalixar.jmoreno.proyecto.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "providers")
public class Providers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CIF")
	private String cif;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private Integer telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "Codigo_Postal")
	private Integer codigoPostal;

	@OneToMany(mappedBy = "providers")
	private Set<Orders> orders;

	public Providers() {
		super();
	}

	public Providers(String cif, String nombre, Integer telefono, String direccion, String provincia,
			Integer codigoPostal, Set<Orders> orders) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.orders = orders;
	}

	public Providers(Long id, String cif, String nombre, Integer telefono, String direccion, String provincia,
			Integer codigoPostal, Set<Orders> orders) {
		super();
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Providers [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", orders=" + orders
				+ "]";
	}

}
