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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import util.MensajeRespuesta;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;

import facade.FacturaFacade;
import model.Factura;


@Path("/facturas")
public class FacturaService {
	
	@EJB 
	FacturaFacade facturaFacadeEJB;

	Logger logger = Logger.getLogger(FacturaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Factura> findAll(@Context UriInfo ui){
		return facturaFacadeEJB.findAll(ui.getQueryParameters());
	
	}

	@GET
	@Path("{idFactura: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idFactura") Integer idFactura){				
		Factura a = facturaFacadeEJB.find(idFactura);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Factura ID = "+idFactura+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	

	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	public Response create(Factura entity){
		if(facturaFacadeEJB.facturaExiste(entity)){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Ya existe una factura con el id "+entity.getIdFactura())).build();			
		}
		facturaFacadeEJB.create(entity);
		return Response.status(Status.OK).build();
	}
	
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Factura entity) {
    	entity.setIdFactura(id.intValue());
    	facturaFacadeEJB.edit(entity);
    }
	
}
