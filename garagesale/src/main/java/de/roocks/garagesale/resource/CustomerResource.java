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
import de.roocks.garagesale.model.Customer;
import de.roocks.garagesale.service.CustomerService;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@Autowired
	private CustomerService customerService;

	@POST
	public Response addCustomer(Customer customer, @Context UriInfo uriInfo) {
		Long id = customerService.storeCustomer(customer);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(id));
		return Response.created(builder.build()).build();
	}

	@GET
	@Path("{id}")
	public Response getCustomerById(@PathParam("id") Long id) throws EntityNotFoundException {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null)
			throw new EntityNotFoundException("Customer by id = " + id + " not found.");
		return Response.ok(customer).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCustomerById(@PathParam("id") Long id) {
		customerService.deleteCustomerById(id);
		return Response.ok().build();
	}
}
