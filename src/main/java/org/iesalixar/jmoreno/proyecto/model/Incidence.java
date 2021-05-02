package org.iesalixar.jmoreno.proyecto.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "incidence")
public class Incidence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String fecha;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User users;

	
	
	public Incidence() {
		super();
	}

	

	public Incidence(String fecha, String descripcion, String estado, User users) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;
		this.users = users;
	}



	public Incidence(Long id, String fecha, String descripcion, String estado, User users) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.estado = estado;
		this.users = users;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Incidence [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", users=" + users + "]";
	}
	
	
	

}
