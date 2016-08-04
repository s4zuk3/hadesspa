package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.OrdenTrabajoFacade;
import model.OrdenTrabajo;

@Stateless
public class OrdenTrabajoFacadeEJB extends AbstractFacade<OrdenTrabajo> implements OrdenTrabajoFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public OrdenTrabajoFacadeEJB() {
		super(OrdenTrabajo.class, "idOrdenTrabajo");
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
