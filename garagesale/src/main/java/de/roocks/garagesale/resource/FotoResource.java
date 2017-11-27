package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.service.FotoService;

@Path("fotos")
@Consumes("image/jpeg")
@Produces("image/jpeg")
public class FotoResource {

	@Autowired
	private FotoService fotoService;

	@POST
	@Path("foto")
	public void storeFoto(byte[] data, @HeaderParam("ProductID") Long productId) {
		fotoService.storeFoto(productId, data);
	}
	
	@GET
	@Path("foto")
	public byte[] getFoto(@QueryParam ("id") Long id) {
		return fotoService.getFoto(id);
	}
	
	@DELETE
	@Path("foto")
	public void deleteFoto(@QueryParam ("id") Long id) {
		fotoService.deleteFoto(id);
	}
}
