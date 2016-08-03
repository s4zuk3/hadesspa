package facade;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface ClienteFacade {

	public void create(Cliente entity);

	public void edit(Cliente entity);

	public void remove(Cliente entity);

	public Cliente find(Object id);

	public List<Cliente> findAll();

	public List<Cliente> findRange(int[] range);

	public int count();

}
