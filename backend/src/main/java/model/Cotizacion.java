package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="cotizacion")
@NamedQuery(name="Cotizacion.findAll", query="SELECT a FROM Cotizacion a")
public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cotizacion", unique=true, nullable=false)
	private int idCotizacion;

	@ManyToOne @JoinColumn(name="id_usuario", nullable=false)
	private int id_usuario;

	@Column(name="fecha", nullable=false)
	private Date fecha;

	public Cotizacion() {
	}

	public int getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}