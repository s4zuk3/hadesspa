package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.FacturaFacade;
import model.Factura;

@Stateless
public class FacturaFacadeEJB extends AbstractFacade<Factura> implements FacturaFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public FacturaFacadeEJB() {
		super(Factura.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
