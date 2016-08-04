package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente", unique=true, nullable=false)
	private Integer idCliente;

	@Column(name="nombre_cliente", nullable=false, length=30)
	private String nombreCliente;

	@Column(name="descripcion", nullable=true, length=400)
	private String descripcion;
		
	public Cliente() {
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
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
	
	@Override
	public boolean equals(Object a){
		return ((Cliente)a).idCliente == this.idCliente;
	}

	@Override
    	public int hashCode() {
    		return this.idCliente;
    	}
	
}