package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.OrdenCompra;

@Local
public interface OrdenCompraFacade {

	public void create(OrdenCompra entity);

	public void edit(OrdenCompra entity);

	public void remove(OrdenCompra entity);

	public OrdenCompra find(Object id);

	public List<OrdenCompra> findAll();
	
	public List<OrdenCompra> findAll(MultivaluedMap<String,String> queryParams);

	public OrdenCompra encontrarMasReciente();
	
	public List<OrdenCompra> findRange(int[] range);

	public int count();

}
