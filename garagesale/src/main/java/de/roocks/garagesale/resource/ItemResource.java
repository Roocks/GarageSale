package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.model.Item;
import de.roocks.garagesale.service.ItemService;

@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	@Autowired
	private ItemService itemService;

	@POST
	@Path("item")
	public void storeItem(Item item) {
		itemService.storeItem(item);
	}

	@GET
	@Path("item")
	public void getItemById(@QueryParam("id") Long id) {
		itemService.getItemById(id);
	}

	@DELETE
	@Path("item")
	public void deleteItemById(@QueryParam("id") Long id) {
		itemService.deleteItemById(id);
	}
}
