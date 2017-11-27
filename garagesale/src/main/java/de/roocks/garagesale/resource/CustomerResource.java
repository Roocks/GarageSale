package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.model.Customer;
import de.roocks.garagesale.service.CustomerService;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@POST
	@Path("customer")
	public void addCustomer (Customer customer) {
		customerService.storeCustomer(customer);
	}
	
	@GET
	@Path("customer")
	public Customer getCustomerById(@QueryParam("id") Long id) {
		return customerService.getCustomerById(id);
	}
	
	@DELETE
	@Path("customer")
	public void deleteCustomerById(@QueryParam("id") Long id) {
		customerService.deleteCustomerById(id);
	}
	
	
	@PUT
	@Path("customer")
	public void addAddressToCustomer(	@QueryParam("customerId") Long customerId,
										@QueryParam("addressId") Long addressId){
		customerService.addAddressToCustomer(customerId, addressId);
	}
	
	@PUT
	@Path("customer/mainaddress")
	public void setMainaddress (	@QueryParam("customerId") Long customerId,
									@QueryParam ("addressId") Long addressId) {
		customerService.setMainaddress(customerId, addressId);
	}
}
