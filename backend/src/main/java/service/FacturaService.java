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

import facade.FacturaFacade;
import model.Factura;


@Path("/facturas")
public class FacturaService {
	
	@EJB 
	FacturaFacade facturaFacadeEJB;

	Logger logger = Logger.getLogger(FacturaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Factura> findAll(){
		return facturaFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Factura find(@PathParam("id") Integer id) {
        return facturaFacadeEJB.find(id);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Factura entity) {
		facturaFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Factura entity) {
    	entity.setIdFactura(id.intValue());
    	facturaFacadeEJB.edit(entity);
    }
	
}
