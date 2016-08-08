package service;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.auth0.jwt.JWTVerifier;

import util.MensajeRespuesta;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;

@TokenAuthenticated
@Provider
public class AuthenticationFilter implements ContainerRequestFilter{

	private final String secret = "mypassword";
	@Override
    public void filter(ContainerRequestContext requestContext) throws IOException{
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(MensajeRespuesta.crear("Not AUTHORIZATION found.")).build());
			return;
		}
		String jwt = authorizationHeader.substring("Bearer".length()).trim();
		try {
		    final JWTVerifier verifier = new JWTVerifier(secret);
		    final Map<String,Object> claims= verifier.verify(jwt);
		} catch (Exception e) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).entity(MensajeRespuesta.crear("Token Inválido.")).build());		
		}
		
    }
}
