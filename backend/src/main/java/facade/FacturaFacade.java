package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.Factura;

@Local
public interface FacturaFacade {

	public void create(Factura entity);

	public void edit(Factura entity);

	public void remove(Factura entity);

	public Factura find(Object id);

	public List<Factura> findAll();
	
	public List<Factura> findAll(MultivaluedMap<String,String> queryParams);

	public Factura encontrarMasReciente();
	
	public List<Factura> findRange(int[] range);

	public int count();
	
	public boolean facturaExiste(Factura entity);


}
