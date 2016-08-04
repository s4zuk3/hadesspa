package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;
import javax.persistence.TypedQuery;
import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Usuario;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class, "idUsuario");
	}

	@Override
	protected void obtenerParametrosURL(CriteriaQuery<Usuario> q, CriteriaBuilder cb, Root<Usuario> t, MultivaluedMap<String, String> queryParams) {
		
		if(queryParams == null) return;
		else return; // SIN LOGICA POR AHORA				
	}
	
	public boolean usuarioExiste(Usuario entity) {	
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);		
		Root<Usuario> t = query.from(Usuario.class);
		TypedQuery<Usuario> tq;		
		
		query.where(cb.equal(t.<Integer>get("idUsuario"), entity.getIdUsuario()));
		tq = getEntityManager().createQuery(query);
		
		tq.setMaxResults(1);
		
		return tq.getResultList().size() > 0;

	}
	
	//TEST
	public Usuario login(int idUsuario, String contrasena){		
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);		
		Root<Usuario> t = query.from(Usuario.class);
		TypedQuery<Usuario> tq;		
		
		query.where(
				cb.and(
							cb.equal(t.<Integer>get("idUsuario"), idUsuario), 
							cb.equal(t.<String>get("contrasena"), contrasena)
						)
				);
		
		tq = getEntityManager().createQuery(query);
		tq.setMaxResults(1);
		
		if(tq.getResultList().size() == 1){
			return tq.getResultList().get(0);
		}		
		
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
}
