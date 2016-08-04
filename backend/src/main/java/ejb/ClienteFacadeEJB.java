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
import facade.ClienteFacade;
import model.Cliente;

@Stateless
public class ClienteFacadeEJB extends AbstractFacade<Cliente> implements ClienteFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public ClienteFacadeEJB() {
		super(Cliente.class, "idCliente");
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<Cliente> q, CriteriaBuilder cb, Root<Cliente> t, MultivaluedMap<String, String> queryParams) {
		
		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA				
	}
	
	public boolean clienteExiste(Cliente entity) {	
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);		
		Root<Cliente> t = query.from(Cliente.class);
		TypedQuery<Cliente> tq;		
		
		query.where(cb.equal(t.<Integer>get("idCliente"), entity.getIdCliente()));
		tq = getEntityManager().createQuery(query);
		
		tq.setMaxResults(1);
		
		return tq.getResultList().size() > 0;

	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
