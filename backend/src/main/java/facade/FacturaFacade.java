package facade;

import java.util.List;

import javax.ejb.Local;

import model.Factura;

@Local
public interface FacturaFacade {

	public void create(Factura entity);

	public void edit(Factura entity);

	public void remove(Factura entity);

	public Factura find(Object id);

	public List<Factura> findAll();

	public List<Factura> findRange(int[] range);

	public int count();

}
