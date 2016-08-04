package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="factura")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura", unique=true, nullable=false)
	private int idFactura;

	@ManyToOne @JoinColumn(name="id_ot", nullable=false)
	private OrdenTrabajo idOrdenTrabajo;

	@ManyToOne @JoinColumn(name="id_cliente", nullable=false)
	private Cliente idCliente;

	@Column(name="fecha_emision", nullable=false)
	private Date fecha;
	
	@Column(name="estado_factura", nullable=false)
	private int estado;

	@Column(name="monto_factura", nullable=false)
	private int monto;
	
	public Factura() {
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public OrdenTrabajo getIdOrdenTrabajo() {
		return idOrdenTrabajo;
	}

	public void setIdOrdenTrabajo(OrdenTrabajo idOrdenTrabajo) {
		this.idOrdenTrabajo = idOrdenTrabajo;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
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

	@Override
	public boolean equals(Object a){
		return ((Factura)a).idFactura == this.idFactura;
	}

	@Override
    	public int hashCode() {
    		return this.idFactura;
    	}
	
}