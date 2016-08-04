package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.OrdenCompraFacade;
import model.OrdenCompra;

@Stateless
public class OrdenCompraFacadeEJB extends AbstractFacade<OrdenCompra> implements OrdenCompraFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public OrdenCompraFacadeEJB() {
		super(OrdenCompra.class, "idOrdenCompra");
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<OrdenCompra> q, CriteriaBuilder cb, Root<OrdenCompra> t, MultivaluedMap<String, String> queryParams) {
		
		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA				
	}
	

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
