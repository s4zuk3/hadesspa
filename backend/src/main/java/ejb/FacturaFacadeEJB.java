package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.FacturaFacade;
import model.Factura;

@Stateless
public class FacturaFacadeEJB extends AbstractFacade<Factura> implements FacturaFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public FacturaFacadeEJB() {
		super(Factura.class, "idFactura");
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<Factura> q, CriteriaBuilder cb, Root<Factura> t, MultivaluedMap<String, String> queryParams) {
		
		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA				
	}
	
	public boolean facturaExiste(Factura entity) {	
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Factura> query = cb.createQuery(Factura.class);		
		Root<Factura> t = query.from(Factura.class);
		TypedQuery<Factura> tq;		
		
		query.where(cb.equal(t.<Integer>get("idFactura"), entity.getIdFactura()));
		tq = getEntityManager().createQuery(query);
		
		tq.setMaxResults(1);
		
		return tq.getResultList().size() > 0;
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
