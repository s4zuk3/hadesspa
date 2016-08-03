package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.OrdenCompraFacade;
import model.OrdenCompra;

@Stateless
public class OrdenCompraFacadeEJB extends AbstractFacade<OrdenCompra> implements OrdenCompraFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public OrdenCompraFacadeEJB() {
		super(OrdenCompra.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
