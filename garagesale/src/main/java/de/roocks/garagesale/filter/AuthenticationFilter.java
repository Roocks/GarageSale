package de.roocks.garagesale.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.annotations.Secured;
import de.roocks.garagesale.exception.AuthFailedException;
import de.roocks.garagesale.service.TokenService;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	private static final String AUTH_SCHEME = "Bearer";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String header = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		String value = header.substring(AUTH_SCHEME.length()).trim();
		if (!tokenService.isValidToken(value)) {
			throw new AuthFailedException("Token is not valid");
		}
	}

}
