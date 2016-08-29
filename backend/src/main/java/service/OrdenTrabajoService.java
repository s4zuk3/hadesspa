package service;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import javax.ws.rs.core.GenericEntity;

import facade.OrdenTrabajoFacade;
import facade.UsuarioFacade;
import facade.CotizacionFacade;
import model.OrdenTrabajo;
import model.Usuario;
import model.Cotizacion;
import util.MensajeRespuesta;

import javax.ws.rs.client.Entity;


@Path("/ordentrabajos")
@TokenAuthenticated
public class OrdenTrabajoService {

	@EJB
	OrdenTrabajoFacade ordentrabajoFacadeEJB;

	@EJB
	UsuarioFacade usuarioFacadeEJB;

	@EJB
	CotizacionFacade cotizacionFacadeEJB;

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


	// Busca una OT por la id de una cotización
	@GET
	@Path("buscarporcotizacion/{idCotizacion: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public List<OrdenTrabajo> find_id_cotizacion(@PathParam("idCotizacion") Integer idCotizacion){
		Cotizacion cotiza = cotizacionFacadeEJB.find(idCotizacion);
		return ordentrabajoFacadeEJB.findAllByCotizacion(cotiza);
	}

	// Busca una OT por la fecha de OT
	@GET
	@Path("buscarporfecha/{fechaOT:[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]}")
	@Produces({"application/xml", "application/json"})
	public List<OrdenTrabajo> find_fecha(@PathParam("fechaOT") String fechaOT){
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha;
		try{
				fecha = formato.parse(fechaOT);
		}catch(Exception e){
				return null;
		}
		return ordentrabajoFacadeEJB.findAllByFecha(fecha);
	}

	// Busca una OT por el estado de una OT
	@GET
	@Path("buscarporestado/{estado_ot: [0-9]+}")
	@Produces({"application/xml", "application/json"})
	public List<OrdenTrabajo> find_estado(@PathParam("estado_ot") Integer estado){
		return ordentrabajoFacadeEJB.findAllByEstado(estado);
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
