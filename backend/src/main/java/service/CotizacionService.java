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

import facade.CotizacionFacade;
import model.Cotizacion;
import util.MensajeRespuesta;


@Path("/cotizacions")
@TokenAuthenticated
public class CotizacionService {
	
	@EJB 
	CotizacionFacade cotizacionFacadeEJB;

	Logger logger = Logger.getLogger(CotizacionService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Cotizacion> findAll(@Context UriInfo ui){
		return cotizacionFacadeEJB.findAll(ui.getQueryParameters());
	
	}

	@GET
	@Path("{idCotizacion: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public Response find(@PathParam("idCotizacion") Integer idCotizacion){				
		Cotizacion a = cotizacionFacadeEJB.find(idCotizacion);
		if(a == null){
			return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Cotizacion ID = "+idCotizacion+" no encontrada.")).build();		
		}		
		return Response.status(Status.OK).entity(a).build();		
	}
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Cotizacion entity) {
		cotizacionFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Cotizacion entity) {
    	entity.setIdCotizacion(id.intValue());
    	cotizacionFacadeEJB.edit(entity);
    }
	
}
