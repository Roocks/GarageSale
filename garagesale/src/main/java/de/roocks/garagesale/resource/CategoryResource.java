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
import de.roocks.garagesale.model.Category;
import de.roocks.garagesale.service.CategoryService;

@Path("categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@POST
	public Response storeCategory(Category category, @Context UriInfo uriInfo) {
		Long id = categoryService.storeCategory(category);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}

	@GET
	@Path("{id}")
	public Response getCategory(@PathParam("id") Long id) throws EntityNotFoundException {
		Category category = categoryService.getCategoryById(id);
		if (category == null)
			throw new EntityNotFoundException("Category by id = " + id + " not found.");
		return Response.ok(category).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCategoryById(@PathParam("id") Long id) {
		categoryService.deleteCategoryById(id);
		return Response.ok().build();
	}
}
