package de.roocks.garagesale.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GSExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException e) {
		
		ResourceError resourceError = new ResourceError();

		if (e instanceof EntityNotFoundException) {
			resourceError.setCode(Response.Status.NOT_FOUND.getStatusCode());
			resourceError.setMessage(e.getMessage());
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(resourceError)
					.type(MediaType.APPLICATION_JSON_TYPE)
					.build();
		}
		
		return Response
				.status(503)
				.entity(resourceError)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}

}
