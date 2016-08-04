package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="oc")
public class OrdenCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_oc", unique=true, nullable=false)
	private int idOrdenCompra;

	@Column(name="fecha_creacion_oc", nullable=false)
	private Date fecha;
	
	@Column(name="estado_oc", nullable=false)
	private int estado;

	@Column(name="monto_oc", nullable=false)
	private int monto;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "listaOrdenCompra")
	private List<OrdenTrabajo> listaOrdenTrabajo;	
	
	public OrdenCompra() {
	}

	public int getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(int idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
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

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public List<OrdenTrabajo> getListaOrdenTrabajo() {
		return listaOrdenTrabajo;
	}

	public void setListaOrdenTrabajo(List<OrdenTrabajo> listaOrdenTrabajo) {
		this.listaOrdenTrabajo = listaOrdenTrabajo;
	}

	@Override
	public boolean equals(Object a){
		return ((OrdenCompra)a).idOrdenCompra == this.idOrdenCompra;
	}

	@Override
    	public int hashCode() {
    		return this.idOrdenCompra;
    	}
	
	
}