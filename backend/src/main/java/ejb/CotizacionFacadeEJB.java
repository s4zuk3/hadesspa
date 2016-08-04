package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.CotizacionFacade;
import model.Cotizacion;

@Stateless
public class CotizacionFacadeEJB extends AbstractFacade<Cotizacion> implements CotizacionFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public CotizacionFacadeEJB() {
		super(Cotizacion.class, "idCotizacion");
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<Cotizacion> q, CriteriaBuilder cb, Root<Cotizacion> t, MultivaluedMap<String, String> queryParams) {
		
		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA				
	}
	

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
