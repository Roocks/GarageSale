package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.service.FotoService;



@Path("foto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FotoResource {
	
	@Autowired
	private FotoService fotoService;

}
