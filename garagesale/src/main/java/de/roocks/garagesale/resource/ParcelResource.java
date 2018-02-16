package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.exception.EntityNotFoundException;
import de.roocks.garagesale.model.Parcel;
import de.roocks.garagesale.service.ParcelService;

@Path("parcels")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParcelResource {
	
	@Autowired
	private ParcelService parcelService;
	
	@POST
	public Response storeParcel(Parcel parcel, @Context UriInfo uriInfo) {
		Long id = parcelService.storeParcel(parcel);
		if (id == null)
			throw new EntityNotFoundException("Parcel can not be saved. Customer by id = " + parcel.getCustomerId() + " not found");
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Path("{id}") 
	public Response getParcelById(@PathParam ("id") Long id) throws EntityNotFoundException {
		Parcel parcel = parcelService.getParcelById(id);
		if (parcel == null)
			throw new EntityNotFoundException("Parcel by id = " + id +" not found.");
		return Response
				.ok(parcel)
				.build();	
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteParcelById(@PathParam ("id") Long id) {
		parcelService.deleteParcelById(id);
		return Response.ok().build();
	}
}
