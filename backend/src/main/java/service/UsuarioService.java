package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import facade.UsuarioFacade;
import model.Usuario;
import util.MensajeRespuesta;


@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade usuarioFacadeEJB;

	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(@Context UriInfo ui){
		return usuarioFacadeEJB.findAll(ui.getQueryParameters());
	
	}

	@GET
	@Path("{idUsuario: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idUsuario") Integer idUsuario){				
		Usuario a = usuarioFacadeEJB.find(idUsuario);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Usuario ID = "+idUsuario+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	/*
	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	public Response create(Usuario nuevoUsuario){
		if(usuarioFacadeEJB.usuarioExiste(nuevoUsuario)){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Ya existe un usuario con el rut "+nuevoUsuario.getIdUsuario())).build();			
		}
		usuarioFacadeEJB.create(nuevoUsuario);
		return Response.status(Status.OK).build();
	}
	*/
	/*
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setIdUsuario(id.intValue());
    	usuarioFacadeEJB.edit(entity);
    }
	*/
}
