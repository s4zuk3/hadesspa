package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import facade.AbstractFacade;
import facade.ClienteFacade;
import model.Cliente;

@Stateless
public class ClienteFacadeEJB extends AbstractFacade<Cliente> implements ClienteFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public ClienteFacadeEJB() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
