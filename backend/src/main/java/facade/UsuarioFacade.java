package facade;

import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.MultivaluedMap;

import model.Usuario;

@Local
public interface UsuarioFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Usuario find(Object id);

	public List<Usuario> findAll();
	
	public List<Usuario> findAll(MultivaluedMap<String,String> queryParams);

	public Usuario encontrarMasReciente();
	
	public List<Usuario> findRange(int[] range);

	public int count();
	
	public boolean usuarioExiste(Usuario entity);
	
	public Usuario login(int idUsuario, String contrasena);

}
