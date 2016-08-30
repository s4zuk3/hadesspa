package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.Cotizacion;
import model.Usuario;


@Local
public interface CotizacionFacade {

	public void create(Cotizacion entity);

	public void edit(Cotizacion entity);

	public void remove(Cotizacion entity);

	public Cotizacion find(Object id);

	public List<Cotizacion> findAllByRut(Usuario user);

	public List<Cotizacion> findAll();

	public List<Cotizacion> findAll(MultivaluedMap<String,String> queryParams);

	public Cotizacion encontrarMasReciente();

	public List<Cotizacion> findRange(int[] range);

	public int count();

}
