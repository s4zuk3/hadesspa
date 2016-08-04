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

import facade.ClienteFacade;
import model.Cliente;
import util.MensajeRespuesta;


@Path("/clientes")
public class ClienteService {
	
	@EJB 
	ClienteFacade clienteFacadeEJB;

	Logger logger = Logger.getLogger(ClienteService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Cliente> findAll(@Context UriInfo ui){
		return clienteFacadeEJB.findAll(ui.getQueryParameters());
	
	}
	
	@GET
	@Path("{idCliente: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idCliente") Integer idCliente){				
		Cliente a = clienteFacadeEJB.find(idCliente);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Cliente ID = "+idCliente+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	
	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	public Response create(Cliente nuevoCliente){
		if(clienteFacadeEJB.clienteExiste(nuevoCliente)){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Ya existe un cliente con el rut "+nuevoCliente.getIdCliente())).build();			
		}
		clienteFacadeEJB.create(nuevoCliente);
		return Response.status(Status.OK).build();
	}
	
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
    	entity.setIdCliente(id.intValue());
    	clienteFacadeEJB.edit(entity);
    }
	
}
