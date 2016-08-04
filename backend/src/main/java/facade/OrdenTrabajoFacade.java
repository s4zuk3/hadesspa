package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.OrdenTrabajo;

@Local
public interface OrdenTrabajoFacade {

	public void create(OrdenTrabajo entity);

	public void edit(OrdenTrabajo entity);

	public void remove(OrdenTrabajo entity);

	public OrdenTrabajo find(Object id);

	public List<OrdenTrabajo> findAll();
	
	public List<OrdenTrabajo> findAll(MultivaluedMap<String,String> queryParams);

	public OrdenTrabajo encontrarMasReciente();
	
	public List<OrdenTrabajo> findRange(int[] range);

	public int count();

}
