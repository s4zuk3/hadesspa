package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT a FROM Cliente a")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente", unique=true, nullable=false)
	private int idCliente;

	@Column(name="nombre_cliente", nullable=false, length=30)
	private String nombreCliente;

	@Column(name="descripcion", nullable=true, length=400)
	private String descripcion;
		
	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}