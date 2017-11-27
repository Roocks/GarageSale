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

import de.roocks.garagesale.model.Category;
import de.roocks.garagesale.service.CategoryService;

@Path("categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;

	@POST
	@Path("category")
	public void storeCategory(Category category) {
		categoryService.storeCategory(category);
	}
	
	@GET
	@Path("category")
	public Category getCategory(@QueryParam ("id") Long id) {
		return categoryService.getCategoryById(id);
	}
	
	@DELETE
	@Path("category")
	public void deleteCategoryById(@QueryParam ("id") Long id) {
		categoryService.deleteCategoryById(id);
	}
}
