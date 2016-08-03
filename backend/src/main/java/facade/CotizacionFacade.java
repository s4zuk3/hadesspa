package facade;

import java.util.List;

import javax.ejb.Local;

import model.Cotizacion;

@Local
public interface CotizacionFacade {

	public void create(Cotizacion entity);

	public void edit(Cotizacion entity);

	public void remove(Cotizacion entity);

	public Cotizacion find(Object id);

	public List<Cotizacion> findAll();

	public List<Cotizacion> findRange(int[] range);

	public int count();

}
