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
import de.roocks.garagesale.model.Product;
import de.roocks.garagesale.service.ProductService;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	@Autowired
	private ProductService productService;

	@POST
	public Response storeProduct(Product product, @Context UriInfo uriInfo) {
		Long id = productService.storeProduct(product);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}

	@GET
	@Path("{id}")
	public Response getProductById(@PathParam("id") Long id) throws EntityNotFoundException {
		Product product = productService.getProductById(id);
		if (product == null)
			throw new EntityNotFoundException("Product by id = " + id + " not found.");
		return Response.ok(product).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteProductById(@PathParam("id") Long id) {
		productService.deleteProductById(id);
		return Response.ok().build();
	}

}
