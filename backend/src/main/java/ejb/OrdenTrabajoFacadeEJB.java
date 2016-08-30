package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.OrdenTrabajoFacade;
import model.OrdenTrabajo;
import model.Cotizacion;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.Date;

@Stateless
public class OrdenTrabajoFacadeEJB extends AbstractFacade<OrdenTrabajo> implements OrdenTrabajoFacade {


	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;

	public OrdenTrabajoFacadeEJB() {
		super(OrdenTrabajo.class, "idOrdenTrabajo");
	}

	public List<OrdenTrabajo> findAllByCotizacion(Cotizacion cotizacion){

		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<OrdenTrabajo> query = builder.createQuery(OrdenTrabajo.class);
		Root<OrdenTrabajo> tablaOrdenDeTrabajo = query.from(OrdenTrabajo.class);
		Join<OrdenTrabajo,Cotizacion> tablaOrdenDeTrabajoCotizacion = tablaOrdenDeTrabajo.join("idCotizacion");
		TypedQuery<OrdenTrabajo> tq;

		query.where(builder.equal(tablaOrdenDeTrabajoCotizacion.<Integer>get("idCotizacion"),cotizacion.getIdCotizacion()));

		tq = getEntityManager().createQuery(query);
		//tq.setMaxResults(1);

		return tq.getResultList();
	}

	public List<OrdenTrabajo> findAllByFecha(Date fecha){
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<OrdenTrabajo> query = builder.createQuery(OrdenTrabajo.class);
		Root<OrdenTrabajo> tablaOrdenDeTrabajo = query.from(OrdenTrabajo.class);
		TypedQuery<OrdenTrabajo> tq;

		query.where(builder.equal(tablaOrdenDeTrabajo.<Date>get("fecha"),fecha));

		tq = getEntityManager().createQuery(query);
		//tq.setMaxResults(1);

		return tq.getResultList();
	}

	public List<OrdenTrabajo> findAllByEstado(int estado){
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<OrdenTrabajo> query = builder.createQuery(OrdenTrabajo.class);
		Root<OrdenTrabajo> tablaOrdenDeTrabajo = query.from(OrdenTrabajo.class);
		TypedQuery<OrdenTrabajo> tq;

		query.where(builder.equal(tablaOrdenDeTrabajo.<Integer>get("estado"),estado));

		tq = getEntityManager().createQuery(query);
		//tq.setMaxResults(1);

		return tq.getResultList();
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<OrdenTrabajo> q, CriteriaBuilder cb, Root<OrdenTrabajo> t, MultivaluedMap<String, String> queryParams) {

		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA
	}


	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
