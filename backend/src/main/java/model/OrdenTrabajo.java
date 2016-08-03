package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="ot")
@NamedQuery(name="OrdenTrabajo.findAll", query="SELECT a FROM OrdenTrabajo a")
public class OrdenTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ot", unique=true, nullable=false)
	private int idOrdenTrabajo;

	@ManyToOne @JoinColumn(name="id_cotizacion", nullable=false)
	private Cotizacion idCotizacion;

	@Column(name="fecha_creacion_ot", nullable=false)
	private Date fecha;
	
	@Column(name="estado_ot", nullable=false)
	private int estado;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "oc_ot", joinColumns = { @JoinColumn(name = "id_ot") }, inverseJoinColumns = {
			@JoinColumn(name = "id_oc") })
	private List<OrdenCompra> listaOrdenCompra;
	
	public OrdenTrabajo() {
	}

	public int getIdOrdenTrabajo() {
		return idOrdenTrabajo;
	}

	public void setIdOrdenTrabajo(int idOrdenTrabajo) {
		this.idOrdenTrabajo = idOrdenTrabajo;
	}

	public Cotizacion getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Cotizacion idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<OrdenCompra> getListaOrdenCompra() {
		return listaOrdenCompra;
	}

	public void setListaOrdenCompra(List<OrdenCompra> listaOrdenCompra) {
		this.listaOrdenCompra = listaOrdenCompra;
	}

	
}