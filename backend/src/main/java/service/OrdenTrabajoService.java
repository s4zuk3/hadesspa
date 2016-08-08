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

import facade.OrdenTrabajoFacade;
import model.OrdenTrabajo;
import util.MensajeRespuesta;


@Path("/ordentrabajos")
@TokenAuthenticated
public class OrdenTrabajoService {
	
	@EJB 
	OrdenTrabajoFacade ordentrabajoFacadeEJB;

	Logger logger = Logger.getLogger(OrdenTrabajoService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<OrdenTrabajo> findAll(@Context UriInfo ui){
		return ordentrabajoFacadeEJB.findAll(ui.getQueryParameters());
	
	}

	@GET
	@Path("{idOrdenTrabajo: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idOrdenTrabajo") Integer idOrdenTrabajo){				
		OrdenTrabajo a = ordentrabajoFacadeEJB.find(idOrdenTrabajo);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("OrdenTrabajo ID = "+idOrdenTrabajo+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(OrdenTrabajo entity) {
		ordentrabajoFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, OrdenTrabajo entity) {
    	entity.setIdOrdenTrabajo(id.intValue());
    	ordentrabajoFacadeEJB.edit(entity);
    }
	
}
