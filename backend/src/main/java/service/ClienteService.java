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

import facade.ClienteFacade;
import model.Cliente;


@Path("/clientes")
public class ClienteService {
	
	@EJB 
	ClienteFacade clienteFacadeEJB;

	Logger logger = Logger.getLogger(ClienteService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Cliente> findAll(){
		return clienteFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Cliente find(@PathParam("id") Integer id) {
        return clienteFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Cliente entity) {
		clienteFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Cliente entity) {
    	entity.setIdCliente(id.intValue());
    	clienteFacadeEJB.edit(entity);
    }
	
}
