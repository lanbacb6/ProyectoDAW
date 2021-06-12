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
@Table(name = "clients")
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "telefono")
	private Integer telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "codigo_postal")
	private Integer codigoPostal;

	@Column(name = "nombre_completo")
	private String nombreCompleto;

	@OneToMany(mappedBy = "clients")
	private Set<Invoices> invoices;

	public Clients() {
		super();
	}

	public Clients(String nombre, String apellidos, Integer telefono, String direccion, Integer codigoPostal,
			String nombreCompleto, Set<Invoices> invoices) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.nombreCompleto = nombreCompleto;
		this.invoices = invoices;
	}

	public Clients(Long id, String nombre, String apellidos, Integer telefono, String direccion, Integer codigoPostal,
			String nombreCompleto, Set<Invoices> invoices) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.nombreCompleto = nombreCompleto;
		this.invoices = invoices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Set<Invoices> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoices> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", nombreCompleto=" + nombreCompleto
				+ ", invoices=" + invoices + "]";
	}

}
