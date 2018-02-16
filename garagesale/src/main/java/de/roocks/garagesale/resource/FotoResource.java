package de.roocks.garagesale.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.exception.EntityNotFoundException;
import de.roocks.garagesale.service.FotoService;

@Path("fotos")
@Consumes("image/jpeg")
@Produces("image/jpeg")
public class FotoResource {

	@Autowired
	private FotoService fotoService;

	@POST
	public Response storeFoto(byte[] data, @HeaderParam ("productId") Long productId, @Context UriInfo uriInfo) {
		Long id = fotoService.storeFoto(productId, data);
		if (id == null)
			throw new EntityNotFoundException("Foto could not be saved. Product by id = " + productId +" not found");
		URI resource = uriInfo.getAbsolutePathBuilder().path(Long.toString(id)).build();
		return Response.created(resource).build();
	}

	@GET
	@Path("{id}")
	public Response getFoto(@PathParam("id") Long id) throws EntityNotFoundException {
		byte[] foto = fotoService.getFoto(id);
		if (foto == null)
			throw new EntityNotFoundException("Foto by id = " + id + " not found.");
		return Response.ok(foto).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteFoto(@PathParam("id") Long id) {
		fotoService.deleteFoto(id);
		return Response.ok().build();
	}
}
