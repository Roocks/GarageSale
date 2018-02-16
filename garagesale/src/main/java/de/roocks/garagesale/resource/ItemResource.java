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
import de.roocks.garagesale.model.Item;
import de.roocks.garagesale.service.ItemService;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@POST
	public Response storeItem(Item item, @Context UriInfo uriInfo) {
		Long id = itemService.storeItem(item);
		if (id == null)
			throw new EntityNotFoundException("Item could not be stored. ParcelId or ProductId are wrong");

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}

	@GET
	@Path("{id}")
	public Response getItemById(@PathParam("id") Long id) throws EntityNotFoundException {
		Item item = itemService.getItemById(id);
		if (item == null)
			throw new EntityNotFoundException("Item by id = " + id +" not found.");
		return Response
				.ok(item)
				.build();	
	}

	@DELETE
	@Path("{id}")
	public Response deleteItemById(@PathParam("id") Long id) {
		itemService.deleteItemById(id);
		return Response.ok().build();
	}
}
