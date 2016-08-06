package service;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NameBinding;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.auth0.jwt.JWTSigner;

import javax.ws.rs.core.Response.Status;

import facade.UsuarioFacade;
import model.Usuario;
import model.Credential;
import util.MensajeRespuesta;
import util.MensajeToken;


@Path("/auth")
public class AuthenticateService {
	
	@EJB 
	UsuarioFacade usuarioFacadeEJB;

	Logger logger = Logger.getLogger(AuthenticateService.class.getName());
	
	@POST
	@Path("/login")
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	public Response login(Credential credential){
		Usuario u = usuarioFacadeEJB.login(credential.getIdUsuario(),credential.getContrasena());
		if(u == null){
			return Response.status(Status.UNAUTHORIZED).entity(MensajeRespuesta.crear("Error de credenciales.")).build();			
		}
		// return JWT
		final String secret = "mypassword";
		
		final long iat = System.currentTimeMillis() / 1000l; // issued at claim 
		final long exp = iat + 64800L; // 18 horas de expiracion 

		final JWTSigner signer = new JWTSigner(secret);
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("exp", exp);
		claims.put("iat", iat);
		claims.put("idUsuario",u.getIdUsuario());
		claims.put("cargo",u.getCargo());
		claims.put("nombreUsuario",u.getNombreUsuario());
		final String jwt = signer.sign(claims);
		return Response.status(Status.OK).entity(MensajeToken.crear(jwt)).build();			
	}
	
	
	//
	//@GET
	//@Produces({"application/xml", "application/json"})
	//public List<Usuario> findAll(@Context UriInfo ui){
	//	return usuarioFacadeEJB.findAll(ui.getQueryParameters());
	
	//}

	//@GET
	//@Path("{idUsuario: [0-9]+}")
	//@Produces({"application/xml", "application/json"})
	//public Response find(@PathParam("idUsuario") Integer idUsuario){				
	//	Usuario a = usuarioFacadeEJB.find(idUsuario);
	//	if(a == null){
	//		return Response.status(Status.FORBIDDEN).entity(MensajeRespuesta.crear("Usuario ID = "+idUsuario+" no encontrada.")).build();		
	//	}		
	//	return Response.status(Status.OK).entity(a).build();		
	//}
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
