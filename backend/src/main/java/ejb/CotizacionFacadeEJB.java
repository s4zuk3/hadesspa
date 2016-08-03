package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.CotizacionFacade;
import model.Cotizacion;

@Stateless
public class CotizacionFacadeEJB extends AbstractFacade<Cotizacion> implements CotizacionFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public CotizacionFacadeEJB() {
		super(Cotizacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
