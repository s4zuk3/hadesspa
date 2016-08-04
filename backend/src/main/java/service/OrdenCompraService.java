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

import facade.OrdenCompraFacade;
import model.OrdenCompra;
import util.MensajeRespuesta;


@Path("/ordencompras")
public class OrdenCompraService {
	
	@EJB 
	OrdenCompraFacade ordencompraFacadeEJB;

	Logger logger = Logger.getLogger(OrdenCompraService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<OrdenCompra> findAll(@Context UriInfo ui){
		return ordencompraFacadeEJB.findAll(ui.getQueryParameters());
	
	}

	@GET
	@Path("{idOrdenCompra: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idOrdenCompra") Integer idOrdenCompra){				
		OrdenCompra a = ordencompraFacadeEJB.find(idOrdenCompra);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("OrdenCompra ID = "+idOrdenCompra+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(OrdenCompra entity) {
		ordencompraFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, OrdenCompra entity) {
    	entity.setIdOrdenCompra(id.intValue());
    	ordencompraFacadeEJB.edit(entity);
    }
	
}
