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

import de.roocks.garagesale.model.Product;
import de.roocks.garagesale.service.ProductService;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@POST
	@Path("product")
	public void storeProduct(Product product) {
		productService.storeProduct(product);
	}
	
	@GET
	@Path("product")
	public Product getProductById(@QueryParam ("id") Long id) {
		return productService.getProductById(id);
	}
	
	@DELETE
	@Path("product")
	public void deleteProductById(@QueryParam("id") Long id) {
		productService.deleteProductById(id);
	}

}
