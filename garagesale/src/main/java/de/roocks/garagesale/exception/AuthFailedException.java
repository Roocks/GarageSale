package de.roocks.garagesale.exception;

import javax.ws.rs.WebApplicationException;

public class AuthFailedException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public AuthFailedException(String message) {
		super(message);
	}

}