package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.Cliente;

@Local
public interface ClienteFacade {

	public void create(Cliente entity);

	public void edit(Cliente entity);

	public void remove(Cliente entity);

	public Cliente find(Object id);

	public List<Cliente> findAll();
	
	public List<Cliente> findAll(MultivaluedMap<String,String> queryParams);

	public Cliente encontrarMasReciente();
	
	public List<Cliente> findRange(int[] range);
	
	public boolean clienteExiste(Cliente entity);

	public int count();

}
