package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="ot")
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "oc_ot", joinColumns = { @JoinColumn(name = "id_oc") }, inverseJoinColumns = {
			@JoinColumn(name = "id_ot") })
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

	@Override
	public boolean equals(Object a){
		return ((OrdenTrabajo)a).idOrdenTrabajo == this.idOrdenTrabajo;
	}

	@Override
    	public int hashCode() {
    		return this.idOrdenTrabajo;
    	}

}
