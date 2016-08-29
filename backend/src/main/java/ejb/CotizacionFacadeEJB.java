package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import javax.ws.rs.core.MultivaluedMap;
import facade.AbstractFacade;
import facade.CotizacionFacade;
import model.Cotizacion;
import model.Usuario;

@Stateless
public class CotizacionFacadeEJB extends AbstractFacade<Cotizacion> implements CotizacionFacade {


	@PersistenceContext(unitName = "hadesAPI")
	private EntityManager em;

	public CotizacionFacadeEJB() {
		super(Cotizacion.class, "idCotizacion");
	}

	public List<Cotizacion> findAllByRut(Usuario user){
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cotizacion> query = cb.createQuery(Cotizacion.class);
		Root<Cotizacion> tablaCotizacion = query.from(Cotizacion.class);
		Join<Cotizacion,Usuario> tablaCotizacionUsuario = tablaCotizacion.join("id_usuario");
		TypedQuery<Cotizacion> tq;

		if(user == null){
			return null;
		}

		query.where(cb.equal(tablaCotizacionUsuario.<Integer>get("idUsuario"), user.getIdUsuario()));
		tq = getEntityManager().createQuery(query);
		//tq.setMaxResults(1);

		if(tq.getResultList().size() == 0){
			return null;
		}
		return tq.getResultList();
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
