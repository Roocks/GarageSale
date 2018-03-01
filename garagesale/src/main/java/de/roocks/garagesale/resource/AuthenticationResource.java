package de.roocks.garagesale.resource;

import java.security.SecureRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.exception.AuthFailedException;
import de.roocks.garagesale.model.Credentials;
import de.roocks.garagesale.model.Customer;
import de.roocks.garagesale.model.Token;
import de.roocks.garagesale.service.CustomerService;
import de.roocks.garagesale.service.TokenService;

@Path("authentication")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class AuthenticationResource {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TokenService tokenService;
	
	private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int TOKEN_LENGTH = 32;
	private static SecureRandom RANDOM = new SecureRandom();

	@POST
	public Response autheticateUser(Credentials credentials) {

		String username = credentials.getUsername();
		String password = credentials.getPassword();
		Customer customer = authenticate(username, password);	
		Token token = new Token();
		token.setValue(createRandomString(TOKEN_LENGTH));
		token.setCustomer(customer);
		tokenService.storeToken(token);
		return Response.ok(token.getValue()).build();

	}

	private String createRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length-1; i++) {
			sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
		}
		return sb.toString();
	}

	private Customer authenticate(String username, String password) {		
		Customer customer = customerService.findUserByUsername(username);
		if (customer == null)
			throw new AuthFailedException("User-ID not found");
		if (!password.equals(customer.getPassword()))
			throw new AuthFailedException("Password is wrong");
		return customer;
	}
}
