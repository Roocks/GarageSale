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
import de.roocks.garagesale.model.Address;
import de.roocks.garagesale.service.AddressService;

@Path("addresses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

	@Autowired
	private AddressService addressService;

	@POST
	public Response storeAddress(Address address, @Context UriInfo uriInfo) {
		Long id = addressService.storeAddress(address);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}

	@GET
	@Path("{id}")
	public Response getAddressById(@PathParam("id") Long id) throws EntityNotFoundException {
		Address address = addressService.getAddressById(id);
		if (address == null)
			throw new EntityNotFoundException("Address by id = " + id + " not found.");
		return Response.ok(address).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteAddressById(@PathParam("id") Long id) throws EntityNotFoundException {
		addressService.deleteAddressById(id);
		return Response.ok().build();
	}
}
