package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.OrdenTrabajoFacade;
import model.OrdenTrabajo;

@Stateless
public class OrdenTrabajoFacadeEJB extends AbstractFacade<OrdenTrabajo> implements OrdenTrabajoFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public OrdenTrabajoFacadeEJB() {
		super(OrdenTrabajo.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
